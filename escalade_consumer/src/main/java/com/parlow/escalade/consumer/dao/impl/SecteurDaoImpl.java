package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.SecteurDao;
import com.parlow.escalade.consumer.dao.contract.rowMapper.SecteurMapper;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.recherche.secteur.RechercheSecteur;
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
public class SecteurDaoImpl extends AbstractDaoImpl implements SecteurDao {

    @Override
    public int getCountSecteur(RechercheSecteur pRechercheSecteur) {
        return 0;
    }

    @Override
    public Secteur findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_secteur,t_utilisateur WHERE secteur_id = ? AND secteur_utilisateur_fk_id=utilisateur_id";
        Secteur secteur = this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId}, new SecteurMapper());
        return secteur;
    }

    @Override
    public List<Secteur> findAll() {
        String vSQL_findAll = "SELECT * FROM t_secteur,t_utilisateur where secteur_utilisateur_fk_id = utilisateur_id";
        List<Secteur> secteurs  = this.vJdbcTemplate.query(vSQL_findAll, new SecteurMapper());
        return secteurs;
    }

    @Override
    public int insert(Secteur pSecteur) throws FunctionalException {
        String vSQL_insert = "INSERT into t_secteur (secteur_nom, secteur_utilisateur_fk_id,secteur_publication) VALUES(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"secteur_id"});
                                           pst.setString(1, pSecteur.getNom());
                                           pst.setInt(3,pSecteur.getUtilisateur().getId());
                                           pst.setBoolean(4,pSecteur.isPublication());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_secteur WHERE secteur_id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Secteur pSecteur) throws FunctionalException {
        String vSQL_update = "UPDATE t_secteur SET secteur_nom = ?, secteur_utilisateur_fk_id = ?,secteur_publication = ? WHERE secteur_id = ?";
        this.vJdbcTemplate.update(vSQL_update, pSecteur.getNom(),pSecteur.getUtilisateur().getId(),
                pSecteur.isPublication(),pSecteur.getId());
    }

    @Override
    public List<Secteur> findAllBySiteId(int siteId) throws NotFoundException {
        String vSQL_findAll = "SELECT * FROM t_secteur, t_utilisateur WHERE secteur_site_fk_id = ? AND secteur_utilisateur_fk_id = utilisateur_id";
        List<Secteur> secteurs  = this.vJdbcTemplate.query(vSQL_findAll, new Object[] { siteId }, new RowMapper<Secteur>() {
            @Override
            public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {
               SecteurMapper secteurMapper = new SecteurMapper();
               return secteurMapper.mapRow(rs, rowNum);
            }
        });

        return secteurs;
    }

}
