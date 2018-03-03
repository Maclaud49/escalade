package com.parlow.escalade.model.bean.utilisateur;

import com.parlow.escalade.model.bean.Topo;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.joda.time.DateTime;

public class Location {

    // ==================== Attributs ====================
    private Integer id;
    private String cotation;
    private DateTime dateDebut;
    private DateTime dateFin;
    private Utilisateur topoProprio;
    private Utilisateur topoLoueur;
    private Topo topo;


    // ==================== Getters/Setters ==============
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCotation() {
        return cotation;
    }

    public void setCotation(String cotation) {
        this.cotation = cotation;
    }

    public DateTime getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(DateTime dateDebut) {
        this.dateDebut = dateDebut;
    }

    public DateTime getDateFin() {
        return dateFin;
    }

    public void setDateFin(DateTime dateFin) {
        this.dateFin = dateFin;
    }

    public Utilisateur getTopoProprio() {
        return topoProprio;
    }

    public void setTopoProprio(Utilisateur topoProprio) {
        this.topoProprio = topoProprio;
    }

    public Utilisateur getTopoLoueur() {
        return topoLoueur;
    }

    public void setTopoLoueur(Utilisateur topoLoueur) {
        this.topoLoueur = topoLoueur;
    }

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }


    // ==================== Méthodes =====================

}
