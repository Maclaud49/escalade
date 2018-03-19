package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.listes.Region;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface RegionDao {

    void insert(Region region);

    Region findById(int id) throws NotFoundException;

    List<Region> findAll();

    void delete(int regionid) throws NotFoundException;
}
