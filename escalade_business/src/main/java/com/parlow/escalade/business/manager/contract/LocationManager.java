package com.parlow.escalade.business.manager.contract;

import com.parlow.escalade.model.bean.Location;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;

import java.util.List;

public interface LocationManager {

    /**
     * Renvoie la le {@link Location} demandé
     * @param pId du {@link Location}
     * @return {@link Location}
     * @throws NotFoundException si non trouvé
     */
    Location findById(int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link Location}
     *
     * @return List
     */
    List<Location> findAll();

    /**
     * Insert l'{@link Location} dans la bdd
     * @param pLocation le {@link Location}
     * @return Le {@link Location}
     * @throws FunctionalException si la location est null
     * @throws TechnicalException si problème avec la base de données
     */
    int insert( Location pLocation )throws FunctionalException, TechnicalException;

    /**
     * Supprime un {@link Location}
     * @param pId du {@link Location}
     * @throws NotFoundException si non trouvé
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Location} dans la bdd
     * @param pLocation le {@link Location}
     * @return boolean
     * @throws FunctionalException si le location est null
     */
    void update ( Location pLocation ) throws FunctionalException;
}
