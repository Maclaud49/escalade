package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.SecteurDao;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.recherche.secteur.RechercheSecteur;
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
public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {

    @Override
    public Secteur findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_secteur WHERE id = ?";
        Secteur secteur = (Secteur) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Secteur.class));
        return secteur;
    }

    @Override
    public List<Secteur> findAll() {
        String vSQL_findAll = "SELECT * FROM t_secteur";
        List<Secteur> secteurs  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Secteur.class));
        return secteurs;
    }

    @Override
    public int insert(Secteur pSecteur) throws FunctionalException {
        String vSQL_insert = "INSERT into t_secteur (nom, description, region_fk_id, dateCreation) VALUES(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setString(1, pSecteur.getNom());
                                           pst.setString(2,pSecteur.getDescription());
                                           pst.setInt(3,pSecteur.getRegion().getId());
                                           pst.setTimestamp(4,pSecteur.getDateCreation());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_secteur WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Secteur pSecteur) throws FunctionalException {
        String vSQL_update = "UPDATE t_secteur SET age = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, age, id);
    }
    
}
