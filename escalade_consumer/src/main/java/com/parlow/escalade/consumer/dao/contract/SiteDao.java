package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;

import java.util.List;

public interface SiteDao {

    /**
     * Renvoie le {@link Site} demandé
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
     * @return Le id généré du {@link Site}
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

    /**
     * Renvoie la liste des résultats de la recherche
     * @param keyWord
     * @return List
     */
    List<Site> searchResult(String keyWord);
}
