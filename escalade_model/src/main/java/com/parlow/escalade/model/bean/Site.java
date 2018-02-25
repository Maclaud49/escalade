package com.parlow.escalade.model.bean;

import com.parlow.escalade.model.bean.listes.PeriodeFav;
import com.parlow.escalade.model.bean.listes.Region;
import com.parlow.escalade.model.bean.listes.TypeRocher;
import org.joda.time.DateTime;

import java.util.List;

public class Site {

    // ==================== Attributs ====================
    private Integer id;
    private String nom;
    private String presentation;
    private List<Secteur> secteurs;
    private List<Region> region;
    private List<PeriodeFav> periodeFav;
    private List<TypeRocher> typeRocher;
    private Integer nbSecteurs;
    private Integer nbVoies;
    private DateTime lastUpdate;
    private String niveauPratique;
    private List<Image> images;



    // ==================== Constructeurs ================

    // ==================== Getters/Setters ==============

    // ==================== Méthodes =====================
}
