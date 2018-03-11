package com.parlow.escalade.business.manager.contract;

public interface ManagerFactory {

    SiteManager getSiteManager();

    void setSiteManager(SiteManager pSiteManager);

    SecteurManager getSecteurManager();

    void setSecteurManager(SecteurManager pSecteurManager);

    UtilisateurManager getUtilisateurManager();

    void setUtilisateurManager(UtilisateurManager pUtilisateurManager);

}
