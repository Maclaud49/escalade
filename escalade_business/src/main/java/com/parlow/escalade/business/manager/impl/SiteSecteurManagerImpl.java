package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.SiteSecteurManager;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteSecteurManagerImpl extends AbstractManager implements SiteSecteurManager {
    @Override
    public int insert(int pSiteId, int pSecteurId) throws FunctionalException, TechnicalException {
        return daoFactory.getSiteSecteurAssoDao().insert(pSiteId,pSecteurId);
    }

    @Override
    public List<Site> findAllBySecteur(int pSecteurId) throws FunctionalException, TechnicalException {
        List<Site> vList = daoFactory.getSiteSecteurAssoDao().findAllBySecteur(pSecteurId);

        return vList;
    }

    @Override
    public List<Secteur> findAllBySite(int pSiteId) throws FunctionalException, TechnicalException {
        List<Secteur> vList = daoFactory.getSiteSecteurAssoDao().findAllBySite(pSiteId);

        return vList;
    }

    @Override
    public int findBySiteAndSecteur(int pSiteId, int pSecteurId) throws FunctionalException, TechnicalException {
        return daoFactory.getSiteSecteurAssoDao().findBySiteAndSecteur(pSiteId,pSecteurId);
    }


}
