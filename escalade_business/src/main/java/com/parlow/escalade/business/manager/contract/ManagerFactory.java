package com.parlow.escalade.business.manager.contract;


public interface ManagerFactory {

    SiteManager getSiteManager();

    void setSiteManager(SiteManager pSiteManager);

    SecteurManager getSecteurManager();

    void setSecteurManager(SecteurManager pSecteurManager);

    UtilisateurManager getUtilisateurManager();

    void setUtilisateurManager(UtilisateurManager pUtilisateurManager);

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
