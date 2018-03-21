package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.ProfilManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Profil;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class ProfilManagerImpl extends AbstractManager implements ProfilManager{

    @Override
    public Profil findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Profil non trouvé : ID=" + pId);
        }
        Profil vProfil = daoFactory.getProfilDao().findById(pId);
        return vProfil;
    }

    @Override
    public List<Profil> findAll() {
        List<Profil> vList = daoFactory.getProfilDao().findAll();
        if (vList == null) {
            Profil profil = new Profil();
            profil.setId(1);
            profil.setProfil("Pas de données");
            vList.add(profil);
        }
        return vList;
    }

    @Override
    public int insert(Profil pProfil) throws FunctionalException {
        if (pProfil == null) {
            throw new FunctionalException("L'objet Profil ne doit pas être null !");
        }
        return daoFactory.getProfilDao().insert(pProfil);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Profil non trouvé : ID=" + pId);
        }
        daoFactory.getProfilDao().delete(pId);
    }

    @Override
    public void update(Profil pProfil) throws FunctionalException {
        if (pProfil == null) {
            throw new FunctionalException("L'objet Profil ne doit pas être null !");
        }
        daoFactory.getProfilDao().update(pProfil);
    }
    
}
