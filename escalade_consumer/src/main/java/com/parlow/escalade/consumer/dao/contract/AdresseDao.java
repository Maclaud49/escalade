package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.Adresse;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface AdresseDao {

    /**
     * Renvoie la le {@link Adresse} demandé
     * @param pId du {@link Adresse}
     * @return {@link Adresse}
     * @throws NotFoundException si non trouvé
     */
    Adresse findById( int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link Adresse}
     *
     * @return List
     */
    List<Adresse> findAll();

    /**
     * Insert l'{@link Adresse} dans la bdd
     * @param pAdresse le {@link Adresse}
     * @return Le {@link Adresse}
     * @throws FunctionalException si le adresse est null
     */
    int insert( Adresse pAdresse )throws FunctionalException;

    /**
     * Supprime un {@link Adresse}
     * @param pId du {@link Adresse}
     * @throws NotFoundException si non trouvé
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Adresse} dans la bdd
     * @param pAdresse le {@link Adresse}
     * @return boolean
     * @throws FunctionalException si le adresse est null
     */
    void update ( Adresse pAdresse ) throws FunctionalException;
}
