package com.parlow.escalade.model.bean.utilisateur;

import com.parlow.escalade.model.bean.*;
import com.parlow.escalade.model.bean.deleted.Image;

import java.sql.Date;
import java.util.List;

public class Utilisateur {

    // ==================== Attributs ====================
    private Integer id;
    private String nom;
    private String prenom;
    private String cotation;
    private Date dateNaissance;
    private List<Topo> topos;
    private Image profiImage;
    private String email;
    private String password;
    private String profil;
    private Adresse adresse;

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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public List<Topo> getTopos() {
        return topos;
    }

    public void setTopos(List<Topo> topos) {
        this.topos = topos;
    }

    public Image getProfiImage() {
        return profiImage;
    }

    public void setProfiImage(Image profiImage) {
        this.profiImage = profiImage;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getProfil() {
        return profil;
    }

    public void setProfil(String profil) {
        this.profil = profil;
    }

    public Adresse getAdresse() {
        return adresse;
    }

    public void setAdresse(Adresse adresse) {
        this.adresse = adresse;
    }

    // ==================== Méthodes =====================

    /**
     * Constructeur.
     *
     *
     */
    public Utilisateur() { }

    @Override
    public String toString() {
        final StringBuilder vStB = new StringBuilder(this.getClass().getSimpleName());
        final String vSEP = ", ";
        vStB.append(" {")
                .append("id=").append(id)
                .append(vSEP).append("nom=\"").append(nom).append('"')
                .append(vSEP).append("prenom=\"").append(prenom).append('"')
                .append("}");
        return vStB.toString();
    }
}
