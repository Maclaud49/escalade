package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.business.manager.contract.SecteurManager;
import com.parlow.escalade.business.manager.contract.SiteManager;
import com.parlow.escalade.business.manager.contract.UtilisateurManager;

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

    @Override
    public SiteManager getSiteManager() {
        return siteManager;
    }

    @Override
    public void setSiteManager(SiteManager pSiteManager) {
        siteManager = pSiteManager;
    }

    @Override
    public SecteurManager getSecteurManager() {
        return secteurManager;
    }

    @Override
    public void setSecteurManager(SecteurManager pSecteurManager) {
        secteurManager = pSecteurManager;
    }

    @Override
    public UtilisateurManager getUtilisateurManager() {
        return this.utilisateurManager;
    }

    @Override
    public void setUtilisateurManager(UtilisateurManager pUtilisateurManager) {
        utilisateurManager = pUtilisateurManager;
    }

}
