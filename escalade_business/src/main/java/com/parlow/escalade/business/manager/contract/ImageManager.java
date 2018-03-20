package com.parlow.escalade.business.manager.contract;

import com.parlow.escalade.model.bean.Image;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface ImageManager {

    /**
     * Renvoie la le {@link Image} demandé
     * @param pId du {@link Image}
     * @return {@link Image}
     * @throws NotFoundException si non trouvé
     */
    Image findById(int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link Image}
     *
     * @return List
     */
    List<Image> findAll();

    /**
     * Insert l'{@link Image} dans la bdd
     * @param pImage le {@link Image}
     * @return Le {@link Image}
     * @throws FunctionalException si le image est null
     */
    int insert( Image pImage )throws FunctionalException;

    /**
     * Supprime un {@link Image}
     * @param pId du {@link Image}
     * @throws NotFoundException si non trouvé
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Image} dans la bdd
     * @param pImage le {@link Image}
     * @return boolean
     * @throws FunctionalException si le image est null
     */
    void update ( Image pImage ) throws FunctionalException;
}
