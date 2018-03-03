package com.parlow.escalade.consummer.dao.contract;

public interface DaoFactory {

    SecteurDao getSecteurDao();

    void setSecteurDao(SecteurDao pSecteurDao);

    SiteDao getSiteDao();

    void setSiteDao(SiteDao pSiteDao);
}
