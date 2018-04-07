package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.consumer.dao.contract.SiteSecteurAssoDao;
import com.parlow.escalade.consumer.dao.contract.rowMapper.SecteurMapper;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class SiteSecteurAssoDaoImpl extends AbstractDaoImpl implements SiteSecteurAssoDao {
    private static final Logger logger = LogManager.getLogger(SiteSecteurAssoDaoImpl.class);

    @Override
    public int insert(int pSiteId, int pSecteurId) throws FunctionalException, TechnicalException {
        String vSQL_insert = "INSERT into t_site_secteur_asso (site_fk_id,secteur_fk_id) VALUES(?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"site_secteur_asso_id"});
                                           pst.setInt(1, pSiteId);
                                           pst.setInt(2, pSecteurId);
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public List<Site> findAllBySecteur(int pSecteurId) throws FunctionalException, TechnicalException {
        return null;
    }

    @Override
    public List<Secteur> findAllBySite(int pSiteId) throws FunctionalException, TechnicalException {
        String vSQL_findAll = "SELECT * FROM t_site_secteur_asso, t_utilisateur,t_secteur WHERE site_fk_id = ? AND secteur_fk_id=secteur_id AND secteur_utilisateur_fk_id = utilisateur_id";
        List<Secteur> secteurs  = this.vJdbcTemplate.query(vSQL_findAll, new Object[] { pSiteId }, new RowMapper<Secteur>() {
            @Override
            public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {
                SecteurMapper secteurMapper = new SecteurMapper();
                return secteurMapper.mapRow(rs, rowNum);
            }
        });

        return secteurs;
    }
}
