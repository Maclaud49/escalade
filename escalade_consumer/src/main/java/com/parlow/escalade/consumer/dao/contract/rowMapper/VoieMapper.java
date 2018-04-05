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

        Voie voie = new Voie();
        voie.setId(rs.getInt("voie_id"));
        voie.setNom(rs.getString("voie_nom"));
        voie.setDescription(rs.getString("voie_description"));
        voie.setDateCreation(rs.getTimestamp("voie_dateCreation"));
        voie.setLastUpdate(rs.getTimestamp("voie_lastUpdate"));
        voie.setPublication(rs.getBoolean("voie_publication"));
        voie.setImage(rs.getString("voie_image"));

        UtilisateurMapper utilisateurMapper = new UtilisateurMapper();
        Utilisateur utilisateur = utilisateurMapper.mapRow(rs,rowNum);
        voie.setUtilisateur(utilisateur);

        voie.setHauteurVoie(rs.getDouble("voie_hauteurVoie"));
        voie.setCotation(rs.getString("voie_cotation"));
        voie.setNbPoints(rs.getInt("voie_nbPoints"));
        voie.setEquipee(rs.getBoolean("voie_equipee"));
        logger.info("equipee "+ voie.isEquipee());

        return voie;
    }

}
