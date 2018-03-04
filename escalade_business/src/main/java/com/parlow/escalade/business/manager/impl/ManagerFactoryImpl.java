package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.business.manager.contract.SecteurManager;
import com.parlow.escalade.business.manager.contract.SiteManager;

import javax.inject.Named;
import javax.inject.Inject;

@Named
public final class ManagerFactoryImpl implements ManagerFactory {


    private SiteManager siteManager;
    private SecteurManager secteurManager;

    @Inject
    public  ManagerFactoryImpl(SiteManager pSiteManager,
                               SecteurManager pSecteurManager) {
        this.siteManager = pSiteManager;
        this.secteurManager = pSecteurManager;
    }

    // On renvoie désormais simplement l'attribut siteManager
    @Override
    public SiteManager getSiteManager() {
        return siteManager;
    }

    // Ajout d'un setter pour l'attribut siteManager
    @Override
    public void setSiteManager(SiteManager pSiteManager) {
        siteManager = pSiteManager;
    }
    // On renvoie désormais simplement l'attribut secteurManager
    @Override
    public SecteurManager getSecteurManager() {
        return secteurManager;
    }

    // Ajout d'un setter pour l'attribut secteurManager
    @Override
    public void setSecteurManager(SecteurManager pSecteurManager) {
        secteurManager = pSecteurManager;
    }

}
