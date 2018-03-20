package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface SiteDao {

    /**
     * Renvoie la le {@link Site} demandé
     * @param pId du {@link Site}
     * @return {@link Site}
     * @throws NotFoundException si non trouvé
     */
    Site findById( int pId )throws NotFoundException;

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
     */
    int insert( Site pSite )throws FunctionalException;

    /**
     * Supprime un {@link Site}
     * @param pId du {@link Site}
     * @throws NotFoundException si non trouvé
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Site} dans la bdd
     * @param pSite le {@link Site}
     * @return boolean
     * @throws FunctionalException si le site est null
     */
    void update ( Site pSite ) throws FunctionalException;
}
