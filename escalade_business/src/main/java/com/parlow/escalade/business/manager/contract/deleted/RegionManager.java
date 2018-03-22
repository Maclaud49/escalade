package com.parlow.escalade.business.manager.contract.deleted;

import com.parlow.escalade.model.bean.deleted.Region;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface RegionManager {
    /**
     * Renvoie la le {@link Region} demandé
     * @param pId du {@link Region}
     * @return {@link Region}
     * @throws NotFoundException si non trouvé
     */
    Region findById( int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link Region}
     *
     * @return List
     */
    List<Region> findAll();

    /**
     * Insert l'{@link Region} dans la bdd
     * @param pRegion le {@link Region}
     * @return Le {@link Region}
     * @throws FunctionalException si le region est null
     */
    int insert( Region pRegion )throws FunctionalException;

    /**
     * Supprime un {@link Region}
     * @param pId du {@link Region}
     * @throws NotFoundException si non trouvé               
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Region} dans la bdd
     * @param pRegion le {@link Region}
     * @return boolean
     * @throws FunctionalException si le region est null
     */
    void update ( Region pRegion ) throws FunctionalException;
}
