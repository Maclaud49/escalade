package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.consumer.dao.contract.SiteDao;

import com.parlow.escalade.consumer.dao.contract.UtilisateurDao;
import com.parlow.escalade.consumer.dao.contract.rowMapper.SiteMapper;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.*;
import java.util.List;

@Named
public class SiteDaoImpl extends AbstractDaoImpl implements SiteDao {

    @Inject
    protected DaoFactory daoFactory;

    @Override
    public Site findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_site,t_utilisateur,t_adresse WHERE site_id = ?";
        Site site = this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new SiteMapper());
        return site;
    }

    @Override
    public List<Site> findAll() {
        String vSQL_findAll = "SELECT * FROM t_site";
        List<Site> sites  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Site.class));
        return sites;
    }

    @Override
    public int insert(Site pSite) throws FunctionalException, TechnicalException{
        String vSQL_insert = "INSERT into t_site (site_nom, site_region, site_description,site_lastUpdate, site_image, site_dateCreation, site_utilisateur_fk_id, site_publication) VALUES(?,?,?,?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[]{"site_id"});
                                               pst.setString(1, pSite.getNom());
                                               pst.setString(2, pSite.getRegion());
                                               pst.setString(3, pSite.getDescription());
                                               pst.setTimestamp(4, pSite.getDateCreation());
                                               pst.setString(5, pSite.getImage());
                                               pst.setTimestamp(6, pSite.getDateCreation());
                                               pst.setInt(7, pSite.getUtilisateur().getId());
                                               pst.setBoolean(8, false);
                                               return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException, TechnicalException {
        String vSQL_delete = "DELETE FROM t_site WHERE site_id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Site pSite) throws FunctionalException {
        String vSQL_update = "UPDATE t_site SET site_nom = ?, site_region = ?, site_description = ?, site_lastUpdate = ?, site_image = ?," +
                " site_dateCreation = ?, site_utilisateur_fk_id = ?, site_publication = ? WHERE site_id = ?";
        this.vJdbcTemplate.update(vSQL_update, pSite.getNom(), pSite.getRegion(),pSite.getDescription(),pSite.getLastUpdate(),
                pSite.getImage(),pSite.getDateCreation(),pSite.getUtilisateur().getId(),pSite.isPublication(),pSite.getId());
    }

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
        UtilisateurDao utilisateurDao = new UtilisateurDaoImpl();
        Utilisateur utilisateur = new Utilisateur();
        try {
            System.out.println("id du utilisateur " + rs.getInt("utilisateur_fk_id"));
            utilisateur = daoFactory.getUtilisateurDao().findById(rs.getInt("utilisateur_fk_id"));
            System.out.println("nom du utilisateur " + utilisateur.getNom());

        } catch (NotFoundException e) {
            System.out.println("Utilisateur non trouvé");
        }
        site.setUtilisateur(utilisateur);
        System.out.println("nom du utilisateur " + site.getUtilisateur().getNom());
        site.setPublication(rs.getBoolean("publication"));
        return site;
    }
}


