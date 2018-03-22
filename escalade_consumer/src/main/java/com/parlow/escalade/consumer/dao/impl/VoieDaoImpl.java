package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.VoieDao;
import com.parlow.escalade.model.bean.Voie;
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
public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao{

    @Override
    public Voie findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_voie WHERE id = ?";
        Voie voie = (Voie) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Voie.class));
        return voie;
    }

    @Override
    public List<Voie> findAll() {
        String vSQL_findAll = "SELECT * FROM t_voie";
        List<Voie> voies  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Voie.class));
        return voies;
    }

    @Override
    public int insert(Voie pVoie) throws FunctionalException {
        String vSQL_insert = "INSERT into t_voie (nom, cotation, nbPoints, equipee,secteur_fk_id,interet,utilisateur_fk_id) VALUES(?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update(new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setString(1, pVoie.getNom());
                                           pst.setString(2,pVoie.getCotation());
                                           pst.setInt(3,pVoie.getNbPoints());
                                           pst.setBoolean(4,pVoie.isEquipee());
                                           pst.setInt(5,pVoie.getSecteur().getId());
                                           pst.setInt(6,pVoie.getInteret());
                                           pst.setInt(7,pVoie.getUtilisateur().getId());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_voie WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Voie pVoie) throws FunctionalException {
        String vSQL_update = "UPDATE t_voie SET nom = ?, cotation = ?, nbPoints = ?, equipee = ?," +
                " secteur_fk_id = ?, interet = ?, utilisateur_fk_id = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, pVoie.getNom(), pVoie.getCotation(), pVoie.getNbPoints(),
                pVoie.isEquipee(), pVoie.getSecteur().getId(), pVoie.getInteret(), pVoie.getUtilisateur().getId(), pVoie.getId());
    }
}
