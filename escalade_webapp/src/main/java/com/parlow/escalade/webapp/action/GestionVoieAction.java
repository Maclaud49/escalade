package com.parlow.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.Commentaire;
import com.parlow.escalade.model.bean.Longueur;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

@PropertySource(value = "classpath:app.properties", ignoreResourceNotFound=true)
public class GestionVoieAction extends ActionSupport implements SessionAware {




    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;
    private Map<String, Object> session;
    @Value("${images.path}")
    private String cheminImages;

    private static final Logger logger = LogManager.getLogger(GestionVoieAction.class);


    // ----- Paramètres en entrée
    private Integer voieId;
    private Date createdDate;
    private Date lastUpdate;
    private File imageTemp;
    private String imageTempContentType;
    private String imageTempFileName;
    private List<String> listCotations;
    private Integer secteurId;
    private List<Secteur> secteurList;
    private List<Commentaire> listCommentaires;

    // ----- Eléments en sortie
    private List<Voie> listVoie;
    private Voie voie;

    // ==================== Getters/Setters ====================

    public Integer getVoieId() {
        return voieId;
    }

    public void setVoieId(Integer voieId) {
        this.voieId = voieId;
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

    public List<Voie> getListVoie() {
        return listVoie;
    }

    public void setListVoie(List<Voie> listVoie) {
        this.listVoie = listVoie;
    }

    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    public List<String> getListCotations() {
        if(this.listCotations==null){
            this.listCotations=selectCotation();
        }
        return listCotations;
    }

    public void setListCotations(List<String> cotations) {
        this.listCotations = cotations;
    }

    public Integer getSecteurId() {
        return secteurId;
    }

    public void setSecteurId(Integer secteurId) {
        this.secteurId = secteurId;
    }

    public List<Secteur> getSecteurList() {
        if(this.secteurList==null){
            this.secteurList=selectSecteur();
        }
        return secteurList;
    }

    public void setSecteurList(List<Secteur> secteurList) {
        this.secteurList = secteurList;
    }

    public List<Commentaire> getListCommentaires() {
        if(this.listCommentaires==null){
            this.listCommentaires=selectCommentaires();
        }
        return listCommentaires;
    }

    public void setListCommentaires(List<Commentaire> listCommentaires) {
        this.listCommentaires = listCommentaires;
    }

    // ==================== Méthodes ====================
    /**
     * Action listant les {@link Voie}
     * @return success
     */
    public String doList() {
        listVoie = managerFactory.getVoieManager().findAll();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Voie}
     * @return success / error
     */
    public String doDetail() {
        if (voieId == null) {
            this.addActionError(getText("error.voie.missing.id"));
        } else {
            try {

                voie = managerFactory.getVoieManager().findById(voieId);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.voie.notfound", Collections.singletonList(voieId)));
            }
            this.createdDate = voie.getDateCreation();
            this.lastUpdate = voie.getLastUpdate();

            voie.setNbLongueurs(this.voie.getLongueurs().size());
        }

        return ActionSupport.SUCCESS;
    }
    /**
     * Action permettant de créer un nouveau {@link Voie}
     * @return input / success / error
     */
    public String doCreate() {

        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de voie (voie != null)
        if (this.voie != null) {
            Date date = new Date();
            this.voie.setUtilisateur((Utilisateur)this.session.get("escalade_user"));
            this.voie.setDateCreation(new Timestamp(date.getTime()));
            this.voie.setHauteurVoie(0);
            this.voie.setNbPoints(0);
            this.voie.setCotation("3");
            this.voie.setEquipee(false);
            voie.setDescription(premiereLettreMaj(this.voie.getDescription()));
            voie.setNom(premiereLettreMaj(this.voie.getNom()));
            try {
                if(this.voie.getImage()==null){
                    String image = "../../ressources/images/750x300.png";
                    this.voie.setImage(image);
                }
                this.voie.setId(managerFactory.getVoieManager().insert(this.voie));
                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("Voie ajouté avec succès");

            } catch (FunctionalException pEx) {
                this.addActionError(pEx.getMessage());
                vResult = ActionSupport.ERROR;

            } catch (TechnicalException pEx) {

                this.addActionError(pEx.getMessage());
                vResult = ActionSupport.ERROR;
            }
            if(secteurId >0){
                logger.info("secteur id " + secteurId);
                try {
                    managerFactory.getSecteurVoieManager().insert(secteurId,this.voie.getId());
                } catch (FunctionalException e) {
                    this.addActionError(e.getMessage());
                    vResult = ActionSupport.ERROR;
                } catch (TechnicalException e) {
                    this.addActionError(e.getMessage());
                    vResult = ActionSupport.ERROR;
                }

            }
            else{
                logger.info("for test");
            }
        }

        //Ajout des infos nécessaires pour le formulaire de saisie
        if (vResult.equals(ActionSupport.INPUT)) {

        }
        return vResult;
    }


    /**
     * Action permetttant la modification d'un {@link Voie}
     * @return success / error
     */
    public String doModifier() throws IOException {

        String vResult = ActionSupport.INPUT;

        //vérification si affiche les données ou les update
        if (this.voie != null) {
            Date date = new Date();
            this.voie.setLastUpdate(new Timestamp(date.getTime()));
            voie.setDescription(premiereLettreMaj(this.voie.getDescription()));
            voie.setNom(premiereLettreMaj(this.voie.getNom()));
            //Gestion image
            logger.error("image fileName + contentType "+getImageTempFileName() + getImageTempContentType());
            //copy the uploaded file to the dedicated location
            if(imageTemp !=null) {
                try {
                    String filePath = cheminImages;
                    File file2 = new File(filePath, getImageTempFileName());
                    FileUtils.copyFile(imageTemp, file2);

                } catch (Exception e) {
                    logger.error("problème lors du upload de l'image " + e);
                }
                    this.voie.setImage("../../ressources/images/" + getImageTempFileName());
                }

            logger.info("equipee" + voie.isEquipee());
            try {
                managerFactory.getVoieManager().update(voie);
                vResult = ActionSupport.SUCCESS;
            } catch (FunctionalException e) {
                this.addActionError(getText("Un problème est survenu avec la base de données, réessayez plus tard"));
                vResult = ActionSupport.ERROR;
            }
            if(secteurId >0){
                logger.info("secteur id " + secteurId);
                //Verification de l'existence de l'association
                int result = 0;
                try {
                    result = managerFactory.getSecteurVoieManager().findBySecteurAndVoie(secteurId,this.voie.getId());
                } catch (FunctionalException e) {
                    this.addActionError(e.getMessage());
                    vResult = ActionSupport.ERROR;
                } catch (TechnicalException e) {
                    this.addActionError(e.getMessage());
                    vResult = ActionSupport.ERROR;
                }
                //Si association non existante, création de celle-ci
                if(result==0){
                    try {
                        managerFactory.getSecteurVoieManager().insert(secteurId,this.voie.getId());
                    } catch (FunctionalException e) {
                        this.addActionError(e.getMessage());
                        vResult = ActionSupport.ERROR;
                    } catch (TechnicalException e) {
                        this.addActionError(e.getMessage());
                        vResult = ActionSupport.ERROR;
                    }
                }
            }
            else{
                logger.info("for test");
            }
        }
        else {

            try {
                this.voie = managerFactory.getVoieManager().findById(voieId);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.user.notfound", Collections.singletonList(voieId)));
            }
        }


        return vResult;
    }

    /**
     * Action permettant de supprimer {@link Voie}
     * @return input / success / error
     */
    public String doDelete() {
        //todo delete
        String vResult = ActionSupport.SUCCESS;
        return vResult;
    }

    public List<String> selectCotation(){
        List<String> list = new ArrayList<>();
        list =  Arrays.asList("3", "3a", "3b","3c","4","4a","4b","4c","5","5a","5b","5c","6","6a","6b","6c","7","7a","7b","7c","8","8a","8b","8c","9","9a","9b","9c");
        return list;
    }
    public List<Secteur> selectSecteur(){
        return managerFactory.getSecteurManager().findAll();
    }
    

    //transforme la premiere lettre d'un string en majuscule
    public String premiereLettreMaj(String str){

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    private List<Commentaire> selectCommentaires(){
        List<Commentaire> listCommentaires = new ArrayList<>();
        if(voieId != null) {
            listCommentaires = managerFactory.getCommentaireManager().findAllBySectionAndArticle("VOIE", voieId);
        }

        return listCommentaires;

    }

    @Override
    public void validate() {
        //Todo validation des donnees
        if (this.voie != null) {
            if (voie.getNom().length() < 3) {

                addFieldError("voieNom", "Le nom du voie doit faire au moins 3 lettres");
            }
        }
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }


}
