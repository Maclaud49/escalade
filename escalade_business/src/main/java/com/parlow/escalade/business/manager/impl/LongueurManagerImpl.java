package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.LongueurManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Longueur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class LongueurManagerImpl extends AbstractManager implements LongueurManager{

    @Inject
    private DaoFactory daoFactory;

    @Override
    public Longueur findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Longueur non trouvé : ID=" + pId);
        }
        Longueur vLongueur = daoFactory.getLongueurDao().findById(pId);
        return vLongueur;
    }

    @Override
    public List<Longueur> findAll() {
        List<Longueur> vList = daoFactory.getLongueurDao().findAll();
        if (vList == null) {
            Longueur longueur = new Longueur();
            longueur.setId(1);
            longueur.setNom("Pas de données");
            vList.add(longueur);
        }
        return vList;
    }

    @Override
    public int insert(Longueur pLongueur) throws FunctionalException {
        if (pLongueur == null) {
            throw new FunctionalException("L'objet Longueur ne doit pas être null !");
        }
        return daoFactory.getLongueurDao().insert(pLongueur);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Longueur non trouvé : ID=" + pId);
        }
        daoFactory.getLongueurDao().delete(pId);
    }

    @Override
    public void update(Longueur pLongueur) throws FunctionalException {
        if (pLongueur == null) {
            throw new FunctionalException("L'objet Longueur ne doit pas être null !");
        }
        daoFactory.getLongueurDao().update(pLongueur);
    }
}
