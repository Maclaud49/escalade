package com.parlow.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.Longueur;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.Voie;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.List;

public class GestionConsoleAction extends ActionSupport {

    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;

    private static final Logger logger = LogManager.getLogger(GestionRechercheAction.class);

    private List<Site> listSite;
    private List<Secteur> listSecteur;
    private List<Voie> listVoie;
    private List<Longueur> listLongueur;



    // ==================== Getters/Setters ====================


    public List<Site> getListSite() {
        return listSite;
    }

    public void setListSite(List<Site> listSite) {
        this.listSite = listSite;
    }

    public List<Secteur> getListSecteur() {
        return listSecteur;
    }

    public void setListSecteur(List<Secteur> listSecteur) {
        this.listSecteur = listSecteur;
    }

    public List<Voie> getListVoie() {
        return listVoie;
    }

    public void setListVoie(List<Voie> listVoie) {
        this.listVoie = listVoie;
    }

    public List<Longueur> getListLongueur() {
        return listLongueur;
    }

    public void setListLongueur(List<Longueur> listLongueur) {
        this.listLongueur = listLongueur;
    }


    // ==================== Méthodes ====================
    /**
     * Action listant les éléments du site internet dans la console
     * @return success
     */
    public String doListItems() {

        listSite = managerFactory.getSiteManager().findAll();
        listSecteur = managerFactory.getSecteurManager().findAll();
        listVoie = managerFactory.getVoieManager().findAll();
        listLongueur = managerFactory.getLongueurManager().findAll();
        return ActionSupport.SUCCESS;
    }
}