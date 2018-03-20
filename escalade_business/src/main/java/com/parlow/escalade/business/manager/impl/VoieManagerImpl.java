package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.VoieManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class VoieManagerImpl extends AbstractManager implements VoieManager{

    @Inject
    private DaoFactory daoFactory;

    @Override
    public Voie findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Voie non trouvé : ID=" + pId);
        }
        Voie vVoie = daoFactory.getVoieDao().findById(pId);
        return vVoie;
    }

    @Override
    public List<Voie> findAll() {
        List<Voie> vList = daoFactory.getVoieDao().findAll();
        if (vList == null) {
            Voie voie = new Voie();
            voie.setId(1);
            voie.setNom("Pas de données");
            vList.add(voie);
        }
        return vList;
    }

    @Override
    public int insert(Voie pVoie) throws FunctionalException {
        if (pVoie == null) {
            throw new FunctionalException("L'objet Voie ne doit pas être null !");
        }
        return daoFactory.getVoieDao().insert(pVoie);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Voie non trouvé : ID=" + pId);
        }
        daoFactory.getVoieDao().delete(pId);
    }

    @Override
    public void update(Voie pVoie) throws FunctionalException {
        if (pVoie == null) {
            throw new FunctionalException("L'objet Voie ne doit pas être null !");
        }
        daoFactory.getVoieDao().update(pVoie);
    }
}
