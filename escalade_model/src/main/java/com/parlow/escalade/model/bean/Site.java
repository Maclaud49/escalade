package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.listes.PeriodeFav;
import com.parlow.escalade.model.bean.listes.Region;
import com.parlow.escalade.model.bean.listes.TypeRocher;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.sun.istack.internal.NotNull;
import org.joda.time.DateTime;

import javax.validation.constraints.Size;
import java.util.List;

public class Site {

    // ==================== Attributs ====================
    private Integer id;
    @NotNull
    @Size(min = 1, max = 100)
    private String nom;
    private String presentation;
    private List<Secteur> secteurs;
    private List<Region> region;
    private List<PeriodeFav> periodeFav;
    private List<TypeRocher> typeRocher;
    private Integer nbSecteurs;
    private Integer nbVoies;
    private DateTime dateCreation;
    private DateTime lastUpdate;
    private String niveauPratique;
    private List<Image> images;
    private Utilisateur utilisateur;
    private boolean publication;

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

    public String getPresentation() {
        return presentation;
    }

    public void setPresentation(String presentation) {
        this.presentation = presentation;
    }

    public List<Secteur> getSecteurs() {
        return secteurs;
    }

    public void setSecteurs(List<Secteur> secteurs) {
        this.secteurs = secteurs;
    }

    public List<Region> getRegion() {
        return region;
    }

    public void setRegion(List<Region> region) {
        this.region = region;
    }

    public List<PeriodeFav> getPeriodeFav() {
        return periodeFav;
    }

    public void setPeriodeFav(List<PeriodeFav> periodeFav) {
        this.periodeFav = periodeFav;
    }

    public List<TypeRocher> getTypeRocher() {
        return typeRocher;
    }

    public void setTypeRocher(List<TypeRocher> typeRocher) {
        this.typeRocher = typeRocher;
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

    public DateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(DateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public String getNiveauPratique() {
        return niveauPratique;
    }

    public void setNiveauPratique(String niveauPratique) {
        this.niveauPratique = niveauPratique;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public DateTime getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(DateTime dateCreation) {
        this.dateCreation = dateCreation;
    }

    public boolean isPublication() {
        return publication;
    }

    public void setPublication(boolean publication) {
        this.publication = publication;
    }


    // ==================== Méthodes =====================
}
