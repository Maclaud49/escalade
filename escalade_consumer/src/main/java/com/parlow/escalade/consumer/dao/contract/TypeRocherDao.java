package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.TypeRocher;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface TypeRocherDao {

    /**
     * Renvoie la le {@link TypeRocher} demandé
     * @param pId du {@link TypeRocher}
     * @return {@link TypeRocher}
     * @throws NotFoundException si non trouvé
     */
    TypeRocher findById(int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link TypeRocher}
     *
     * @return List
     */
    List<TypeRocher> findAll();

    /**
     * Insert l'{@link TypeRocher} dans la bdd
     * @param pTypeRocher le {@link TypeRocher}
     * @return Le {@link TypeRocher}
     * @throws FunctionalException si le typeRocher est null
     */
    int insert( TypeRocher pTypeRocher )throws FunctionalException;

    /**
     * Supprime un {@link TypeRocher}
     * @param pId du {@link TypeRocher}
     * @throws NotFoundException si non trouvé
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link TypeRocher} dans la bdd
     * @param pTypeRocher le {@link TypeRocher}
     * @return boolean
     * @throws FunctionalException si le typeRocher est null
     */
    void update ( TypeRocher pTypeRocher ) throws FunctionalException;
}
