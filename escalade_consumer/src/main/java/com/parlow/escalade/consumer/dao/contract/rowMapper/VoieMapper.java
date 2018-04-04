package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VoieMapper implements RowMapper<Voie> {

    private static final Logger logger = LogManager.getLogger(SecteurMapper.class);

    @Inject
    protected DaoFactory daoFactory;

    public Voie mapRow(ResultSet rs, int rowNum) throws SQLException {
        logger.info("Voie mapRow");
        Voie voie = new Voie();
        voie.setId(rs.getInt("voie_id"));
        voie.setNom(rs.getString("voie_nom"));
        voie.setNbPoints(Integer.parseInt(rs.getString("voie_nbPoints")));
        voie.setEquipee(Boolean.parseBoolean(rs.getString("voie_equipee")));
        voie.setDescription(rs.getString("voie_description"));
        voie.setLastUpdate(rs.getTimestamp("voie_lastUpdate"));
        voie.setDateCreation(rs.getTimestamp("voie_dateCreation"));
        UtilisateurMapper utilisateurMapper = new UtilisateurMapper();
        Utilisateur utilisateur = utilisateurMapper.mapRow(rs,rowNum);
        voie.setUtilisateur(utilisateur);
        logger.info("nom du utilisateur " + voie.getUtilisateur().getNom());
        voie.setPublication(rs.getBoolean("voie_publication"));

        return voie;
    }

}
