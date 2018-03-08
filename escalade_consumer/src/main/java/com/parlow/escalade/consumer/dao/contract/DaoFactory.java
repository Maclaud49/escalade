package com.parlow.escalade.consumer.dao.contract;

public interface DaoFactory {

    SecteurDao getSecteurDao();

    void setSecteurDao(SecteurDao pSecteurDao);

    SiteDao getSiteDao();

    void setSiteDao(SiteDao pSiteDao);
}
