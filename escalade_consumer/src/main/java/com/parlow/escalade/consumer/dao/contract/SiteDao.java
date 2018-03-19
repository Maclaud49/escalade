package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface SiteDao {

    int insert( Site site )  ;

    Site findById( int id ) throws NotFoundException;

    List<Site> findAll()  ;

    void delete( int siteid )  ;
}
