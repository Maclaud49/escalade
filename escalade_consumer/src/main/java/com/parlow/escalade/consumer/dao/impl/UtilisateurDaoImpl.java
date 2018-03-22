package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.consumer.dao.contract.UtilisateurDao;
import com.parlow.escalade.consumer.dao.contract.rowMapper.UtilisateurMapper;
import com.parlow.escalade.model.bean.Adresse;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl  implements UtilisateurDao {
    @Inject
    protected DaoFactory daoFactory;


    @Override
    public Utilisateur findByEmail(String email) throws NotFoundException {

        String sql_findByEmail = "SELECT * FROM t_utilisateur WHERE email = ?";

        try {
            Utilisateur user = this.vJdbcTemplate.queryForObject(
                    sql_findByEmail, new Object[]{email}, new UtilisateurMapper());
            return user;
        }catch(Exception e){
            throw new NotFoundException("Aucun utilisateur correspondant à cette adresse email fourni.");
        }
    }

    @Override
    public Utilisateur findByEmailAndPassword(String email, String password) throws NotFoundException {

            String sql_findByEmailAndPass = "SELECT * FROM t_utilisateur WHERE email = ? AND password = ?";

            try {
                Utilisateur user = this.vJdbcTemplate.queryForObject(
                        sql_findByEmailAndPass, new Object[]{email, password}, new UtilisateurMapper());
                return user;
            }catch(Exception e){
                throw new NotFoundException("Aucun utilisateur correspondant au couple email/mot de passe fourni.");
            }
    }

    @Override
    public Utilisateur findById(int pId) throws NotFoundException {
        System.out.println("utilisateur findById");
        String vSQL_findById = "SELECT * FROM t_utilisateur,t_adresse WHERE utilisateur_id = ? AND utilisateur_adresse_fk_id=adresse_id";

        Utilisateur utilisateur = this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new UtilisateurMapper());
        return utilisateur;
    }

    @Override
    public List<Utilisateur> findAll() {
        String vSQL_findAll = "SELECT * FROM t_utilisateur";
        List<Utilisateur> utilisateurs  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Utilisateur.class));
        return utilisateurs;
    }

    @Override
    public int insert(Utilisateur pUtilisateur) throws FunctionalException {
        String vSQL_insert = "INSERT into t_utilisateur (nom, prenom, email, password, profil) VALUES(?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"id"});
                                           pst.setString(1, pUtilisateur.getNom());
                                           pst.setString(2,pUtilisateur.getPrenom());
                                           pst.setString(3,pUtilisateur.getEmail());
                                           pst.setString(4, pUtilisateur.getPassword());
                                           pst.setString(5, pUtilisateur.getProfil());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_utilisateur WHERE id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Utilisateur pUtilisateur) throws FunctionalException {
        String vSQL_update = "UPDATE t_utilisateur SET nom = ?, prenom = ?, dateNaissance = ?, email = ?," +
                " password = ?, cotation = ?, adresse_fk_id = ?, profil = ? WHERE id = ?";
        this.vJdbcTemplate.update(vSQL_update, pUtilisateur.getNom(), pUtilisateur.getPrenom(),
                pUtilisateur.getDateNaissance(), pUtilisateur.getEmail(), pUtilisateur.getPassword(),
                pUtilisateur.getCotation(), pUtilisateur.getAdresse().getId(),
                pUtilisateur.getProfil(), pUtilisateur.getId());
    }

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
        Adresse adresse = new Adresse();
        try {
            System.out.println("adresse id " + rs.getInt("adresse_fk_id"));
            adresse = daoFactory.getAdresseDao().findById(rs.getInt("adresse_fk_id"));
        } catch (Exception e) {
            System.out.println("Adresse non trouvée");
        }
        utilisateur.setAdresse(adresse);
        utilisateur.setProfil(rs.getString("profil"));
        return utilisateur;
    }
}
