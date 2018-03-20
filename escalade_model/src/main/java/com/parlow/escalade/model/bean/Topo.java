package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.utilisateur.Utilisateur;

import java.util.List;

public class Topo {

    // ==================== Attributs ====================
    private Integer id;
    private String nom;
    private Region region;
    private Integer nbSites;
    private Integer nbSecteurs;
    private Integer nbVoies;
    private boolean disponible;
    private String presentation;
    private Image image;
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

    public Integer getNbSites() {
        return nbSites;
    }

    public void setNbSites(Integer nbSites) {
        this.nbSites = nbSites;
    }

    public Integer getNbSecteurs() {
        return nbSecteurs;
    }

    public void setNbSecteurs(Integer nbSecteurs) {
        this.nbSecteurs = nbSecteurs;
    }

    public Integer getNbVoies() {
        return nbVoies;
    }

    public void setNbVoies(Integer nbVoies) {
        this.nbVoies = nbVoies;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
        this.region = region;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public List<Commentaire> getCommentaires() {
        return commentaires;
    }

    public void setCommentaires(List<Commentaire> commentaires) {
        this.commentaires = commentaires;
    }

    // ==================== Méthodes =====================
}
