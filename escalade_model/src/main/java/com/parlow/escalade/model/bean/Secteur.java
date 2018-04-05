package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.deleted.Image;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;

import java.sql.Timestamp;
import java.util.List;

public class Secteur {

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

    private List<Voie> voies;
    private Integer nbVoies;
    private String departement;

    // ==================== Constructeurs ==============

    /**
     * Constructeur par défaut.
     */
    public Secteur() {
    }


    /**
     * Constructeur.
     *
     * @param pid-
     */
    public Secteur(int pid) {
        id = pid;
    }

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

    public List<Voie> getVoies() {
        return voies;
    }

    public void setVoies(List<Voie> voies) {
        this.voies = voies;
    }

    public Integer getNbVoies() {
        return nbVoies;
    }

    public void setNbVoies(Integer nbVoies) {
        this.nbVoies = nbVoies;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String images) {
        this.image = image;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public boolean isPublication() {
        return publication;
    }

    public void setPublication(boolean publication) {
        this.publication = publication;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    // ==================== Méthodes =====================
}
