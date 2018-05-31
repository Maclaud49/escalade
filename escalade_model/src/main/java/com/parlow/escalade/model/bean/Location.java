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
    private int topoProprio;
    private int topoLoueur;
    private Topo topo;
    private String status; //{Demande,Acceptation,Refus,Clos}



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

    public Topo getTopo() {
        return topo;
    }

    public void setTopo(Topo topo) {
        this.topo = topo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getTopoProprio() {
        return topoProprio;
    }

    public void setTopoProprio(int topoProprio) {
        this.topoProprio = topoProprio;
    }

    public int getTopoLoueur() {
        return topoLoueur;
    }

    public void setTopoLoueur(int topoLoueur) {
        this.topoLoueur = topoLoueur;
    }

    // ==================== Méthodes =====================

}
