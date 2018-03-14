package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.SecteurDao;
import com.parlow.escalade.consumer.dao.util.DAOException;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.recherche.secteur.RechercheSecteur;

import javax.inject.Named;
import java.util.List;

@Named
public class SecteurDaoImpl implements SecteurDao {
    @Override
    public int getCountSecteur(RechercheSecteur pRechercheSecteur) {
        return 0;
    }

    @Override
    public void insert(Secteur secteur) throws DAOException {

    }

    @Override
    public Secteur findById(int id) throws DAOException {
        return null;
    }

    @Override
    public List<Secteur> findAll() throws DAOException {
        return null;
    }

    @Override
    public void delete(int secteurid) throws DAOException {

    }
}
