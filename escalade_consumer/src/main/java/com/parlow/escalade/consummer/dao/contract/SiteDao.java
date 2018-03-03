package com.parlow.escalade.consummer.dao.contract;

import com.parlow.escalade.consummer.dao.util.DAOException;
import com.parlow.escalade.model.bean.Site;

import java.util.List;

public interface SiteDao {

    void creer( Site site ) throws DAOException;

    Site trouver( int id ) throws DAOException;

    List<Site> lister() throws DAOException;

    void supprimer( Site site ) throws DAOException;
}
