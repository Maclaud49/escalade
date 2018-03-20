package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.utilisateur.Utilisateur;

import java.util.List;

public class Voie {

    // ==================== Attributs ====================
    private Integer id;
    private String nom;
    private List<Longueur> longueurs;
    private Integer nbLongueurs;
    private double hauteurVoie;
    private Cotation cotation;
    private Integer nbPoints;
    private boolean equipee;
    private Secteur secteur;
    private Integer interet;
    private Utilisateur utilisateur;
    private List<Commentaire> commentaires;


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

    public Secteur getSecteur() {
        return secteur;
    }

    public void setSecteur(Secteur secteur) {
        this.secteur = secteur;
    }

    public Integer getInteret() {
        return interet;
    }

    public void setInteret(Integer interet) {
        this.interet = interet;
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

    public Cotation getCotation() {
        return cotation;
    }

    public void setCotation(Cotation cotation) {
        this.cotation = cotation;
    }
}
