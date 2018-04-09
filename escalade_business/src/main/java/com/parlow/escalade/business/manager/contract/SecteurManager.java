package com.parlow.escalade.business.manager.contract;

import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;
import com.parlow.escalade.model.recherche.secteur.RechercheSecteur;

import java.util.List;

public interface SecteurManager {

    /**
     * Renvoie la le {@link Secteur} demandé
     * @param pId du {@link Secteur}
     * @return {@link Secteur}
     * @throws NotFoundException si non trouvé
     * @throws TechnicalException si problème avec la base de données
     * @throws FunctionalException si id est null
     */
    Secteur findById( int pId )throws NotFoundException, TechnicalException,FunctionalException;

    /**
     * Renvoie la liste des {@link Secteur}
     *
     * @return List
     */
    List<Secteur> findAll();

    /**
     * Insert l'{@link Secteur} dans la bdd
     * @param pSecteur le {@link Secteur}
     * @return Le {@link Secteur}
     * @throws FunctionalException si le secteur est null
     */
    int insert( Secteur pSecteur )throws FunctionalException, TechnicalException;

    /**
     * Supprime un {@link Secteur}
     * @param pId du {@link Secteur}
     * @throws NotFoundException si non trouvé               
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Secteur} dans la bdd
     * @param pSecteur le {@link Secteur}
     * @return boolean
     * @throws FunctionalException si le secteur est null
     */
    void update ( Secteur pSecteur ) throws FunctionalException;

    /**
     * Renvoie la liste des résultats de la recherche
     * @param keyWord
     * @return List
     */
    List<Secteur> searchResult(String keyWord);
}
