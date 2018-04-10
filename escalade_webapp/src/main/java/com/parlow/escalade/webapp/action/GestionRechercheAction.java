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

public class GestionRechercheAction extends ActionSupport {

    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;

    private static final Logger logger = LogManager.getLogger(GestionRechercheAction.class);

    private List<Site> listSite;
    private List<Secteur> listSecteur;
    private List<Voie> listVoie;
    private List<Longueur> listLongueur;

    private String keyWord;

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

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    // ==================== Méthodes ====================
    /**
     * Action listant les résultats de la recherche
     * @return success
     */
    public String doListSearchResult() {
        logger.info("keyWord" + keyWord);

        String keyWordForSearch = '%'+keyWord+'%';

        listSite = managerFactory.getSiteManager().searchResult(keyWordForSearch);
        listSecteur = managerFactory.getSecteurManager().searchResult(keyWordForSearch);
        listVoie = managerFactory.getVoieManager().searchResult(keyWordForSearch);
        listLongueur = managerFactory.getLongueurManager().searchResult(keyWordForSearch);
        return ActionSupport.SUCCESS;
    }
}
