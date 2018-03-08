package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.consumer.dao.contract.SecteurDao;
import com.parlow.escalade.consumer.dao.contract.SiteDao;

import javax.inject.Named;
import javax.inject.Inject;


@Named
public class DaoFactoryImpl implements DaoFactory {

    private SecteurDao secteurDao;
    private SiteDao siteDao;

    @Inject
    public  DaoFactoryImpl(SiteDao pSiteDao,
                           SecteurDao pSecteurDao) {
        this.siteDao = pSiteDao;
        this.secteurDao = pSecteurDao;
    }

    @Override
    public SecteurDao getSecteurDao() {
        return null;
    }

    @Override
    public void setSecteurDao(SecteurDao pSecteurDao) {

    }

    @Override
    public SiteDao getSiteDao() {
        return null;
    }

    @Override
    public void setSiteDao(SiteDao pSiteDao) {

    }
}
