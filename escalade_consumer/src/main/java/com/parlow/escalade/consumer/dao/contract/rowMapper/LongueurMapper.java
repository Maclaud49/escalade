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
        logger.info("Longueur mapRow");
        Longueur longueur = new Longueur();
        longueur.setId(rs.getInt("longueur_id"));
        longueur.setRelai(rs.getDouble("longueur_relai"));
        VoieMapper voieMapper = new VoieMapper();
        Voie voie = voieMapper.mapRow(rs,rowNum);
        longueur.setVoie(voie);
        longueur.setCotation(rs.getString("longueur_cotation"));
        longueur.setLastUpdate(rs.getTimestamp("longueur_lastUpdate"));
        longueur.setDateCreation(rs.getTimestamp("longueur_dateCreation"));
        UtilisateurMapper utilisateurMapper = new UtilisateurMapper();
        Utilisateur utilisateur = utilisateurMapper.mapRow(rs,rowNum);
        longueur.setUtilisateur(utilisateur);
        longueur.setImage(rs.getString("longueur_image"));
        longueur.setPublication(rs.getBoolean("longueur_publication"));

        return longueur;
    }


}