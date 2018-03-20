package com.parlow.escalade.business.manager.contract;

import java.util.List;

import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;


/**
 * Manager du package « utilisateur »
 */
public interface UtilisateurManager {

    /**
     * Renvoie l'{@link Utilisateur} correspondant au couple login / mot de passe
     *
     * @param pLogin le login de l'Utilisateur
     * @param pPassword le mot de passe de l'Utilisateur
     * @return Le {@link Utilisateur}
     * @throws NotFoundException Si l'Utilisateur n'est pas trouvé
     */
    Utilisateur getUtilisateur(String pLogin, String pPassword) throws NotFoundException;

    /**
     * Renvoie la le {@link Utilisateur} demandé
     * @param pId du {@link Utilisateur}
     * @return {@link Utilisateur}
     * @throws NotFoundException si non trouvé
     */
    Utilisateur findById( int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link Utilisateur}
     *
     * @return List
     */
    List<Utilisateur> findAll();

    /**
     * Insert l'{@link Utilisateur} dans la bdd
     * @param pUtilisateur le {@link Utilisateur}
     * @return Le {@link Utilisateur}
     * @throws FunctionalException si le utilisateur est null
     */
    int insert( Utilisateur pUtilisateur )throws FunctionalException;

    /**
     * Supprime un {@link Utilisateur}
     * @param pId du {@link Utilisateur}
     * @throws NotFoundException si non trouvé               
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Utilisateur} dans la bdd
     * @param pUtilisateur le {@link Utilisateur}
     * @return boolean
     * @throws FunctionalException si le utilisateur est null
     */
    void update ( Utilisateur pUtilisateur ) throws FunctionalException;
}
