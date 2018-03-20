package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.SiteDao;

import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Named;
import java.sql.*;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {


    @Override
    public Site findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_site WHERE id = ?";
        Site site = (Site) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Site.class));
        return site;
    }

    @Override
    public List<Site> findAll() {
        String vSQL_findAll = "SELECT * FROM t_site";
        List<Site> sites  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Site.class));
        return sites;
    }

    @Override
    public int insert(Site pSite) throws FunctionalException {
        String vSQL_insert = "INSERT into t_site (nom, description, region_fk_id, dateCreation) VALUES(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setString(1, pSite.getNom());
                                           pst.setString(2,pSite.getDescription());
                                           pst.setInt(3,pSite.getRegion().getId());
                                           pst.setTimestamp(4,pSite.getDateCreation());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_site WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Site pSite) throws FunctionalException {
        String vSQL_update = "UPDATE t_site SET age = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, age, id);
    }



}
