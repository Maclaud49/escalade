package com.parlow.escalade.consumer.dao.rowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.parlow.escalade.model.bean.Secteur;
import org.springframework.jdbc.core.RowMapper;


public class SecteurRM implements RowMapper {

    public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
        Secteur secteur = new Secteur();
        secteur.setId(rs.getInt("id"));
        secteur.setNom(rs.getString("nom"));
        return secteur;
    }

}
