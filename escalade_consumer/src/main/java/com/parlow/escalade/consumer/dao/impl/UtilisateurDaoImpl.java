package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.UtilisateurDao;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import javax.inject.Inject;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Named
public class UtilisateurDaoImpl  implements UtilisateurDao {

    private static final String SQL_SELECT        = "SELECT * FROM T_user ORDER BY id";
    private static final String SQL_SELECT_PAR_NOM = "SELECT * FROM T_user WHERE nom = ?";
    private static final String SQL_INSERT        = "INSERT INTO T_user (email, password, profil) VALUES (?, ?, ?)";
    private static final String SQL_DELETE_PAR_ID = "DELETE FROM T_user WHERE id = ?";

    private DataSource dataSource;

    private JdbcTemplate vJdbcTemplate ;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.vJdbcTemplate = new JdbcTemplate(dataSource);
    }



    @Override
    public void insert(Utilisateur utilisateur) {
    }

    @Override
    public Utilisateur findById(int id) {
        String vSQL_findById = "SELECT * FROM T_user WHERE id = ?";

        //return this.vJdbcTemplate.queryForObject(vSQL,new Object[] { id },new UtilisateurRM() );

        Utilisateur user = (Utilisateur) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{id},
                new BeanPropertyRowMapper(Utilisateur.class));

        return user;
    }

    @Override
    public Utilisateur findByEmail(String email, String password) throws NotFoundException {

            String sql_findByEmail = "SELECT * FROM T_user WHERE email = ? AND password = ?";

            try {
                Utilisateur user = (Utilisateur) this.vJdbcTemplate.queryForObject(
                        sql_findByEmail, new Object[]{email, password}, new BeanPropertyRowMapper(Utilisateur.class));
                return user;
            }catch(Exception e){
                throw new NotFoundException("Aucun utilisateur correspondant au couple email/mot de passe fourni.");
            }


    }


    @Override
    public List<Utilisateur> findAll(){
        String vSQL_findAll = "SELECT * FROM T_user";

        List<Utilisateur> users  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Utilisateur.class));

        return users;
    }

    @Override
    public void delete(int utilisateurid) {

    }





    private static final class UtilisateurRM implements RowMapper<Utilisateur> {
        public Utilisateur mapRow(ResultSet rs, int rowNum) throws SQLException {
            Utilisateur user = new Utilisateur();
            user.setId(rs.getInt("id"));
            user.setNom(rs.getString("nom"));
            user.setEmail(rs.getString("email"));
            user.setPassword(rs.getString("password"));
            user.setPrenom(rs.getString("prenom"));
            user.setProfil(rs.getInt("profil"));

            return user;
        }
    }
}
