package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.CotationDao;
import com.parlow.escalade.model.bean.Cotation;
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
public class CotationDaoImpl extends AbstractDaoImpl implements CotationDao {

    @Override
    public Cotation findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_cotation WHERE id = ?";
        Cotation cotation = (Cotation) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Cotation.class));
        return cotation;
    }

    @Override
    public List<Cotation> findAll() {
        String vSQL_findAll = "SELECT * FROM t_cotation";
        List<Cotation> cotations  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Cotation.class));
        return cotations;
    }

    @Override
    public int insert(Cotation pCotation) throws FunctionalException {
        String vSQL_insert = "INSERT into t_cotation (nom, description, region_fk_id, dateCreation) VALUES(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setString(1, pCotation.getNom());
                                           pst.setString(2,pCotation.getDescription());
                                           pst.setInt(3,pCotation.getRegion().getId());
                                           pst.setTimestamp(4,pCotation.getDateCreation());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_cotation WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Cotation pCotation) throws FunctionalException {
        String vSQL_update = "UPDATE t_cotation SET age = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, age, id);
    }
