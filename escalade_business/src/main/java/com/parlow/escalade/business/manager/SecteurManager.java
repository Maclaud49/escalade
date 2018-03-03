package com.parlow.escalade.business.manager;

import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.recherche.secteur.RechercheSecteur;

import java.util.List;

public interface SecteurManager {
    Secteur getSecteur(int id) throws NotFoundException;

    List<Secteur> getListSecteur(RechercheSecteur pRechercheSecteur);
}
