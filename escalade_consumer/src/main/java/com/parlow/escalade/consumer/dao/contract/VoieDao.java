package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface VoieDao {

    /**
     * Renvoie la le {@link Voie} demandé
     * @param pId du {@link Voie}
     * @return {@link Voie}
     * @throws NotFoundException si non trouvé
     */
    Voie findById(int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link Voie}
     *
     * @return List
     */
    List<Voie> findAll();

    /**
     * Insert l'{@link Voie} dans la bdd
     * @param pVoie le {@link Voie}
     * @return Le {@link Voie}
     * @throws FunctionalException si le voie est null
     */
    int insert( Voie pVoie )throws FunctionalException;

    /**
     * Supprime un {@link Voie}
     * @param pId du {@link Voie}
     * @throws NotFoundException si non trouvé
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Voie} dans la bdd
     * @param pVoie le {@link Voie}
     * @return boolean
     * @throws FunctionalException si le voie est null
     */
    void update ( Voie pVoie ) throws FunctionalException;

    /**
     * Renvoie la liste des {@link Voie} liés à un secteur
     * @param secteurId du {@link Secteur}
     * @return List
     */
    List<Voie> findAllBySecteurId(int secteurId) throws NotFoundException;

    /**
     * Renvoie la liste des résultats de la recherche
     * @param keyWord
     * @return List
     */
    List<Voie> searchResult(String keyWord);
}
