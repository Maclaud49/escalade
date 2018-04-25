package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.utilisateur.Utilisateur;


import java.sql.Timestamp;
import java.util.List;

public class Site {

    // ==================== Attributs ====================
    private Integer id;
    //@NotNull(message="Le champ ne doit pas être vide")
    //@Size(min = 3, max = 100, message="Le nom doit être supérieur à 3 lettres")
    private String nom;
    private String description;
    private Utilisateur utilisateur;
    private List<Commentaire> commentaires;
    private Timestamp dateCreation;
    private Timestamp lastUpdate;
    private boolean publication;
    private String image;

    private List<Secteur> secteurs;
    private String region;
    private Integer nbSecteurs;
    private Integer nbCommentaires;

    // ==================== Constructeurs ==============

    /**
     * Constructeur par défaut.
     */
    public Site() {
    }


    /**
     * Constructeur.
     *
     * @param pid-
     */
    public Site(int pid) {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public Integer getNbSecteurs() {
        return nbSecteurs;
    }

    public void setNbSecteurs(Integer nbSecteurs) {
        this.nbSecteurs = nbSecteurs;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Timestamp getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Timestamp dateCreation) {
        this.dateCreation = dateCreation;
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

    public Integer getNbCommentaires() {
        return nbCommentaires;
    }

    public void setNbCommentaires(Integer nbCommentaires) {
        this.nbCommentaires = nbCommentaires;
    }

    // ==================== Méthodes =====================
}
