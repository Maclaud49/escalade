package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.SiteDao;

import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.joda.time.DateTime;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Named;
import java.sql.*;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDaoImpl  implements SiteDao {

    private static final String SQL_SELECT        = "SELECT id, nom FROM t_site ORDER BY id";
    private static final String SQL_SELECT_PAR_ID = "SELECT id, nom FROM t_site WHERE id = ?";
    private static final String SQL_INSERT        = "INSERT INTO t_site (nom) VALUES (?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM t_site WHERE id = ?";
    private static final String SQL_LAST_ID       = "SELECT MAX(id) FROM t_site";

    @Override
    public int insert(Site site) {

        String vSQL_insert = "INSERT into t_site (nom, description, region_fk_id, dateCreation) VALUES(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
            public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                PreparedStatement pst =
                        con.prepareStatement(vSQL_insert, new String[] {"id"});
                pst.setString(1, site.getNom());
                pst.setString(2,site.getDescription());
                pst.setInt(3,site.getRegion().getId());
                pst.setTimestamp(4,site.getDateCreation());
                return pst;
            }
        },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;


    }

    @Override
    public Site findById(int id){
        Site vSite = new Site();
        vSite.setId(1);
        vSite.setNom("Site 1");
        vSite.setDescription("Un site tip top");
        Utilisateur mac = new Utilisateur();
        mac.setId(1);
        mac.setPrenom("Mickael");
        vSite.setUtilisateur(mac);

        return vSite;
    }

    @Override
    public List<Site> findAll() {
        return null;
    }

    @Override
    public void delete(int siteid) {

    }


}
