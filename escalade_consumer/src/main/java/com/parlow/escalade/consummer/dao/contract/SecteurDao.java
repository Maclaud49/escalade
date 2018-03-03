package com.parlow.escalade.consummer.dao.contract;

import com.parlow.escalade.consummer.dao.util.DAOException;
import com.parlow.escalade.model.bean.Secteur;

import java.util.List;

public interface SecteurDao {

    void creer( Secteur secteur ) throws DAOException;

    Secteur trouver( int id ) throws DAOException;

    List<Secteur> lister() throws DAOException;

    void supprimer( Secteur secteur ) throws DAOException;
}
