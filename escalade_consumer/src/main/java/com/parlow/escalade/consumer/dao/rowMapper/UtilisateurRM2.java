package com.parlow.escalade.consumer.dao.rowMapper;


import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;


public class UtilisateurRM2 implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Utilisateur user = new Utilisateur();
        user.setId(rs.getInt("id"));
        user.setNom(rs.getString("nom"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setPrenom(rs.getString("prenom"));
        user.setProfil(rs.getInt("profil"));

        return user;
    }
}
