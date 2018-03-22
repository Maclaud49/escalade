package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.consumer.dao.contract.UtilisateurDao;
import com.parlow.escalade.consumer.dao.impl.AdresseDaoImpl;
import com.parlow.escalade.consumer.dao.impl.UtilisateurDaoImpl;
import com.parlow.escalade.model.bean.Adresse;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.ResultSet;
import java.sql.SQLException;

@Named
public class UtilisateurMapper implements RowMapper<Utilisateur> {
    @Inject
    protected DaoFactory daoFactory;

    public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
        System.out.println("Utilisateur mapRow");
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(rs.getInt("utilisateur_id"));
        utilisateur.setNom(rs.getString("utilisateur_nom"));
        utilisateur.setPrenom(rs.getString("utilisateur_prenom"));
        utilisateur.setDateNaissance(rs.getDate("utilisateur_dateNaissance"));
        utilisateur.setEmail(rs.getString("utilisateur_email"));
        utilisateur.setPassword(rs.getString("utilisateur_password"));
        utilisateur.setCotation(rs.getString("utilisateur_cotation"));
        utilisateur.setProfil(rs.getString("utilisateur_profil"));
        AdresseMapper adresseMapper = new AdresseMapper();
        Adresse adresse = adresseMapper.mapRow(rs,rowNum);
        utilisateur.setAdresse(adresse);

        return utilisateur;
    }
}

        /*Adresse adresse = new Adresse();
        try {
            System.out.println("adresse id " + rs.getInt("adresse_fk_id"));
            adresse = daoFactory.getAdresseDao().findById(rs.getInt("adresse_fk_id"));
        } catch (Exception e) {
            System.out.println("Adresse non trouvée");
        }
        utilisateur.setAdresse(adresse);*/
