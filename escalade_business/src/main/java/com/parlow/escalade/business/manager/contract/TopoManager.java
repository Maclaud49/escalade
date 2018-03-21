package com.parlow.escalade.business.manager.contract;

import com.parlow.escalade.model.bean.Topo;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;

import java.util.List;

public interface TopoManager {

    /**
     * Renvoie la le {@link Topo} demandé
     * @param pId du {@link Topo}
     * @return {@link Topo}
     * @throws NotFoundException si non trouvé
     */
    Topo findById(int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link Topo}
     *
     * @return List
     */
    List<Topo> findAll();

    /**
     * Insert l'{@link Topo} dans la bdd
     * @param pTopo le {@link Topo}
     * @return Le {@link Topo}
     * @throws FunctionalException si le topo est null
     */
    int insert( Topo pTopo )throws FunctionalException;

    /**
     * Supprime un {@link Topo}
     * @param pId du {@link Topo}
     * @throws NotFoundException si non trouvé
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Topo} dans la bdd
     * @param pTopo le {@link Topo}
     * @return boolean
     * @throws FunctionalException si le topo est null
     */
    void update ( Topo pTopo ) throws FunctionalException;
}
