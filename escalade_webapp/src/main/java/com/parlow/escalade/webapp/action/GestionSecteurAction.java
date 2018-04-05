package com.parlow.escalade.webapp.action;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.sql.Timestamp;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.SessionAware;


import javax.inject.Inject;


/**
 * Action de gestion des {@link Secteur}
 */
public class GestionSecteurAction extends ActionSupport implements  SessionAware {




    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;
    private Map<String, Object> session;


    private static final Logger logger = LogManager.getLogger(GestionSecteurAction.class);


    // ----- Paramètres en entrée
    private Integer secteurId;
    private Date createdDate;
    private Date lastUpdate;
    private File imageTemp;
    private String imageTempContentType;
    private String imageTempFileName;
    private List<String> listDepartements;

    // ----- Eléments en sortie
    private List<Secteur> listSecteur;
    private Secteur secteur;

    // ==================== Getters/Setters ====================

    public Integer getSecteurId() {
        return secteurId;
    }

    public void setSecteurId(Integer secteurId) {
        this.secteurId = secteurId;
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

    public List<Secteur> getListSecteur() {
        return listSecteur;
    }

    public void setListSecteur(List<Secteur> listSecteur) {
        this.listSecteur = listSecteur;
    }
    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
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
    
    public List<String> getListDepartements() {
        if(this.listDepartements==null){
            this.listDepartements=selectDepartement();
        }
        return listDepartements;
    }
    

    // ==================== Méthodes ====================
    /**
     * Action listant les {@link Secteur}
     * @return success
     */
    public String doList() {
        listSecteur = managerFactory.getSecteurManager().findAll();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Secteur}
     * @return success / error
     */
    public String doDetail() {
        if (secteurId == null) {
            this.addActionError(getText("error.secteur.missing.id"));
        } else {
            try {

                secteur = managerFactory.getSecteurManager().findById(secteurId);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.secteur.notfound", Collections.singletonList(secteurId)));
            } catch (TechnicalException e) {
                e.printStackTrace();
            } catch (FunctionalException e) {
                e.printStackTrace();
            }
            this.createdDate = secteur.getDateCreation();
            this.lastUpdate = secteur.getLastUpdate();

            secteur.setNbVoies(secteur.getVoies().size());
        }

        return ActionSupport.SUCCESS;
    }
    /**
     * Action permettant de créer un nouveau {@link Secteur}
     * @return input / success / error
     */
    public String doCreate() {
        logger.error("I m here");

        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de secteur (secteur != null)
        if (this.secteur != null) {
            Date date = new Date();
            this.secteur.setUtilisateur((Utilisateur)this.session.get("escalade_user"));
            this.secteur.setDateCreation(new Timestamp(date.getTime()));
            try {
                if(this.secteur.getImage()==null){
                    String image = "../../ressources/images/750x300.png";
                    this.secteur.setImage(image);
                }
                this.secteur.setId(managerFactory.getSecteurManager().insert(this.secteur));
                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("Secteur ajouté avec succès");

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
     * Action permetttant la modification d'un {@link Secteur}
     * @return success / error
     */
    public String doModifier() throws IOException {

        String vResult = ActionSupport.INPUT;

        //vérification si affiche les données ou les update
        if (this.secteur != null) {
            Date date = new Date();
            this.secteur.setLastUpdate(new Timestamp(date.getTime()));
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
                this.secteur.setImage("../../ressources/images/"+ getImageTempFileName());
            }
            logger.error("id du secteur" + secteur.getId());
            try {
                managerFactory.getSecteurManager().update(secteur);
                vResult = ActionSupport.SUCCESS;
            } catch (FunctionalException e) {
                this.addActionError(getText("Un problème est survenu avec la base de données, réessayez plus tard"));
                vResult = ActionSupport.ERROR;
            }
        }
        else {

            try {
                this.secteur = managerFactory.getSecteurManager().findById(secteurId);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.user.notfound", Collections.singletonList(secteurId)));
            } catch (TechnicalException e) {
                e.printStackTrace();
            } catch (FunctionalException e) {
                e.printStackTrace();
            }
        }


        return vResult;
    }

    public List<String> selectDepartement(){
        List<String> list = new ArrayList<>();
        list =  Arrays.asList("Ardennes","Aube","Marne","Haute-Marne","Meurthe-et-Moselle","Meuse","Moselle","Bas-Rhin","Haut-Rhin","Vosges","Charente","Charente-Maritime","Corrèze","Creuse","Deux-Sèvres","Dordogne","Gironde","Landes","Lot-et-Garonne","Pyrénées-Atlantiques","Haute-Vienne","Vienne","Ain","Allier","Ardèche","Cantal","Drôme","Haute-Loire","Isère","Loire","Puy-de-Dôme","Rhône","Savois","Haute-Savoie","Côte-d''Or","Doubs","Jura","Nièvre","Saône-et-Loire","Haute-Saône","Territoire de Belfort","Yonne","Côtes-d''Armor","Finistère","Ille-et-Vilaine","Morbihan","Cher","Eure-et-Loir","Indre","Indre-et-Loire","Loir-et-Cher","Loiret","Corse-du-Sud","Haute-Corse","Essonne","Hauts-de-Seine","Paris","Seine-Saint-Denis","Seine-et-Marne","Val-de-Marne","Val-d''Oise","Yvelines","Ariège","Aude","Aveyron","Gard","Haute-Garonne","Gers","Lot","Hautes-Pyrénées","Hérault","Lozère","Pyrénées-Orientales","Tarn","Tarn-et-Garonne","Aisne","Nord","Oise","Pas-de-Calais","Somme","Calvados","Eure","Manche","Orne","Seine-Maritime","Loire-Atlantique","Maine-et-Loire","Mayenne","Sarthe","Vendée","Alpes-de-Haute-Provence","Hautes-Alpes","Alpes-Maritimes","Bouches-du-Rhône","Var","Vaucluse");
        return list;
    }

    @Override
    public void validate() {
        if (this.secteur != null) {
            if (secteur.getNom().length() < 3) {

                addFieldError("secteurNom", "Le nom du secteur doit faire au moins 3 lettres");
            }
        }
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }


}
