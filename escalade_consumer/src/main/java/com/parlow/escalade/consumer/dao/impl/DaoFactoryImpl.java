package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.*;

import javax.inject.Named;
import javax.inject.Inject;


@Named
public class DaoFactoryImpl implements DaoFactory {

    @Inject
    private SecteurDao secteurDao;
    @Inject
    private SiteDao siteDao;
    @Inject
    private UtilisateurDao utilisateurDao;
    @Inject
    private RegionDao regionDao;
    @Inject
    public  DaoFactoryImpl() {
    }

    @Override
    public SecteurDao getSecteurDao() {
        return this.secteurDao;
    }

    @Override
    public void setSecteurDao(SecteurDao pSecteurDao) {
        this.secteurDao = pSecteurDao;
    }

    @Override
    public SiteDao getSiteDao() {
        return this.siteDao;
    }

    @Override
    public void setSiteDao(SiteDao pSiteDao) {
        this.siteDao = pSiteDao;
    }

    @Override
    public UtilisateurDao getUtilisateurDao() {
        return this.utilisateurDao;
    }

    @Override
    public void setUtilisateurDao(UtilisateurDao pUtilisateurDao) {

        this.utilisateurDao = pUtilisateurDao;
    }

    @Override
    public RegionDao getRegionDao() {
        return this.regionDao;
    }

    @Override
    public void setRegionDao(RegionDao pRegionDao) {
        this.regionDao = pRegionDao;
    }
}
