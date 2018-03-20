package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.AdresseDao;
import com.parlow.escalade.model.bean.Adresse;
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
public class AdresseDaoImpl extends AbstractDaoImpl implements AdresseDao {

    @Override
    public Adresse findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_adresse WHERE id = ?";
        Adresse adresse = (Adresse) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Adresse.class));
        return adresse;
    }

    @Override
    public List<Adresse> findAll() {
        String vSQL_findAll = "SELECT * FROM t_adresse";
        List<Adresse> adresses  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Adresse.class));
        return adresses;
    }

    @Override
    public int insert(Adresse pAdresse) throws FunctionalException {
        String vSQL_insert = "INSERT into t_adresse (nom, description, region_fk_id, dateCreation) VALUES(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setString(1, pAdresse.getNom());
                                           pst.setString(2,pAdresse.getDescription());
                                           pst.setInt(3,pAdresse.getRegion().getId());
                                           pst.setTimestamp(4,pAdresse.getDateCreation());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_adresse WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Adresse pAdresse) throws FunctionalException {
        String vSQL_update = "UPDATE t_adresse SET age = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, age, id);
    }
}
