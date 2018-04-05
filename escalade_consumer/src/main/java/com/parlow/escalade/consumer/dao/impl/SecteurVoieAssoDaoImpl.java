package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.SecteurVoieAssoDao;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.TechnicalException;

import javax.inject.Named;
import java.util.List;

@Named
public class SecteurVoieAssoDaoImpl extends AbstractDaoImpl implements SecteurVoieAssoDao {
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