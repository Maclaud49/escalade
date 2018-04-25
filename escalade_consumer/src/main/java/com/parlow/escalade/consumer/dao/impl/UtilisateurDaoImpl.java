package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.consumer.dao.contract.UtilisateurDao;
import com.parlow.escalade.consumer.dao.contract.rowMapper.UtilisateurMapper;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Inject;
import javax.inject.Named;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Named
public class UtilisateurDaoImpl extends AbstractDaoImpl  implements UtilisateurDao {
    @Inject
    protected DaoFactory daoFactory;


    @Override
    public Utilisateur findByEmail(String email) throws NotFoundException {

        String sql_findByEmail = "SELECT * FROM t_utilisateur WHERE utilisateur_email = ?";

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

            String sql_findByEmailAndPass = "SELECT * FROM t_utilisateur WHERE utilisateur_email = ? AND utilisateur_password = ?";
            System.out.println("email " + email + " password " + password);
            try {
                Utilisateur user = this.vJdbcTemplate.queryForObject(
                        sql_findByEmailAndPass, new Object[]{email, password}, new UtilisateurMapper());
                return user;
            }catch(Exception e){
                System.out.println("Utilisateur non trouvé");
                throw new NotFoundException("Aucun utilisateur correspondant au couple email/mot de passe fourni.");
            }
    }

    @Override
    public Utilisateur findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_utilisateur WHERE utilisateur_id = ?";

        Utilisateur utilisateur = this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new UtilisateurMapper());
        return utilisateur;
    }

    @Override
    public List<Utilisateur> findAll() {
        String vSQL_findAll = "SELECT * FROM t_utilisateur ORDER BY utilisateur_nom DESC";
        List<Utilisateur> utilisateurs  = this.vJdbcTemplate.query(vSQL_findAll, new UtilisateurMapper());
        return utilisateurs;
    }


    @Override
    public int insert(Utilisateur pUtilisateur) throws FunctionalException {
        String vSQL_insert = "INSERT into t_utilisateur (utilisateur_nom, utilisateur_prenom, utilisateur_email, utilisateur_password, utilisateur_profil) VALUES(?,?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"utilisateur_id"});
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
        String vSQL_delete = "DELETE FROM t_utilisateur WHERE utilisateur_id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Utilisateur pUtilisateur) throws FunctionalException {
        String vSQL_update = "UPDATE t_utilisateur SET utilisateur_nom = ?, utilisateur_prenom = ?, utilisateur_dateNaissance = ?, utilisateur_email = ?," +
                " utilisateur_password = ?, utilisateur_cotation = ?,  utilisateur_profil = ?, adresse_adresse1 = ?,adresse_adresse2 = ?,adresse_codePostal = ?,adresse_ville = ?,adresse_pays = ? WHERE utilisateur_id = ?";
        this.vJdbcTemplate.update(vSQL_update, pUtilisateur.getNom(), pUtilisateur.getPrenom(),
                pUtilisateur.getDateNaissance(), pUtilisateur.getEmail(), pUtilisateur.getPassword(),
                pUtilisateur.getCotation(),
                pUtilisateur.getProfil(),pUtilisateur.getAdresse1(),pUtilisateur.getAdresse2(),pUtilisateur.getCodePostal(),
                pUtilisateur.getVille(),pUtilisateur.getPays(), pUtilisateur.getId());
    }


}
