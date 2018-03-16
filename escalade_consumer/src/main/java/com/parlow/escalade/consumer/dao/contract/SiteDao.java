package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.Site;

import java.util.List;

public interface SiteDao {

    void insert( Site site )  ;

    Site findById( int id )  ;

    List<Site> findAll()  ;

    void delete( int siteid )  ;
}
