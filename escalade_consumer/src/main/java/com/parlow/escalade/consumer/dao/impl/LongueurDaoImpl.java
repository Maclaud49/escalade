package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.LongueurDao;
import com.parlow.escalade.model.bean.Longueur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Named;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Named
public class LongueurDaoImpl extends AbstractDaoImpl implements LongueurDao {

    @Override
    public Longueur findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_longueur WHERE id = ?";
        Longueur longueur = (Longueur) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Longueur.class));
        return longueur;
    }

    @Override
    public List<Longueur> findAll() {
        String vSQL_findAll = "SELECT * FROM t_longueur";
        List<Longueur> longueurs  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Longueur.class));
        return longueurs;
    }

    @Override
    public int insert(Longueur pLongueur) throws FunctionalException {
        String vSQL_insert = "INSERT into t_longueur (nom, description, region_fk_id, dateCreation) VALUES(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setString(1, pLongueur.getNom());
                                           pst.setString(2,pLongueur.getDescription());
                                           pst.setInt(3,pLongueur.getRegion().getId());
                                           pst.setTimestamp(4,pLongueur.getDateCreation());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_longueur WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Longueur pLongueur) throws FunctionalException {
        String vSQL_update = "UPDATE t_longueur SET age = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, age, id);
    }
