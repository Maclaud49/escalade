package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UtilisateurMapper implements RowMapper<Utilisateur> {
    @Inject
    DaoFactory daoFactory;

    public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("Utilisateur mapRow");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(rs.getInt("id"));
        utilisateur.setNom(rs.getString("nom"));
        utilisateur.setPrenom(rs.getString("prenom"));
        utilisateur.setDateNaissance(rs.getDate("dateNaissance"));
        utilisateur.setEmail(rs.getString("email"));
        utilisateur.setPassword(rs.getString("password"));
        utilisateur.setCotation(rs.getString("cotation"));
        try {
            utilisateur.setAdresse(daoFactory.getAdresseDao().findById(rs.getInt("adresse_fk_id")));
        } catch (Exception e) {
            System.out.println("Adresse non trouvée");
        }
        utilisateur.setProfil(rs.getString("profil"));
        return utilisateur;
    }
}
