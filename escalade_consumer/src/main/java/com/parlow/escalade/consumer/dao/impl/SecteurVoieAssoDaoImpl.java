package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.SecteurVoieAssoDao;
import com.parlow.escalade.consumer.dao.contract.rowMapper.SecteurMapper;
import com.parlow.escalade.consumer.dao.contract.rowMapper.VoieMapper;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
public class SecteurVoieAssoDaoImpl extends AbstractDaoImpl implements SecteurVoieAssoDao {
    private static final Logger logger = LogManager.getLogger(SecteurVoieAssoDaoImpl.class);

    @Override
    public int insert(int pSecteurId, int pVoieId) throws FunctionalException, TechnicalException {
        String vSQL_insert = "INSERT into t_secteur_voie_asso (secteur_fk_id,voie_fk_id) VALUES(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"secteur_voie_asso_id"});
                                           pst.setInt(1, pSecteurId);
                                           pst.setInt(2, pVoieId);
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public List<Voie> findAllBySecteur(int pSecteurId) throws FunctionalException, TechnicalException {
        String vSQL_findAll = "SELECT * FROM t_secteur_voie_asso, t_utilisateur,t_voie WHERE secteur_fk_id = ? AND voie_fk_id=voie_id AND voie_utilisateur_fk_id = utilisateur_id";
        List<Voie> voies  = this.vJdbcTemplate.query(vSQL_findAll, new Object[] { pSecteurId }, new RowMapper<Voie>() {
            @Override
            public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
                VoieMapper voieMapper = new VoieMapper();
                return voieMapper.mapRow(rs, rowNum);
            }
        });

        return voies;
    }

    @Override
    public List<Secteur> findAllByVoie(int pVoieId) throws FunctionalException, TechnicalException {
        return null;
    }

    @Override
    public int findBySecteurAndVoie(int pSecteurId, int pVoieId) throws FunctionalException, TechnicalException {
        String vSQL_findBySecteurAndVoie = "SELECT count(*) FROM t_secteur_voie_asso WHERE secteur_fk_id = ? AND voie_fk_id=?";
        int result  = this.vJdbcTemplate.queryForObject(vSQL_findBySecteurAndVoie, new Object[] { pSecteurId, pVoieId }, Integer.class);

        return result ;
    }
}
