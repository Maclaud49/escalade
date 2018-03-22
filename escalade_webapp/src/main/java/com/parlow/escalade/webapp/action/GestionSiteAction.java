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
        return listRegions;
    }
    public void setListRegions(List<String> listRegions) {
        this.listRegions = listRegions;
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
                Utilisateur utilisateur = managerFactory.getUtilisateurManager().findById(2);
                logger.error("nom du utilisateur" + utilisateur.getNom());
                logger.error("email du utilisateur" + utilisateur.getEmail());
                logger.error("region du site" + site.getRegion());
                logger.error("region du nom" + site.getNom());
                logger.error("region du image" + site.getImage());
                logger.error("region du datecreation" + site.getDateCreation());
                logger.error("region du lastupdate" + site.getDateCreation());
                logger.error("region du site" + site.getUtilisateur());

               // logger.error("id du utilisateur" + site.getUtilisateur().getId());
                //logger.error("nom du utilisateur" + site.getUtilisateur().getNom());
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
        // Si (this.site == null) c'est que l'on entre dans l'ajout de site
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
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
                    // Sur erreur fonctionnelle on reste sur la page de saisie
                    // et on affiche un message d'erreur
                    this.addActionError(pEx.getMessage());

                } catch (TechnicalException pEx) {
                    // Sur erreur technique on part sur le result "error"
                    this.addActionError(pEx.getMessage());
                    vResult = ActionSupport.ERROR;
                }
        }

        // Si on doit aller sur le formulaire de saisie, il faut ajouter les info nécessaires
        if (vResult.equals(ActionSupport.INPUT)) {
            this.listRegions = Arrays.asList("Grand-Est", "Nouvelle-Aquitaine", "Auvergne-Rhône-Alpes","Bourgogne-Franche-Comté",
            "Bretagne", "Centre-Val de Loire", "Corse", "Île-de-France", "Occitanie", "Hauts-de-France", "Normandie",
            "Pays de la Loire", "Provence-Alpes-Côte d'Azur");
           /* Utilisateur user = new Utilisateur();
            try {
                 user = managerFactory.getUtilisateurManager().findById(3);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("user present en base et trouvable" + user.getNom());
            System.out.println("user.adresse present en base et trouvable" + user.getAdresse().getAdresse1());

            Site site2 = new Site();
            try {
                site2 = managerFactory.getSiteManager().findById(4);
            } catch (NotFoundException e) {
                e.printStackTrace();
            }
            System.out.println("site.user present en base et trouvable nom " + site2.getUtilisateur().getNom());
            System.out.println("site.user present en base et trouvable id " + site2.getUtilisateur().getId());*/
        }

        return vResult;
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
