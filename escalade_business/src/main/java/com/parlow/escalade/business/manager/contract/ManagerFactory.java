package com.parlow.escalade.business.manager.contract;


import com.parlow.escalade.business.manager.contract.deleted.*;

public interface ManagerFactory {

    SiteManager getSiteManager();

    void setSiteManager(SiteManager pSiteManager);

    SecteurManager getSecteurManager();

    void setSecteurManager(SecteurManager pSecteurManager);

    UtilisateurManager getUtilisateurManager();

    void setUtilisateurManager(UtilisateurManager pUtilisateurManager);

    AdresseManager getAdresseManager();

    void setAdresseManager(AdresseManager adresseManager);

    CommentaireManager getCommentaireManager();

    void setCommentaireManager(CommentaireManager commentaireManager);

    LocationManager getLocationManager();

    void setLocationManager(LocationManager locationManager);

    LongueurManager getLongueurManager();

    void setLongueurManager(LongueurManager longueurManager);

    TopoManager getTopoManager();

    void setTopoManager(TopoManager topoManager);

    VoieManager getVoieManager();

    void setVoieManager(VoieManager voieManager);

    SiteSecteurManager getSiteSecteurManager();

    void setSiteSecteurManager(SiteSecteurManager siteSecteurManager);

    SecteurVoieManager getSecteurVoieManager();

    void setSecteurVoieManager(SecteurVoieManager secteurVoieManager);
}
