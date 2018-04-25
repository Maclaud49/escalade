package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.VoieDao;
import com.parlow.escalade.consumer.dao.contract.rowMapper.VoieMapper;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Named;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class VoieDaoImpl extends AbstractDaoImpl implements VoieDao{

    @Override
    public Voie findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_voie,t_utilisateur WHERE voie_id = ? AND voie_utilisateur_fk_id=utilisateur_id";
        Voie voie = (Voie) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new VoieMapper());
        return voie;
    }

    @Override
    public List<Voie> findAll() {
        String vSQL_findAll = "SELECT * FROM t_voie,t_utilisateur WHERE voie_utilisateur_fk_id = utilisateur_id ORDER BY voie_datecreation DESC";
        List<Voie> voies  = this.vJdbcTemplate.query(vSQL_findAll, new VoieMapper());
        return voies;
    }

    @Override
    public int insert(Voie pVoie) throws FunctionalException {
        String vSQL_insert = "INSERT into t_voie (voie_nom,voie_description, voie_lastUpdate, voie_image, voie_dateCreation, voie_utilisateur_fk_id, voie_publication, voie_hauteurVoie, voie_nbPoints, voie_cotation, voie_equipee) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update(new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"voie_id"});
                                           pst.setString(1, pVoie.getNom());
                                           pst.setString(2, pVoie.getDescription());
                                           pst.setTimestamp(3, pVoie.getDateCreation());
                                           pst.setString(4, pVoie.getImage());
                                           pst.setTimestamp(5, pVoie.getDateCreation());
                                           pst.setInt(6, pVoie.getUtilisateur().getId());
                                           pst.setBoolean(7, false);
                                           pst.setDouble(8, pVoie.getHauteurVoie());
                                           pst.setInt(9, pVoie.getNbPoints());
                                           pst.setString(10, pVoie.getCotation());
                                           pst.setBoolean(11, pVoie.isEquipee());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_voie WHERE voie_id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Voie pVoie) throws FunctionalException {
        String vSQL_update = "UPDATE t_voie SET voie_nom = ?, voie_description = ?, voie_lastUpdate = ?, voie_image = ?," +
                "  voie_publication = ?, voie_hauteurVoie =?, voie_cotation =?, voie_nbPoints = ?, voie_equipee = ? WHERE voie_id = ?";
        this.vJdbcTemplate.update(vSQL_update, pVoie.getNom(),pVoie.getDescription(),pVoie.getLastUpdate(),
                pVoie.getImage(),pVoie.isPublication(),pVoie.getHauteurVoie(),pVoie.getCotation(),pVoie.getNbPoints(),pVoie.isEquipee(),pVoie.getId());
    }

    @Override
    public List<Voie> findAllBySecteurId(int secteurId) throws NotFoundException {
        String vSQL_findAll = "SELECT * FROM t_voie, t_utilisateur WHERE voie_secteur_fk_id = ? AND voie_utilisateur_fk_id = utilisateur_id";
        List<Voie> voies  = this.vJdbcTemplate.query(vSQL_findAll, new Object[] { secteurId }, new RowMapper<Voie>() {
            @Override
            public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
                VoieMapper voieMapper = new VoieMapper();
                return voieMapper.mapRow(rs, rowNum);
            }
        });

        return voies;
    }

    @Override
    public List<Voie> searchResult(String keyWord) {

        String vSQL_findAll = "SELECT * FROM t_voie, t_utilisateur where concat(voie_nom,voie_description,voie_datecreation,utilisateur_nom,utilisateur_prenom)  ILIKE ? AND voie_utilisateur_fk_id = utilisateur_id ORDER BY voie_datecreation DESC";
        List<Voie> voies  = this.vJdbcTemplate.query(vSQL_findAll, new Object[] { keyWord }, new RowMapper<Voie>() {
            @Override
            public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
                VoieMapper voieMapper = new VoieMapper();
                return voieMapper.mapRow(rs, rowNum);
            }
        });

        return voies;
        
    }

    @Override
    public Voie findByName(String pNom) throws NotFoundException {
        String sql_findByName = "SELECT * FROM t_voie, t_utilisateur WHERE voie_nom = ? AND voie_utilisateur_fk_id = utilisateur_id";

        try {
            Voie voie = this.vJdbcTemplate.queryForObject(
                    sql_findByName, new Object[]{pNom}, new VoieMapper());
            return voie;
        } catch (Exception e) {
            throw new NotFoundException("Aucun voie correspondant à ce nom fourni.");
        }
    }


}
