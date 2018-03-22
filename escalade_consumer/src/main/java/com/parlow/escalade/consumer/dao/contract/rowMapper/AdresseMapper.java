package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.model.bean.Adresse;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AdresseMapper implements RowMapper<Adresse> {
    public Adresse mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("Adresse mapRow");
        Adresse adresse = new Adresse();
        adresse.setId(rs.getInt("id"));
        adresse.setAdresse1(rs.getString("adresse1"));
        adresse.setAdresse2(rs.getString("adresse2"));
        adresse.setCodePostal(rs.getString("codePostal"));
        adresse.setVille(rs.getString("ville"));
        adresse.setPays(rs.getString("pays"));
        return adresse;
    }
}
