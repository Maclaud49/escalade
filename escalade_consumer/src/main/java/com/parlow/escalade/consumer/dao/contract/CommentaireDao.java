package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.Commentaire;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface CommentaireDao {

    /**
     * Renvoie la le {@link Commentaire} demandé
     * @param pId du {@link Commentaire}
     * @return {@link Commentaire}
     * @throws NotFoundException si non trouvé
     */
    Commentaire findById( int pId )throws NotFoundException;

    /**
     * Renvoie la liste des {@link Commentaire}
     *
     * @return List
     */
    List<Commentaire> findAll();

    /**
     * Insert l'{@link Commentaire} dans la bdd
     * @param pCommentaire le {@link Commentaire}
     * @return Le {@link Commentaire}
     * @throws FunctionalException si le commentaire est null
     */
    int insert( Commentaire pCommentaire )throws FunctionalException;

    /**
     * Supprime un {@link Commentaire}
     * @param pId du {@link Commentaire}
     * @throws NotFoundException si non trouvé
     * @return boolean
     */
    void delete( int pId )throws NotFoundException;

    /**
     * Met à jour l'{@link Commentaire} dans la bdd
     * @param pCommentaire le {@link Commentaire}
     * @return boolean
     * @throws FunctionalException si le commentaire est null
     */
    void update ( Commentaire pCommentaire ) throws FunctionalException;

    /**
     * Renvoie la liste des {@link Commentaire} liée à une section et à un article
     * @param pSection,pArticle les id de la section et de l'article
     * @return List de {@link Commentaire}
     */
    List<Commentaire> findAllBySectionAndArticle(String pSection, int pArticle);
}
