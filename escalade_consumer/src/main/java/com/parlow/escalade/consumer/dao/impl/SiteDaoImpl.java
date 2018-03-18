package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.SiteDao;

import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.joda.time.DateTime;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteDaoImpl  implements SiteDao {

    private static final String SQL_SELECT        = "SELECT id, nom FROM t_site ORDER BY id";
    private static final String SQL_SELECT_PAR_ID = "SELECT id, nom FROM t_site WHERE id = ?";
    private static final String SQL_INSERT        = "INSERT INTO t_site (nom) VALUES (?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM t_site WHERE id = ?";
    private static final String SQL_LAST_ID       = "SELECT MAX(id) FROM t_site";

    @Override
    public void insert(Site site) {

    }

    @Override
    public Site findById(int id){
        Site vSite = new Site();
        vSite.setId(1);
        vSite.setNom("Site 1");
        vSite.setDescription("Un site tip top");
        vSite.setDateCreation(new DateTime());
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
