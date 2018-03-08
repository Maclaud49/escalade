package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.consumer.dao.util.DAOException;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.recherche.secteur.RechercheSecteur;

import java.util.List;

public interface SecteurDao {

    int getCountSecteur(RechercheSecteur pRechercheSecteur);

    void insert(Secteur secteur) throws DAOException;

    Secteur findById(int id) throws DAOException;

    List<Secteur> findAll() throws DAOException;

    void delete(int secteurid) throws DAOException;
}
