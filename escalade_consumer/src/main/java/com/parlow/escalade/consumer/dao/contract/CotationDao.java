package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.Cotation;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface CotationDao {

    /**
     * Renvoie la le {@link Cotation} demandé
     * @param pId du {@link Cotation}
     * @return {@link Cotation}
     * @throws NotFoundException si non trouvé
     */
    Cotation findById( int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link Cotation}
     *
     * @return List
     */
    List<Cotation> findAll();

    /**
     * Insert l'{@link Cotation} dans la bdd
     * @param pCotation le {@link Cotation}
     * @return Le {@link Cotation}
     * @throws FunctionalException si le cotation est null
     */
    int insert( Cotation pCotation )throws FunctionalException;

    /**
     * Supprime un {@link Cotation}
     * @param pId du {@link Cotation}
     * @throws NotFoundException si non trouvé
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Cotation} dans la bdd
     * @param pCotation le {@link Cotation}
     * @return boolean
     * @throws FunctionalException si le cotation est null
     */
    void update ( Cotation pCotation ) throws FunctionalException;
}
