package com.parlow.escalade.model.bean;

import java.util.List;

public class Secteur {

    // ==================== Attributs ====================
    private Integer id;
    private String nom;
    private List<Voie> voies;
    private Site site;
    private Integer nbVoies;
    private List<Image> images;

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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }



    // ==================== Méthodes =====================
}
