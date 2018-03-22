package com.parlow.escalade.business.manager.contract.deleted;

import com.parlow.escalade.model.bean.deleted.PeriodeFav;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface PeriodeFavManager {

    /**
     * Renvoie la le {@link PeriodeFav} demandé
     * @param pId du {@link PeriodeFav}
     * @return {@link PeriodeFav}
     * @throws NotFoundException si non trouvé
     */
    PeriodeFav findById(int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link PeriodeFav}
     *
     * @return List
     */
    List<PeriodeFav> findAll();

    /**
     * Insert l'{@link PeriodeFav} dans la bdd
     * @param pPeriodeFav le {@link PeriodeFav}
     * @return Le {@link PeriodeFav}
     * @throws FunctionalException si le periodeFav est null
     */
    int insert( PeriodeFav pPeriodeFav )throws FunctionalException;

    /**
     * Supprime un {@link PeriodeFav}
     * @param pId du {@link PeriodeFav}
     * @throws NotFoundException si non trouvé
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link PeriodeFav} dans la bdd
     * @param pPeriodeFav le {@link PeriodeFav}
     * @return boolean
     * @throws FunctionalException si le periodeFav est null
     */
    void update ( PeriodeFav pPeriodeFav ) throws FunctionalException;
}
