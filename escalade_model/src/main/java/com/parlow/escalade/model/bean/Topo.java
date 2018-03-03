package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.listes.Region;

import java.util.List;

public class Topo {

    // ==================== Attributs ====================
    private Integer id;
    private String nom;
    private List<Region> regions;
    private List<Site> sites;
    private Integer nbSites;
    private Integer nbSecteurs;
    private Integer nbVoies;
    private boolean disponible;
    private String presentation;
    private List<Image> images;

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

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
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

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }




    // ==================== Méthodes =====================
}
