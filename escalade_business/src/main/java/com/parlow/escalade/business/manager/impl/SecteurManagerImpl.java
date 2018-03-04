package com.parlow.escalade.business.manager.impl;


import java.util.ArrayList;
import java.util.List;

import com.parlow.escalade.business.manager.contract.SecteurManager;
import com.parlow.escalade.consummer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.recherche.secteur.RechercheSecteur;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * Manager des beans du package Secteur.
 *
 * @author Parlow
 */
@Named
public class SecteurManagerImpl implements SecteurManager {

    @Inject
    private DaoFactory daoFactory;

    /**
     * Cherche et renvoie le {@link Secteur} numéro {@code id}
     *
     * @param id le numéro du Secteur
     * @return Le {@link Secteur}
     * @throws NotFoundException Si le Secteur n'est pas trouvé
     */
    @Override
    public Secteur getSecteur(int id) throws NotFoundException {
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        if (id < 1L) {
            throw new NotFoundException("Secteur non trouvé : numero=" + id);
        }

        return new Secteur();
    }


    /**
     * Renvoie la liste des {@link Secteur} correspondants aux critères de recherche.
     *
     * @param pRechercheSecteur -
     * @return List
     */
    @Override
    public List<Secteur> getListSecteur(RechercheSecteur pRechercheSecteur) {
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        List<Secteur> vList = new ArrayList<>();
        if (pRechercheSecteur.getSiteId() != null) {
            Site vSite = new Site(pRechercheSecteur.getSiteId());
            for (int vI = 0; vI < 4; vI++) {
                Secteur vSecteur = new Secteur(vI);
                vSecteur.setSite(vSite);
                vList.add(vSecteur);
            }
        } else {
            for (int vI = 0; vI < 9; vI++) {
                Secteur vSecteur = new Secteur(vI);
                vList.add(vSecteur);
            }
        }
        return vList;
    }


    /**
     * Renvoie le nombre de {@link Secteur} correspondants aux critères de recherche.
     *
     * @param pRechercheSecteur -
     * @return int
     */
    public int getCountSecteur(RechercheSecteur pRechercheSecteur) {
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        return 42;
    }
}
