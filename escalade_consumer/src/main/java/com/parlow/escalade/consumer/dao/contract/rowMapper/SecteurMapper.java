package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Commentaire;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;


public class SecteurMapper implements RowMapper<Secteur> {
    private static final Logger logger = LogManager.getLogger(SecteurMapper.class);

    @Inject
    protected DaoFactory daoFactory;

    public Secteur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Secteur secteur = new Secteur();
        secteur.setId(rs.getInt("secteur_id"));
        secteur.setNom(rs.getString("secteur_nom"));
        secteur.setDescription(rs.getString("secteur_description"));
        secteur.setDateCreation(rs.getTimestamp("secteur_dateCreation"));
        secteur.setLastUpdate(rs.getTimestamp("secteur_lastUpdate"));
        secteur.setPublication(rs.getBoolean("secteur_publication"));
        secteur.setImage(rs.getString("secteur_image"));

        UtilisateurMapper utilisateurMapper = new UtilisateurMapper();
        Utilisateur utilisateur = utilisateurMapper.mapRow(rs,rowNum);
        secteur.setUtilisateur(utilisateur);

        secteur.setDepartement(rs.getString("secteur_departement"));

        return secteur;
    }
    
}
