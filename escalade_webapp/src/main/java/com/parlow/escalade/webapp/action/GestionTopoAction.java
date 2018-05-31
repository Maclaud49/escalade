package com.parlow.escalade.webapp.action;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.sql.Timestamp;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.Commentaire;
import com.parlow.escalade.model.bean.Topo;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;


import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


/**
 * Action de gestion des {@link Topo}
 */
@PropertySource(value = "classpath:app.properties", ignoreResourceNotFound=true)
public class GestionTopoAction extends ActionSupport implements SessionAware {





    // ==================== Attributs ====================
    @Value("@images.path@")
    private String cheminImages2;
    @Value("${images.path}")
    private String cheminImages;
    @Value("${images.path2}")
    private String cheminImages3;


    @Inject
    private ManagerFactory managerFactory;
    private Map<String, Object> session;
    private static final Logger logger = LogManager.getLogger(GestionTopoAction.class);


    // ----- Paramètres en entrée
    private Integer topoId;
    private Date createdDate;
    private Date lastUpdate;
    private File imageTemp;
    private String imageTempContentType;
    private String imageTempFileName;
    private List<Topo> listTopo;
    private List<String> listRegions;
    private List<Commentaire> listCommentaires;

    // ----- Eléments en sortie

    private Topo topo;

    // ==================== Getters/Setters ====================

    public Integer getTopoId() {
        return topoId;
    }

    public void setTopoId(Integer topoId) {
        this.topoId = topoId;
    }

    public List<Topo> getListTopo() {
        return listTopo;
    }
    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo pTopo){
        topo = pTopo;
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
     * Action listant les {@link Topo}
     * @return success
     */
    public String doList() {

        listTopo = managerFactory.getTopoManager().findAll();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Topo}
     * @return success / error
     */
    public String doDetail() {
        if (topoId == null) {
            this.addActionError(getText("error.topo.missing.id"));
        } else {
            try {

                topo = managerFactory.getTopoManager().findById(topoId);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.topo.notfound", Collections.singletonList(topoId)));
            } catch (TechnicalException e) {
                this.addActionError(e.getMessage());
            } catch (FunctionalException e) {
                this.addActionError(e.getMessage());
            }
        }

        return ActionSupport.SUCCESS;
    }
    /**
     * Action permettant de créer un nouveau {@link Topo}
     * @return input / success / error
     */
    public String doCreate() {

        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de topo (topo != null)
        if (this.topo != null) {
            Date date = new Date();
            this.topo.setUtilisateur((Utilisateur)this.session.get("escalade_user"));
            this.topo.setDateCreation(new Timestamp(date.getTime()));
            topo.setDescription(premiereLettreMaj(this.topo.getDescription()));
            topo.setNom(premiereLettreMaj(this.topo.getNom()));

            try {
                if(this.topo.getImage()==null){
                    String image = "../../ressources/images/750x300.png";
                    this.topo.setImage(image);
                }
                this.topo.setId(managerFactory.getTopoManager().insert(this.topo));
                vResult = ActionSupport.SUCCESS;
                this.addActionMessage("Topo ajouté avec succès");

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

    /**
     * Action permettant de supprimer {@link Topo}
     * @return input / success / error
     */
    public String doDelete() {
        //todo mettre au propre toutes les méthodes
        try {
            managerFactory.getTopoManager().delete(topoId);
        } catch (NotFoundException e) {
            e.printStackTrace();
        } catch (TechnicalException e) {
            e.printStackTrace();
        }
        String vResult = ActionSupport.SUCCESS;
        return vResult;
    }


    /**
     * Action permetttant la modification d'un {@link Topo}
     * @return success / error
     */
    public String doModifier() throws IOException {

        String vResult = ActionSupport.INPUT;

        //vérification si affiche les données ou les update
        if (this.topo != null) {
            Date date = new Date();
            this.topo.setLastUpdate(new Timestamp(date.getTime()));
            topo.setDescription(premiereLettreMaj(this.topo.getDescription()));
            topo.setNom(premiereLettreMaj(this.topo.getNom()));
            //Gestion image
            logger.error("image fileName + contentType "+getImageTempFileName() + getImageTempContentType());
            //copy the uploaded file to the dedicated location
            if(imageTemp!=null){
                try{
                    String filePath = cheminImages;
                    File file2 = new File(filePath, getImageTempFileName());
                    FileUtils.copyFile(imageTemp, file2);

                }catch (Exception e)
                {logger.error("problème lors du upload de l'image " +e);}


                this.topo.setImage("../../ressources/images/"+ getImageTempFileName());
            }


            try {
                managerFactory.getTopoManager().update(topo);
                vResult = ActionSupport.SUCCESS;
            } catch (FunctionalException e) {
                this.addActionError(getText("Un problème est survenu avec la base de données, réessayez plus tard"));
                vResult = ActionSupport.ERROR;
            }
        }
        else {

            try {
                this.topo = managerFactory.getTopoManager().findById(topoId);
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

    private List<String> selectRegion(){
        List<String> list = new ArrayList<>();
        list =  Arrays.asList("Grand-Est", "Nouvelle-Aquitaine", "Auvergne-Rhône-Alpes","Bourgogne-Franche-Comté",
                "Bretagne", "Centre-Val de Loire", "Corse", "Île-de-France", "Occitanie", "Hauts-de-France", "Normandie",
                "Pays de la Loire", "Provence-Alpes-Côte d'Azur");
        return list;
    }

    private List<Commentaire> selectCommentaires(){
        List<Commentaire> listCommentaires = new ArrayList<>();
        if(topoId != null) {
            listCommentaires = managerFactory.getCommentaireManager().findAllBySectionAndArticle("TOPO", topoId);
        }
        return listCommentaires;
    }

    //transforme la premiere lettre d'un string en majuscule
    private String premiereLettreMaj(String str){

        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }

    @Override
    public void validate() {

        if (this.topo != null) {
            boolean topoNomExist = true;

            if (topo.getNom().length() < 2 || topo.getNom().length() >15) {
                addFieldError("topoNom", "Le nom du topo doit faire entre 2 et 15 caratères ");
            }
            try {
                managerFactory.getTopoManager().findByName(premiereLettreMaj(this.topo.getNom()));
                topoNomExist = true;
            } catch (NotFoundException e) {
                topoNomExist = false;
            }
            if(this.topo.getId()==null&&topoNomExist){
                addFieldError("topoNom", "Ce nom de topo est déjà utilisé ");
            }
        }
    }

    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

}
