package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.DepartementDao;
import com.parlow.escalade.model.bean.Departement;
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
public class DepartementDaoImpl extends AbstractDaoImpl implements DepartementDao{

    @Override
    public Departement findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_departement WHERE id = ?";
        Departement image = (Departement) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Departement.class));
        return image;
    }

    @Override
    public List<Departement> findAll() {
        String vSQL_findAll = "SELECT * FROM t_departement";
        List<Departement> images  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Departement.class));
        return images;
    }

    @Override
    public int insert(Departement pDepartement) throws FunctionalException {
        String vSQL_insert = "INSERT into t_departement (departement, region_fk_id) VALUES(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setString(1, pDepartement.getDepartement());
                                           pst.setInt(2,pDepartement.getRegion().getId());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_departement WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Departement pDepartement) throws FunctionalException {
        String vSQL_update = "UPDATE t_departement SET departement = ?, region = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, pDepartement.getDepartement(),pDepartement.getRegion().getId(), pDepartement.getId());
    }
}
