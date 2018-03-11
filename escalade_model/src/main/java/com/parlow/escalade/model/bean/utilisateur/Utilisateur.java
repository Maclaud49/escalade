package com.parlow.escalade.model.bean.utilisateur;

import com.parlow.escalade.model.bean.listes.Cotation;
import com.parlow.escalade.model.bean.Image;
import com.parlow.escalade.model.bean.Topo;
import org.joda.time.DateTime;
import java.util.List;

public class Utilisateur {

    // ==================== Attributs ====================
    private Integer id;
    private String nom;
    private String prenom;
    private Cotation cotation;
    private DateTime dateNaissance;
    private List<Topo> topos;
    private Image profiImage;
    private String email;

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

    public Cotation getCotation() {
        return cotation;
    }

    public void setCotation(Cotation cotation) {
        this.cotation = cotation;
    }

    public DateTime getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(DateTime dateNaissance) {
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


    // ==================== Méthodes =====================

    /**
     * Constructeur.
     *
     * @param pNom -
     */
    public Utilisateur(String pNom) {
        nom = pNom;
    }

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
