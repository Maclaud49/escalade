package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.SecteurVoieManager;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class SecteurVoieManagerImpl implements SecteurVoieManager {


    @Override
    public int insert(Voie pVoie, Secteur pSecteur) throws FunctionalException, TechnicalException {
        return 0;
    }

    @Override
    public List<Voie> findAllBySecteur(int pSecteurId) throws FunctionalException, TechnicalException {
        return null;
    }

    @Override
    public List<Secteur> findAllByVoie(int pVoieId) throws FunctionalException, TechnicalException {
        return null;
    }
}
