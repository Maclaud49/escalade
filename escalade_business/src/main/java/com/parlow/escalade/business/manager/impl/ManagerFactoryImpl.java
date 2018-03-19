package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.*;

import javax.inject.Named;
import javax.inject.Inject;

@Named
public final class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private SiteManager siteManager;
    @Inject
    private SecteurManager secteurManager;
    @Inject
    private UtilisateurManager utilisateurManager;
    @Inject
    private RegionManager regionManager;


    @Override
    public SiteManager getSiteManager() {
        return this.siteManager;
    }

    @Override
    public void setSiteManager(SiteManager pSiteManager) {
        this.siteManager = pSiteManager;
    }

    @Override
    public SecteurManager getSecteurManager() {
        return this.secteurManager;
    }

    @Override
    public void setSecteurManager(SecteurManager pSecteurManager) {
        this.secteurManager = pSecteurManager;
    }

    @Override
    public UtilisateurManager getUtilisateurManager() {
        return this.utilisateurManager;
    }

    @Override
    public void setUtilisateurManager(UtilisateurManager pUtilisateurManager) {
        this.utilisateurManager = pUtilisateurManager;
    }

    @Override
    public RegionManager getRegionManager() {
        return this.regionManager;
    }

    @Override
    public void setRegionManager(RegionManager pRegionManager) {
         this.regionManager = pRegionManager;
    }

}
