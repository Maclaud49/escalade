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

    // ==================== Constructeurs ================

    // ==================== Getters/Setters ==============

    // ==================== Méthodes =====================
}
