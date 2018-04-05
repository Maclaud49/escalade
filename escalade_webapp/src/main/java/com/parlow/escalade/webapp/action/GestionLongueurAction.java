package com.parlow.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.Longueur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.*;

public class GestionLongueurAction  extends ActionSupport implements SessionAware {




    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;
    private Map<String, Object> session;


    private static final Logger logger = LogManager.getLogger(GestionLongueurAction.class);


    // ----- Paramètres en entrée
    private Integer longueurId;
    private Date createdDate;
    private Date lastUpdate;
    private File imageTemp;
    private String imageTempContentType;
    private String imageTempFileName;
    private List<String> listCotations;

    // ----- Eléments en sortie
    private List<Longueur> listLongueur;
    private Longueur longueur;
    private List<Voie> listVoie;
    private Voie voie;

    // ==================== Getters/Setters ====================

    public Integer getLongueurId() {
        return longueurId;
    }

    public void setLongueurId(Integer longueurId) {
        this.longueurId = longueurId;
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

    public List<Longueur> getListLongueur() {
        return listLongueur;
    }

    public void setListLongueur(List<Longueur> listLongueur) {
        this.listLongueur = listLongueur;
    }
    public Longueur getLongueur() {
        return longueur;
    }

    public void setLongueur(Longueur longueur) {
        this.longueur = longueur;
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

    // ==================== Méthodes ====================
    /**
     * Action listant les {@link Longueur}
     * @return success
     */
    public String doList() {
        listLongueur = managerFactory.getLongueurManager().findAll();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Longueur}
     * @return success / error
     */
    public String doDetail() {
        if (longueurId == null) {
            this.addActionError(getText("error.longueur.missing.id"));
        } else {
            try {
                logger.error("id du longueur" + longueurId);

                longueur = managerFactory.getLongueurManager().findById(longueurId);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.longueur.notfound", Collections.singletonList(longueurId)));
            }
            this.createdDate = longueur.getDateCreation();
            this.lastUpdate = longueur.getLastUpdate();


        }

        return ActionSupport.SUCCESS;
    }
    /**
     * Action permettant de créer un nouveau {@link Longueur}
     * @return input / success / error
     */
    public String doCreate() {
        logger.error("I m here");

        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de longueur (longueur != null)
        if (this.longueur != null) {
            Date date = new Date();
            this.longueur.setUtilisateur((Utilisateur)this.session.get("escalade_user"));
            this.longueur.setDateCreation(new Timestamp(date.getTime()));
            try {
                if(this.longueur.getImage()==null){
                    String image = "../../ressources/images/750x300.png";
                    this.longueur.setImage(image);
                }
                this.longueur.setId(managerFactory.getLongueurManager().insert(this.longueur));
                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("Longueur ajouté avec succès");

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

        }
        return vResult;
    }


    /**
     * Action permetttant la modification d'un {@link Longueur}
     * @return success / error
     */
    public String doModifier() throws IOException {

        String vResult = ActionSupport.INPUT;

        //vérification si affiche les données ou les update
        if (this.longueur != null) {
            Date date = new Date();
            this.longueur.setLastUpdate(new Timestamp(date.getTime()));
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
                this.longueur.setImage("../../ressources/images/"+ getImageTempFileName());
            }
            logger.error("id du longueur" + longueur.getId());
            try {
                managerFactory.getLongueurManager().update(longueur);
                vResult = ActionSupport.SUCCESS;
            } catch (FunctionalException e) {
                this.addActionError(getText("Un problème est survenu avec la base de données, réessayez plus tard"));
                vResult = ActionSupport.ERROR;
            }
        }
        else {

            try {
                this.longueur = managerFactory.getLongueurManager().findById(longueurId);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.user.notfound", Collections.singletonList(longueurId)));
            }
        }


        return vResult;
    }

    public List<String> selectCotation(){
        List<String> list = new ArrayList<>();
        list =  Arrays.asList("3", "3a", "3b","3c","4","4a","4b","4c","5","5a","5b","5c","6","6a","6b","6c","7","7a","7b","7c","8","8a","8b","8c","9","9a","9b","9c");
        return list;
    }

    @Override
    public void validate() {
        if (this.longueur != null) {
            if (longueur.getNom().length() < 3) {

                addFieldError("longueurNom", "Le nom du longueur doit faire au moins 3 lettres");
            }
        }
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }


}