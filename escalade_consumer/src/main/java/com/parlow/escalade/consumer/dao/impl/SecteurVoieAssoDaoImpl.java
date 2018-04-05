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
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class SecteurVoieAssoDaoImpl extends AbstractDaoImpl implements SecteurVoieAssoDao {
    private static final Logger logger = LogManager.getLogger(SecteurVoieAssoDaoImpl.class);

    @Override
    public int insert(Voie pVoie, Secteur pSecteur) throws FunctionalException, TechnicalException {
        return 0;
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
}
