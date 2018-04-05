package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class UtilisateurMapper implements RowMapper<Utilisateur> {
    private static final Logger logger = LogManager.getLogger(UtilisateurMapper.class);

    @Inject
    protected DaoFactory daoFactory;

    public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
        logger.info("Utilisateur mapRow");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(rs.getInt("utilisateur_id"));
        utilisateur.setNom(rs.getString("utilisateur_nom"));
        utilisateur.setPrenom(rs.getString("utilisateur_prenom"));
        utilisateur.setDateNaissance(rs.getDate("utilisateur_dateNaissance"));
        utilisateur.setEmail(rs.getString("utilisateur_email"));
        utilisateur.setPassword(rs.getString("utilisateur_password"));
        utilisateur.setCotation(rs.getString("utilisateur_cotation"));
        utilisateur.setProfil(rs.getString("utilisateur_profil"));
        utilisateur.setAdresse1(rs.getString("adresse_adresse1"));
        utilisateur.setAdresse2(rs.getString("adresse_adresse2"));
        utilisateur.setCodePostal(rs.getString("adresse_codePostal"));
        utilisateur.setVille(rs.getString("adresse_ville"));
        utilisateur.setPays(rs.getString("adresse_pays"));

        return utilisateur;
    }
}

