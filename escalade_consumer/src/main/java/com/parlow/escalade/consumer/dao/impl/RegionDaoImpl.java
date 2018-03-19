package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.RegionDao;
import com.parlow.escalade.model.bean.listes.Region;
import com.parlow.escalade.model.exception.NotFoundException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.inject.Named;
import java.util.List;

@Named
public class RegionDaoImpl extends AbstractDaoImpl implements RegionDao {


    @Override
    public void insert(Region region) {

    }

    @Override
    public Region findById(int id) throws NotFoundException {
        return null;
    }

    @Override
    public List<Region> findAll() {
        String vSQL_findAll = "SELECT * FROM t_region ORDER BY region ASC ";
        List<Region> regions  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Region.class));

        return regions;
    }

    @Override
    public void delete(int regionid) throws NotFoundException {

    }
}
