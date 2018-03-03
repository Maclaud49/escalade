package com.parlow.escalade.consummer.dao.impl;

import com.parlow.escalade.consummer.dao.contract.DaoFactory;
import com.parlow.escalade.consummer.dao.contract.SecteurDao;
import com.parlow.escalade.consummer.dao.contract.SiteDao;

public class DaoFactoryImpl implements DaoFactory {
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
