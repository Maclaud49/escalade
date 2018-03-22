package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.model.bean.Adresse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdresseMapper implements RowMapper<Adresse> {
    public Adresse mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("Adresse mapRow");
        Adresse adresse = new Adresse();
        adresse.setId(rs.getInt("adresse_id"));
        adresse.setAdresse1(rs.getString("adresse_adresse1"));
        adresse.setAdresse2(rs.getString("adresse_adresse2"));
        adresse.setCodePostal(rs.getString("adresse_codePostal"));
        adresse.setVille(rs.getString("adresse_ville"));
        adresse.setPays(rs.getString("adresse_pays"));
        return adresse;
    }
}
