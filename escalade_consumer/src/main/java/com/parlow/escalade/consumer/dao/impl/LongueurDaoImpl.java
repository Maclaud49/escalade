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
        List<Longueur> longueurs = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Longueur.class));
        return longueurs;
    }

    @Override
    public int insert(Longueur pLongueur) throws FunctionalException {
        String vSQL_insert = "INSERT INTO t_longueur (relai, voie, cotation_fk_id, utilisateur_fk_id) VALUES(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update(new PreparedStatementCreator() {
                                      public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                          PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[]{"id"});
                                          pst.setDouble(1, pLongueur.getRelai());
                                          pst.setInt(2, pLongueur.getVoie().getId());
                                          pst.setString(3, pLongueur.getCotation());
                                          pst.setInt(4, pLongueur.getUtilisateur().getId());
                                          return pst;
                                      }
                                  },
                keyHolder);
        int key = (Integer) keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_longueur WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Longueur pLongueur) throws FunctionalException {
        String vSQL_update = "UPDATE t_longueur SET relai = ?,voie_fk_id = ?,cotation = ?,utilisateur_fk_id = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, pLongueur.getRelai(), pLongueur.getVoie().getId(), pLongueur.getCotation(),
                pLongueur.getUtilisateur().getId(), pLongueur.getId());
    }
}
