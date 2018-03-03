package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.listes.Cotation;

public class Longueur {

    // ==================== Attributs ====================
    private Integer id;
    private double relai;
    private Voie voie;
    private Cotation cotation;

    // ==================== Getters/Setters ==============
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getRelai() {
        return relai;
    }

    public void setRelai(double relai) {
        this.relai = relai;
    }

    public Voie getVoie() {
        return voie;
    }

    public void setVoie(Voie voie) {
        this.voie = voie;
    }

    public Cotation getCotation() {
        return cotation;
    }

    public void setCotation(Cotation cotation) {
        this.cotation = cotation;
    }




    // ==================== Méthodes =====================
}
