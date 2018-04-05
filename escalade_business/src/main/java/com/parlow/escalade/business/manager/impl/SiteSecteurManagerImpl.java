package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.SiteSecteurManager;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteSecteurManagerImpl implements SiteSecteurManager {
    @Override
    public int insert(Site pSite, Secteur pSecteur) throws FunctionalException, TechnicalException {
        return 0;
    }

    @Override
    public List<Site> findAllBySecteur(int pSecteurId) throws FunctionalException, TechnicalException {
        return null;
    }

    @Override
    public List<Secteur> findAllBySite(int pSiteId) throws FunctionalException, TechnicalException {
        return null;
    }
}