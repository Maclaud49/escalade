package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.utilisateur.Utilisateur;

import java.sql.Timestamp;
import java.util.List;

public class Longueur {

    // ==================== Attributs ====================
    private Integer id;
    private String nom;
    private String description;
    private Utilisateur utilisateur;
    private List<Commentaire> commentaires;
    private Timestamp dateCreation;
    private Timestamp lastUpdate;
    private boolean publication;
    private String image;

    private double relai;
    private Voie voie;
    private String cotation;


    // ==================== Getters/Setters ==============
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getRelai() {
        return relai;
    }

    public void setRelai(double relai) {
        this.relai = relai;
    }

    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public boolean isPublication() {
        return publication;
    }

    public void setPublication(boolean publication) {
        this.publication = publication;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    // ==================== Méthodes =====================
}
