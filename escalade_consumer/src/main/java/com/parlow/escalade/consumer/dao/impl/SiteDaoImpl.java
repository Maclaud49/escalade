package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.SiteDao;

import com.parlow.escalade.consumer.dao.contract.rowMapper.SiteMapper;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Named;
import java.sql.*;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {

    @Override
    public Site findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_site WHERE t_site.id = ?";
        Site site = this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new SiteMapper());
        return site;
    }

    @Override
    public List<Site> findAll() {
        String vSQL_findAll = "SELECT * FROM t_site";
        List<Site> sites  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Site.class));
        return sites;
    }

    @Override
    public int insert(Site pSite) throws FunctionalException, TechnicalException{
        String vSQL_insert = "INSERT into t_site (nom, region, description,lastUpdate, image, dateCreation, utilisateur_fk_id, publication) VALUES(?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[]{"id"});
                                               pst.setString(1, pSite.getNom());
                                               pst.setString(2, pSite.getRegion());
                                               pst.setString(3, pSite.getDescription());
                                               pst.setTimestamp(4, pSite.getDateCreation());
                                               pst.setString(5, pSite.getImage());
                                               pst.setTimestamp(6, pSite.getDateCreation());
                                               pst.setInt(7, pSite.getUtilisateur().getId());
                                               pst.setBoolean(8, false);
                                               return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException, TechnicalException {
        String vSQL_delete = "DELETE FROM t_site WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Site pSite) throws FunctionalException {
        String vSQL_update = "UPDATE t_site SET nom = ?, region = ?, description = ?, lastUpdate = ?, image = ?," +
                " dateCreation = ?, utilisateur_fk_id = ?, publication = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, pSite.getNom(), pSite.getRegion(),pSite.getDescription(),pSite.getLastUpdate(),
                pSite.getImage(),pSite.getDateCreation(),pSite.getUtilisateur().getId(),pSite.isPublication(),pSite.getId());
    }
}


