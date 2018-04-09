package com.parlow.escalade.consumer.dao.contract.rowMapper;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Commentaire;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.jdbc.core.RowMapper;

import javax.inject.Inject;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CommentaireMapper implements RowMapper<Commentaire> {

    private static final Logger logger = LogManager.getLogger(CommentaireMapper.class);

    public Commentaire mapRow(ResultSet rs, int rowNum) throws SQLException {
        Commentaire commentaire = new Commentaire();
        commentaire.setId(rs.getInt("com_id"));
        commentaire.setCommentaire(rs.getString("com_commentaire"));
        commentaire.setDateCreation(rs.getTimestamp("com_dateCreation"));
        commentaire.setTarget_table(rs.getString("com_target_table"));
        commentaire.setReference_id(rs.getInt("com_table_fk_id"));

        UtilisateurMapper utilisateurMapper = new UtilisateurMapper();
        Utilisateur utilisateur = utilisateurMapper.mapRow(rs,rowNum);
        commentaire.setUtilisateur(utilisateur);

        return commentaire;
    }


}