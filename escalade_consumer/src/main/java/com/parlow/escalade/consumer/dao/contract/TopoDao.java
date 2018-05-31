package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.Topo;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;

import java.util.List;

public interface TopoDao {

    /**
     * Renvoie le {@link Topo} demandé
     * @param pId du {@link Topo}
     * @return {@link Topo}
     * @throws NotFoundException si non trouvé
     */
    Topo findById( int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link Topo}
     *
     * @return List
     */
    List<Topo> findAll();

    /**
     * Renvoie la liste des {@link Topo} publiés
     *
     * @return List de {@link Topo}
     */
    List<Topo> findAllPublic();


    /**
     * Insert l'{@link Topo} dans la bdd
     * @param pTopo le {@link Topo}
     * @return Le id généré du {@link Topo}
     * @throws FunctionalException si le topo est null
     * @throws TechnicalException si problème avec la base de données
     */
    int insert( Topo pTopo )throws FunctionalException, TechnicalException;

    /**
     * Supprime un {@link Topo}
     * @param pId du {@link Topo}
     * @throws NotFoundException si non trouvé
     * @throws TechnicalException si problème avec la base de données
     * @return boolean
     */
    void delete( int pId )throws NotFoundException, TechnicalException;

    /**
     * Met à jour l'{@link Topo} dans la bdd
     * @param pTopo le {@link Topo}
     * @return boolean
     * @throws FunctionalException si le topo est null
     */
    void update ( Topo pTopo ) throws FunctionalException;

    /**
     * Renvoie la liste des résultats de la recherche
     * @param keyWord
     * @return List
     */
    List<Topo> searchResult(String keyWord);

    /**
     * Renvoie le {@link Topo} demandé
     * @param pNom du {@link Topo}
     * @return {@link Topo}
     * @throws NotFoundException si non trouvé
     */
    Topo findByName( String pNom )throws NotFoundException;

    /**
     * Renvoie une liste de {@link Topo}
     * @param id de l'utilisateur
     * @return
     */
    List<Topo> findListByUserId(int id);
}
