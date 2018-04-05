package com.parlow.escalade.business.manager.contract;

import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;

import java.util.List;

public interface SiteManager {

    /**
     * Renvoie la le {@link Site} demandé
     * @param pId du {@link Site}
     * @return {@link Site}
     * @throws NotFoundException si non trouvé
     * @throws TechnicalException si problème avec la base de données
     * @throws FunctionalException si id est null
     */
    Site findById( int pId )throws NotFoundException, TechnicalException, FunctionalException;

    /**
     * Renvoie la liste des {@link Site}
     *
     * @return List
     */
    List<Site> findAll();

    /**
     * Insert l'{@link Site} dans la bdd
     * @param pSite le {@link Site}
     * @return Le {@link Site}
     * @throws FunctionalException si le site est null
     * @throws TechnicalException si problème avec la base de données
     */
    int insert( Site pSite )throws FunctionalException, TechnicalException;

    /**
     * Supprime un {@link Site}
     * @param pId du {@link Site}
     * @throws NotFoundException si non trouvé
     * @throws TechnicalException si problème avec la base de données
     * @return boolean
     */
    void delete( int pId )throws NotFoundException, TechnicalException;

    /**
     * Met à jour l'{@link Site} dans la bdd
     * @param pSite le {@link Site}
     * @return boolean
     * @throws FunctionalException si le site est null
     */
    void update ( Site pSite ) throws FunctionalException;
}
