package com.parlow.escalade.webapp.action;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.sql.Timestamp;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;


/**
 * Action de gestion des {@link Site}
 */
public class GestionSiteAction extends ActionSupport implements  SessionAware {




    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;
    private Map<String, Object> session;

    private static final Logger logger = LogManager.getLogger(GestionSiteAction.class);


    // ----- Paramètres en entrée
    private Integer siteId;
    private Date createdDate;
    private Date lastUpdate;
    private File imageTemp;
    private String imageTempContentType;
    private String imageTempFileName;

    // ----- Eléments en sortie
    private List<Site> listSite;
    private List<String> listRegions;
    private Site site;

    // ==================== Getters/Setters ====================

    public Integer getSiteId() {
        return siteId;
    }

    public void setSiteId(Integer siteId) {
        this.siteId = siteId;
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


    public File getImageTemp() {
        return imageTemp;
    }

    public void setImageTemp(File imageTemp) {
        this.imageTemp = imageTemp;
    }

    public String getImageTempContentType() {
        return imageTempContentType;
    }

    public void setImageTempContentType(String imageTempContentType) {
        this.imageTempContentType = imageTempContentType;
    }

    public String getImageTempFileName() {
        return imageTempFileName;
    }

    public void setImageTempFileName(String imageTempFileName) {
        this.imageTempFileName = imageTempFileName;
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
        if (siteId == null) {
            this.addActionError(getText("error.site.missing.id"));
        } else {
            try {
                logger.error("id du site" + siteId);

                site = managerFactory.getSiteManager().findById(siteId);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.site.notfound", Collections.singletonList(siteId)));
            } catch (TechnicalException e) {
                this.addActionError(e.getMessage());
            } catch (FunctionalException e) {
                this.addActionError(e.getMessage());
            }
            this.createdDate = site.getDateCreation();
            this.lastUpdate = site.getLastUpdate();

            site.setNbSecteurs(site.getSecteurs().size());




        }

        return ActionSupport.SUCCESS;
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
            this.site.setUtilisateur((Utilisateur)this.session.get("escalade_user"));
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
                    vResult = ActionSupport.ERROR;

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

    /**
     * Action permetttant la modification d'un {@link Site}
     * @return success / error
     */
    public String doModifier() throws IOException {

        String vResult = ActionSupport.INPUT;

        //vérification si affiche les données ou les update
        if (this.site != null) {
            Date date = new Date();
            this.site.setLastUpdate(new Timestamp(date.getTime()));
            //Gestion image
            logger.error("image fileName + contentType "+getImageTempFileName() + getImageTempContentType());
            //copy the uploaded file to the dedicated location
            try{
                String filePath = "D:\\IdeaWorkspace\\projectsRep\\escalade\\escalade_webapp\\src\\main\\webapp\\ressources\\images";
                File file2 = new File(filePath, getImageTempFileName());
                FileUtils.copyFile(imageTemp, file2);

            }catch (Exception e)
                 {logger.error("problème lors du upload de l'image " +e);}


            if(imageTemp!=null){
                this.site.setImage("../../ressources/images/"+ getImageTempFileName());
            }
            logger.error("id du site" + site.getId());
            try {
                managerFactory.getSiteManager().update(site);
                vResult = ActionSupport.SUCCESS;
            } catch (FunctionalException e) {
                this.addActionError(getText("Un problème est survenu avec la base de données, réessayez plus tard"));
                vResult = ActionSupport.ERROR;
            }
        }
        else {

            try {
                this.site = managerFactory.getSiteManager().findById(siteId);
            } catch (NotFoundException e) {
                this.addActionError(e.getMessage());
            } catch (TechnicalException e) {
                this.addActionError(e.getMessage());
            } catch (FunctionalException e) {
                this.addActionError(e.getMessage());
            }
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


}
