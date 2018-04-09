package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.CommentaireManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Commentaire;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class CommentaireManagerImpl extends AbstractManager implements CommentaireManager{

    @Override
    public Commentaire findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Commentaire non trouvé : ID=" + pId);
        }
        Commentaire vCommentaire = daoFactory.getCommentaireDao().findById(pId);
        return vCommentaire;
    }

    @Override
    public List<Commentaire> findAll() {
        List<Commentaire> vList = daoFactory.getCommentaireDao().findAll();
        if (vList == null) {
            Commentaire commentaire = new Commentaire();
            commentaire.setId(1);
            commentaire.setCommentaire("Pas de données");
            vList.add(commentaire);
        }
        return vList;
    }

    @Override
    public int insert(Commentaire pCommentaire) throws FunctionalException {
        if (pCommentaire == null) {
            throw new FunctionalException("L'objet Commentaire ne doit pas être null !");
        }
        return daoFactory.getCommentaireDao().insert(pCommentaire);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Commentaire non trouvé : ID=" + pId);
        }
        daoFactory.getCommentaireDao().delete(pId);
    }

    @Override
    public void update(Commentaire pCommentaire) throws FunctionalException {
        if (pCommentaire == null) {
            throw new FunctionalException("L'objet Commentaire ne doit pas être null !");
        }
        daoFactory.getCommentaireDao().update(pCommentaire);
    }

    @Override
    public List<Commentaire> findAllBySectionAndArticle(String pSection, int pArticle) {
        return daoFactory.getCommentaireDao().findAllBySectionAndArticle(pSection,pArticle);
    }
}
