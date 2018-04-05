package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.CommentaireDao;
import com.parlow.escalade.model.bean.Commentaire;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.inject.Named;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Named
public class CommentaireDaoImpl extends AbstractDaoImpl implements CommentaireDao {

    @Override
    public Commentaire findById(int pId) throws NotFoundException {
        String vSQL_findById = "SELECT * FROM t_commentaire WHERE com_id = ?";
        Commentaire commentaire = (Commentaire) this.vJdbcTemplate.queryForObject(vSQL_findById, new Object[]{pId},
                new BeanPropertyRowMapper(Commentaire.class));
        return commentaire;
    }

    @Override
    public List<Commentaire> findAll() {
        String vSQL_findAll = "SELECT * FROM t_commentaire";
        List<Commentaire> commentaires  = this.vJdbcTemplate.query(vSQL_findAll, new BeanPropertyRowMapper(Commentaire.class));
        return commentaires;
    }

    @Override
    public int insert(Commentaire pCommentaire) throws FunctionalException {
        String vSQL_insert = "INSERT into t_commentaire (com_commentaire) VALUES(?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();

        this.vJdbcTemplate.update( new PreparedStatementCreator() {
                                       public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
                                           PreparedStatement pst = con.prepareStatement(vSQL_insert, new String[] {"com_id"});
                                           pst.setString(1, pCommentaire.getCommentaire());
                                           return pst;
                                       }
                                   },
                keyHolder);
        int key = (Integer)keyHolder.getKey();
        return key;
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        String vSQL_delete = "DELETE FROM t_commentaire WHERE com_id=?";
        this.vJdbcTemplate.update(vSQL_delete, pId);
    }

    @Override
    public void update(Commentaire pCommentaire) throws FunctionalException {
        String vSQL_update = "UPDATE t_commentaire SET com_commentaire = ?, com_dateCommentaire = ?, com_utilisateur_fk_id = ?, com_table_fk_id = ?, com_target_table = ? WHERE com_id = ?";
        this.vJdbcTemplate.update(vSQL_update, pCommentaire.getCommentaire(),pCommentaire.getDateCreation(),
                pCommentaire.getUtilisateur().getId(),pCommentaire.getReference_id(),pCommentaire.getTable(),pCommentaire.getId());
    }
}
