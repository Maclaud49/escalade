package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Commentaire;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.bean.deleted.Image;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SecteurMapper implements RowMapper<Secteur> {
    private static final Logger logger = LogManager.getLogger(SecteurMapper.class);

    @Inject
    protected DaoFactory daoFactory;

    public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {
        logger.info("Secteur mapRow");
        Secteur secteur = new Secteur();
        secteur.setId(rs.getInt("secteur_id"));
        secteur.setNom(rs.getString("secteur_nom"));
        secteur.setDescription(rs.getString("secteur_description"));
        secteur.setLastUpdate(rs.getTimestamp("secteur_lastUpdate"));
        secteur.setDateCreation(rs.getTimestamp("secteur_dateCreation"));
        UtilisateurMapper utilisateurMapper = new UtilisateurMapper();
        Utilisateur utilisateur = utilisateurMapper.mapRow(rs,rowNum);
        secteur.setUtilisateur(utilisateur);
        logger.info("nom du utilisateur " + secteur.getUtilisateur().getNom());
        secteur.setPublication(rs.getBoolean("secteur_publication"));

        return secteur;
    }
    
}
