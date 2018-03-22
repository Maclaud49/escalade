package com.parlow.escalade.business.manager.contract.deleted;

import com.parlow.escalade.model.bean.deleted.Departement;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface DepartementManager {

    /**
     * Renvoie la le {@link Departement} demandé
     * @param pId du {@link Departement}
     * @return {@link Departement}
     * @throws NotFoundException si non trouvé
     */
    Departement findById(int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link Departement}
     *
     * @return List
     */
    List<Departement> findAll();

    /**
     * Insert l'{@link Departement} dans la bdd
     * @param pDepartement le {@link Departement}
     * @return Le {@link Departement}
     * @throws FunctionalException si le image est null
     */
    int insert( Departement pDepartement )throws FunctionalException;

    /**
     * Supprime un {@link Departement}
     * @param pId du {@link Departement}
     * @throws NotFoundException si non trouvé
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Departement} dans la bdd
     * @param pDepartement le {@link Departement}
     * @return boolean
     * @throws FunctionalException si le image est null
     */
    void update ( Departement pDepartement ) throws FunctionalException;
}
