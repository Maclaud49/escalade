package com.parlow.escalade.business.manager.contract;

public interface ManagerFactory {
    // On renvoie désormais simplement l'attribut siteManager
    SiteManager getSiteManager();

    // Ajout d'un setter pour l'attribut siteManager
    void setSiteManager(SiteManager pSiteManager);

    // On renvoie désormais simplement l'attribut secteurManager
    SecteurManager getSecteurManager();

    // Ajout d'un setter pour l'attribut secteurManager
    void setSecteurManager(SecteurManager pSecteurManager);
}
