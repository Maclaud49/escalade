package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.listes.Cotation;

import java.util.List;

public class Voie {

    // ==================== Attributs ====================
    private Integer id;
    private String nom;
    private List<Longueur> longueurs;
    private Integer nbLongueurs;
    private double hauteurVoie;
    private List<Cotation> cotation;
    private Integer nbPoints;
    private boolean equipee;
    private Secteur secteur;
    private Integer interet;


    // ==================== Méthodes =====================
}
