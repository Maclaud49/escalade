package com.parlow.escalade.webapp.rest.resource;

import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.business.manager.contract.SecteurManager;
import com.parlow.escalade.business.manager.contract.SiteManager;
import com.parlow.escalade.business.manager.impl.SecteurManagerImpl;
import com.parlow.escalade.business.manager.impl.SiteManagerImpl;

public abstract class AbstractResource {

    private static ManagerFactory managerFactory;

    protected static ManagerFactory getManagerFactory() {
        return managerFactory;
    }
    public static void setManagerFactory(ManagerFactory pManagerFactory) {
        managerFactory = pManagerFactory;
    }

    public SiteManager getSiteManager() {

        return new SiteManagerImpl();
    }

    public SecteurManager getSecteurManager() {
        return new SecteurManagerImpl();
    }
}