package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.utilisateur.Utilisateur;

import java.sql.Timestamp;
import java.util.List;

public class Voie {

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

    private List<Longueur> longueurs;
    private Integer nbLongueurs;
    private double hauteurVoie;
    private String cotation;
    private Integer nbPoints;
    private boolean equipee;



    // ==================== Getters/Setters ==============


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Longueur> getLongueurs() {
        return longueurs;
    }

    public void setLongueurs(List<Longueur> longueurs) {
        this.longueurs = longueurs;
    }

    public Integer getNbLongueurs() {
        return nbLongueurs;
    }

    public void setNbLongueurs(Integer nbLongueurs) {
        this.nbLongueurs = nbLongueurs;
    }

    public double getHauteurVoie() {
        return hauteurVoie;
    }

    public void setHauteurVoie(double hauteurVoie) {
        this.hauteurVoie = hauteurVoie;
    }

    public Integer getNbPoints() {
        return nbPoints;
    }

    public void setNbPoints(Integer nbPoints) {
        this.nbPoints = nbPoints;
    }

    public boolean isEquipee() {
        return equipee;
    }

    public void setEquipee(boolean equipee) {
        this.equipee = equipee;
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

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPublication(boolean publication) {
        this.publication = publication;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPublication() {
        return publication;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
