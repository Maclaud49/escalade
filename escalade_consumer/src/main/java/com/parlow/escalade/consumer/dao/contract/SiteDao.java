package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.consumer.dao.util.DAOException;
import com.parlow.escalade.model.bean.Site;

import java.util.List;

public interface SiteDao {

    void insert( Site site ) throws DAOException;

    Site findById( int id ) throws DAOException;

    List<Site> findAll() throws DAOException;

    void delete( int siteid ) throws DAOException;
}
