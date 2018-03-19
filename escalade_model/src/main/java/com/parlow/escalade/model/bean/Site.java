package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.listes.PeriodeFav;
import com.parlow.escalade.model.bean.listes.Region;
import com.parlow.escalade.model.bean.listes.TypeRocher;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

public class Site {

    // ==================== Attributs ====================
    private Integer id;
    //@NotNull(message="Le champ ne doit pas être vide")
    //@Size(min = 3, max = 100, message="Le nom doit être supérieur à 3 lettres")
    private String nom;
    private String description;
    private List<Secteur> secteurs;
    private Region region;
    private List<PeriodeFav> periodeFav;
    private List<TypeRocher> typeRocher;
    private Integer nbSecteurs;
    private Integer nbVoies;
    private Timestamp dateCreation;
    private Timestamp lastUpdate;
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

    public Region getRegion() {
        return region;
    }

    public void setRegion(Region region) {
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

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
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


    // ==================== Méthodes =====================
}
