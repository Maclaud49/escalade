package com.parlow.escalade.model.bean;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Objet métier représentant une cotation
 *
 * @author Mickaël Parlow
 */
public class Cotation {

    // ==================== Attributs ====================
    private Integer id;
    private String cotation;
    private Integer niveau;



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

    public Integer getNiveau() {
        return niveau;
    }

    public void setNiveau(Integer niveau) {
        this.niveau = niveau;
    }

    // ==================== Méthodes =====================

}
