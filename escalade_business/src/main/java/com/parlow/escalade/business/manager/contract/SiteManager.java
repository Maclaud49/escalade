package com.parlow.escalade.business.manager.contract;

import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;

import java.util.List;

public interface SiteManager {

    Site getSite(Integer pId) throws NotFoundException;

    List<Site> getListSite();

    int insert( Site site )throws FunctionalException, TechnicalException;

    Site findById( int id );

    List<Site> findAll();

    void delete( int siteid );
}
