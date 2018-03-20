package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.DepartementManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Departement;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class DepartementManagerImpl extends AbstractManager implements DepartementManager {
    @Inject
    private DaoFactory daoFactory;

    @Override
    public Departement findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Departement non trouvé : ID=" + pId);
        }
        Departement vDepartement = daoFactory.getDepartementDao().findById(pId);
        return vDepartement;
    }

    @Override
    public List<Departement> findAll() {
        List<Departement> vList = daoFactory.getDepartementDao().findAll();
        if (vList == null) {
            Departement departement = new Departement();
            departement.setId(1);
            departement.setDepartement("Pas de données");
            vList.add(departement);
        }
        return vList;
    }

    @Override
    public int insert(Departement pDepartement) throws FunctionalException {
        if (pDepartement == null) {
            throw new FunctionalException("L'objet Departement ne doit pas être null !");
        }
        return daoFactory.getDepartementDao().insert(pDepartement);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Departement non trouvé : ID=" + pId);
        }
        daoFactory.getDepartementDao().delete(pId);
    }

    @Override
    public void update(Departement pDepartement) throws FunctionalException {
        if (pDepartement == null) {
            throw new FunctionalException("L'objet Departement ne doit pas être null !");
        }
        daoFactory.getDepartementDao().update(pDepartement);
    }
    
}
