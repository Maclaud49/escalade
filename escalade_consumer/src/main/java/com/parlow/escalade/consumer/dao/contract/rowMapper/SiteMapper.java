package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.consumer.dao.contract.UtilisateurDao;
import com.parlow.escalade.consumer.dao.impl.UtilisateurDaoImpl;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;


import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class SiteMapper implements RowMapper<Site> {
    private static final Logger logger = LogManager.getLogger(SiteMapper.class);

    @Inject
    protected DaoFactory daoFactory;

    public Site mapRow(ResultSet rs, int rowNum) throws SQLException {

        Site site = new Site();
        site.setId(rs.getInt("site_id"));
        site.setNom(rs.getString("site_nom"));
        site.setDescription(rs.getString("site_description"));
        site.setDateCreation(rs.getTimestamp("site_dateCreation"));
        site.setLastUpdate(rs.getTimestamp("site_lastUpdate"));
        site.setPublication(rs.getBoolean("site_publication"));
        site.setImage(rs.getString("site_image"));

        UtilisateurMapper utilisateurMapper = new UtilisateurMapper();
        Utilisateur utilisateur = utilisateurMapper.mapRow(rs,rowNum);
        site.setUtilisateur(utilisateur);


        site.setRegion(rs.getString("site_region"));

        return site;
    }

}

