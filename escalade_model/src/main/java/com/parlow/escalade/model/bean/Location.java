package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.Topo;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.joda.time.DateTime;

import java.sql.Timestamp;

public class Location {

    // ==================== Attributs ====================
    private Integer id;
    private Timestamp dateDebut;
    private Timestamp dateFin;
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

    public Timestamp getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Timestamp dateDebut) {
        this.dateDebut = dateDebut;
    }

    public Timestamp getDateFin() {
        return dateFin;
    }

    public void setDateFin(Timestamp dateFin) {
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
