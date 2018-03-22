package com.parlow.escalade.business.manager.contract.deleted;

import com.parlow.escalade.model.bean.deleted.Profil;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface ProfilManager {
    /**
     * Renvoie la le {@link Profil} demandé
     * @param pId du {@link Profil}
     * @return {@link Profil}
     * @throws NotFoundException si non trouvé
     */
    Profil findById(int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link Profil}
     *
     * @return List
     */
    List<Profil> findAll();

    /**
     * Insert l'{@link Profil} dans la bdd
     * @param pProfil le {@link Profil}
     * @return Le {@link Profil}
     * @throws FunctionalException si le profil est null
     */
    int insert( Profil pProfil )throws FunctionalException;

    /**
     * Supprime un {@link Profil}
     * @param pId du {@link Profil}
     * @throws NotFoundException si non trouvé
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Profil} dans la bdd
     * @param pProfil le {@link Profil}
     * @return boolean
     * @throws FunctionalException si le profil est null
     */
    void update ( Profil pProfil ) throws FunctionalException;
    
}
