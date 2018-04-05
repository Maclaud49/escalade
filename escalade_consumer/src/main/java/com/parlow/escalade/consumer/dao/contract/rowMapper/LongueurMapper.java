package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Commentaire;
import com.parlow.escalade.model.bean.Longueur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public class LongueurMapper implements RowMapper<Longueur> {

    private static final Logger logger = LogManager.getLogger(SecteurMapper.class);

    @Inject
    protected DaoFactory daoFactory;

    public Longueur mapRow(ResultSet rs, int rowNum) throws SQLException {
        Longueur longueur = new Longueur();
        longueur.setId(rs.getInt("longueur_id"));
        longueur.setNom(rs.getString("longueur_nom"));
        longueur.setDescription(rs.getString("longueur_description"));
        longueur.setDateCreation(rs.getTimestamp("longueur_dateCreation"));
        longueur.setLastUpdate(rs.getTimestamp("longueur_lastUpdate"));
        longueur.setPublication(rs.getBoolean("longueur_publication"));
        longueur.setImage(rs.getString("longueur_image"));

        UtilisateurMapper utilisateurMapper = new UtilisateurMapper();
        Utilisateur utilisateur = utilisateurMapper.mapRow(rs,rowNum);
        longueur.setUtilisateur(utilisateur);

        longueur.setRelai(rs.getDouble("longueur_relai"));
        longueur.setCotation(rs.getString("longueur_cotation"));

        return longueur;
    }


}