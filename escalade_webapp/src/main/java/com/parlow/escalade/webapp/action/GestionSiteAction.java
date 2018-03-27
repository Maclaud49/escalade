package com.parlow.escalade.webapp.action;

import java.util.*;
import java.sql.Timestamp;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.deleted.Image;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.deleted.Region;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


/**
 * Action de gestion des {@link Site}
 */
public class GestionSiteAction extends ActionSupport implements ServletRequestAware, SessionAware {




    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;
    private Map<String, Object> session;
    private HttpServletRequest servletRequest;

    private static final Logger logger = LogManager.getLogger(GestionSiteAction.class);


    // ----- Paramètres en entrée
    private Integer id;
    private Date createdDate;
    private Date lastUpdate;

    // ----- Eléments en sortie
    private List<Site> listSite;
    private List<String> listRegions;
    private Site site;
    private List<Utilisateur> listUtilisateur;

    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public List<Site> getListSite() {
        return listSite;
    }
    public Site getSite() {
        return site;
    }
    public void setSite(Site pSite){
        site = pSite;
    }
    public List<Utilisateur> getListUtilisateur() {
        return listUtilisateur;
    }
    public List<String> getListRegions() {
        if(this.listRegions==null){
            this.listRegions=selectRegion();
        }
        return listRegions;
    }
    public void setListRegions(List<String> listRegions) {
        this.listRegions = listRegions;
    }
    public Date getCreatedDate() {
        return createdDate;
    }
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
    public Date getLastUpdate() {
        return lastUpdate;
    }
    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }
    // ==================== Méthodes ====================
    /**
     * Action listant les {@link Site}
     * @return success
     */
    public String doList() {
        listSite = managerFactory.getSiteManager().findAll();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Site}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError(getText("error.site.missing.id"));
        } else {
            try {
                logger.error("id du site" + id);

                site = managerFactory.getSiteManager().findById(id);
                this.createdDate = site.getDateCreation();
                this.lastUpdate = site.getLastUpdate();
                logger.error("id du utilisateur" + site.getUtilisateur().getId());
                logger.error("nom du utilisateur" + site.getUtilisateur().getNom());
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.site.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
    /**
     * Action permettant de créer un nouveau {@link Site}
     * @return input / success / error
     */
    public String doCreate() {
        logger.error("I m here");

        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de site (site != null)
        if (this.site != null) {
            Date date = new Date();
            this.site.setUtilisateur((Utilisateur)this.session.get("user"));
            this.site.setDateCreation(new Timestamp(date.getTime()));
                try {
                    if(this.site.getImage()==null){
                        String image = "../../ressources/images/750x300.png";
                        this.site.setImage(image);
                    }
                    this.site.setId(managerFactory.getSiteManager().insert(this.site));
                    vResult = ActionSupport.SUCCESS;
                    this.addActionMessage("Site ajouté avec succès");

                } catch (FunctionalException pEx) {
                    this.addActionError(pEx.getMessage());

                } catch (TechnicalException pEx) {

                    this.addActionError(pEx.getMessage());
                    vResult = ActionSupport.ERROR;
                }
        }

        //Ajout des infos nécessaires pour le formulaire de saisie
        if (vResult.equals(ActionSupport.INPUT)) {
            this.listRegions = selectRegion();
        }
        return vResult;
    }

    public List<String> selectRegion(){
        List<String> list = new ArrayList<>();
        list =  Arrays.asList("Grand-Est", "Nouvelle-Aquitaine", "Auvergne-Rhône-Alpes","Bourgogne-Franche-Comté",
                "Bretagne", "Centre-Val de Loire", "Corse", "Île-de-France", "Occitanie", "Hauts-de-France", "Normandie",
                "Pays de la Loire", "Provence-Alpes-Côte d'Azur");
        return list;
    }

    @Override
    public void validate() {
        if (this.site != null) {
            if (site.getNom().length() < 3) {

                addFieldError("siteNom", "Le nom du site doit faire au moins 3 lettres");
            }
        }
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    @Override
    public void setServletRequest(HttpServletRequest pRequest) {
        this.servletRequest = pRequest;
    }

}
