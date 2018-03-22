package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Site;
import org.springframework.jdbc.core.RowMapper;


import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SiteMapper implements RowMapper<Site> {
    @Inject
    DaoFactory daoFactory;


    public Site mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("Site mapRow");
        Site site = new Site();
        site.setId(rs.getInt("id"));
        site.setNom(rs.getString("nom"));
        site.setRegion(rs.getString("region"));
        site.setDescription(rs.getString("description"));
        site.setLastUpdate(rs.getTimestamp("lastUpdate"));
        site.setImage(rs.getString("image"));
        site.setDateCreation(rs.getTimestamp("dateCreation"));
        try {
            System.out.println("id du utilisateur " + rs.getInt("utilisateur_fk_id"));
            site.setUtilisateur(daoFactory.getUtilisateurDao().findById(rs.getInt("utilisateur_fk_id")));
        } catch (Exception e) {
            System.out.println("Utilisateur non trouvé");
        }
        site.setPublication(rs.getBoolean("publication"));
        return site;
    }

}
