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
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class SiteSecteurAssoDaoImpl extends AbstractDaoImpl implements SiteSecteurAssoDao {
    private static final Logger logger = LogManager.getLogger(SiteSecteurAssoDaoImpl.class);

    @Override
    public int insert(Site pSite, Secteur pSecteur) throws FunctionalException, TechnicalException {
        return 0;
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
