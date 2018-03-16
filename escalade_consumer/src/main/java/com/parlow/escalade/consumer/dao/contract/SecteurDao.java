package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.recherche.secteur.RechercheSecteur;

import java.util.List;

public interface SecteurDao {

    int getCountSecteur(RechercheSecteur pRechercheSecteur);

    void insert(Secteur secteur)  ;

    Secteur findById(int id)  ;

    List<Secteur> findAll()  ;

    void delete(int secteurid)  ;
}
