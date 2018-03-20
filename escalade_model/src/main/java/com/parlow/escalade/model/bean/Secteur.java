package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.utilisateur.Utilisateur;

import java.util.List;

public class Secteur {

    // ==================== Attributs ====================
    private Integer id;
    private String nom;
    private List<Voie> voies;
    private Site site;
    private Integer nbVoies;
    private Image image;
    private Utilisateur utilisateur;
    private boolean publication;
    private List<Commentaire> commentaires;

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

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public Integer getNbVoies() {
        return nbVoies;
    }

    public void setNbVoies(Integer nbVoies) {
        this.nbVoies = nbVoies;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image images) {
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
    // ==================== Méthodes =====================
}
