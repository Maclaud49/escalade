package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.ProfilDao;
import com.parlow.escalade.model.bean.Profil;
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
public class ProfilDaoImpl extends AbstractDaoImpl implements ProfilDao {
    @Override
    public Profil findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_profil WHERE id = ?";
        Profil profil = (Profil) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Profil.class));
        return profil;
    }

    @Override
    public List<Profil> findAll() {
        String vSQL_findAll = "SELECT * FROM t_profil";
        List<Profil> profils  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Profil.class));
        return profils;
    }

    @Override
    public int insert(Profil pProfil) throws FunctionalException {
        String vSQL_insert = "INSERT into t_profil (nom, description, region_fk_id, dateCreation) VALUES(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setString(1, pProfil.getNom());
                                           pst.setString(2,pProfil.getDescription());
                                           pst.setInt(3,pProfil.getRegion().getId());
                                           pst.setTimestamp(4,pProfil.getDateCreation());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_profil WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Profil pProfil) throws FunctionalException {
        String vSQL_update = "UPDATE t_profil SET age = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, age, id);
    }
    
}
