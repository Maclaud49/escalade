package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.UtilisateurDao;
import com.parlow.escalade.consumer.dao.contract.rowMapper.UtilisateurMapper;
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

            String sql_findByEmail = "SELECT * FROM t_utilisateur WHERE email = ? AND password = ?";

            try {
                Utilisateur user = (Utilisateur) this.vJdbcTemplate.queryForObject(
                        sql_findByEmail, new Object[]{email, password}, new BeanPropertyRowMapper(Utilisateur.class));
                return user;
            }catch(Exception e){
                throw new NotFoundException("Aucun utilisateur correspondant au couple email/mot de passe fourni.");
            }
    }

    @Override
    public Utilisateur findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_utilisateur WHERE id = ?";
        Utilisateur utilisateur = (Utilisateur) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Utilisateur.class));
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
}
