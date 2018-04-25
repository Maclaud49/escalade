package com.parlow.escalade.business.manager.impl;


import java.util.ArrayList;
import java.util.List;

import com.parlow.escalade.business.manager.contract.SecteurManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;
import com.parlow.escalade.model.recherche.secteur.RechercheSecteur;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * Manager des beans du package Secteur.
 *
 * @author Parlow
 */
@Named
public class SecteurManagerImpl extends AbstractManager implements SecteurManager {


    @Override
    public Secteur findById(int pId) throws NotFoundException,TechnicalException, FunctionalException {
        if (pId < 1) {
            throw new NotFoundException("Secteur non trouvé : ID=" + pId);
        }
        Secteur vSecteur = daoFactory.getSecteurDao().findById(pId);
        List<Voie> list = daoFactory.getSecteurVoieAssoDao().findAllBySecteur(pId);
        vSecteur.setVoies(list);
        return vSecteur;
    }

    @Override
    public List<Secteur> findAll() {
        List<Secteur> vList = daoFactory.getSecteurDao().findAll();
        if (vList == null) {
            Secteur secteur = new Secteur();
            secteur.setId(1);
            secteur.setNom("Pas de données");
            vList.add(secteur);
        }
        return vList;
    }

    @Override
    public int insert(Secteur pSecteur) throws FunctionalException {
        if (pSecteur == null) {
            throw new FunctionalException("L'objet Secteur ne doit pas être null !");
        }
        return daoFactory.getSecteurDao().insert(pSecteur);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Secteur non trouvé : ID=" + pId);
        }
        daoFactory.getSecteurDao().delete(pId);
    }

    @Override
    public void update(Secteur pSecteur) throws FunctionalException {
        if (pSecteur == null) {
            throw new FunctionalException("L'objet Secteur ne doit pas être null !");
        }
        daoFactory.getSecteurDao().update(pSecteur);
    }

    @Override
    public List<Secteur> searchResult(String keyWord) {
        return daoFactory.getSecteurDao().searchResult(keyWord);
    }

    @Override
    public Secteur findByName(String pNom) throws NotFoundException {
        Secteur secteur = daoFactory.getSecteurDao().findByName(pNom);
        if(secteur != null){
            return secteur;
        }
        else {
            throw new NotFoundException("Aucun secteur correspondant à ce nom.");
        }
    }

}
