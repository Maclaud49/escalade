package com.parlow.escalade.model.bean.utilisateur;

import org.joda.time.DateTime;

public class Commentaires {
    // ==================== Attributs ====================
    private Integer id;
    private String cotation;
    private DateTime dateCommentaire;
    private Utilisateur commentateur;
    private Integer sectionId;
    private String sectionName;


    // ==================== Constructeurs ================
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    public DateTime getDateCommentaire() {
        return dateCommentaire;
    }

    public void setDateCommentaire(DateTime dateCommentaire) {
        this.dateCommentaire = dateCommentaire;
    }

    public Utilisateur getCommentateur() {
        return commentateur;
    }

    public void setCommentateur(Utilisateur commentateur) {
        this.commentateur = commentateur;
    }

    public Integer getSectionId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
    }


    // ==================== Méthodes =====================

}
