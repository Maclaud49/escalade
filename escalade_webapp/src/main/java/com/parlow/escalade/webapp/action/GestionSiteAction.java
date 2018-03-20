package com.parlow.escalade.webapp.action;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.sql.Timestamp;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.Region;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import javax.inject.Inject;


/**
 * Action de gestion des {@link Site}
 */
public class GestionSiteAction extends ActionSupport {




    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;

    private static final Logger logger = LogManager.getLogger(GestionSiteAction.class);


    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Site> listSite;
    private List<Region> listRegions;
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
    public List<Region> getListRegions() {
        return listRegions;
    }
    public void setListRegions(List<Region> listRegions) {
        this.listRegions = listRegions;
    }

    // ==================== Méthodes ====================
    /**
     * Action listant les {@link Site}
     * @return success
     */
    public String doList() {
        listSite = managerFactory.getSiteManager().getListSite();
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
                site = managerFactory.getSiteManager().getSite(id);
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
        // Si (this.site == null) c'est que l'on entre dans l'ajout de site
        // Sinon, c'est que l'on vient de valider le formulaire d'ajout

        // Par défaut, le result est "input"
        String vResult = ActionSupport.INPUT;

        // ===== Validation de l'ajout de site (site != null)
        if (this.site != null) {
            // Date de création
            Date date = new Date();
            this.site.setDateCreation(new Timestamp(date.getTime()));

            // Si pas d'erreur, ajout du site...
            /*if (!this.hasErrors()) {*/
                try {
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
            /*}*/
        }

        // Si on doit aller sur le formulaire de saisie, il faut ajouter les info nécessaires
        if (vResult.equals(ActionSupport.INPUT)) {
            this.listRegions = managerFactory.getRegionManager().getListRegion();
        }

        return vResult;
    }

    @Override
    public void validate() {
        if (this.site != null) {
            logger.error("I m here");
            logger.info("I m here");
            if (site.getNom().length() < 3) {
                addFieldError("siteNom", "Le nom du site doit faire au moins 3 lettres");
            }
        }
    }

}
