package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.joda.time.DateTime;

import java.sql.Timestamp;

public class Commentaire {
    // ==================== Attributs ====================
    private Integer id;
    private Timestamp dateCreation;
    private String commentaire;
    private Utilisateur utilisateur;
    private Integer reference_id;
    private String target_table;


    // ==================== Getters/Setters ==============
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public Integer getReference_id() {
        return reference_id;
    }

    public void setReference_id(Integer reference_id) {
        this.reference_id = reference_id;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public String getTarget_table() {
        return target_table;
    }

    public void setTarget_table(String target_table) {
        this.target_table = target_table;
    }

    // ==================== Méthodes =====================

}
