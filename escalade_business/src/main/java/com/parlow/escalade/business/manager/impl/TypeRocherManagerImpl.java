package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.TypeRocherManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.TypeRocher;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TypeRocherManagerImpl extends AbstractManager implements TypeRocherManager{

    @Inject
    private DaoFactory daoFactory;

    @Override
    public TypeRocher findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("TypeRocher non trouvé : ID=" + pId);
        }
        TypeRocher vTypeRocher = daoFactory.getTypeRocherDao().findById(pId);
        return vTypeRocher;
    }

    @Override
    public List<TypeRocher> findAll() {
        List<TypeRocher> vList = daoFactory.getTypeRocherDao().findAll();
        if (vList == null) {
            TypeRocher typeRocher = new TypeRocher();
            typeRocher.setId(1);
            typeRocher.setTypeRocher("Pas de données");
            vList.add(typeRocher);
        }
        return vList;
    }

    @Override
    public int insert(TypeRocher pTypeRocher) throws FunctionalException {
        if (pTypeRocher == null) {
            throw new FunctionalException("L'objet TypeRocher ne doit pas être null !");
        }
        return daoFactory.getTypeRocherDao().insert(pTypeRocher);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("TypeRocher non trouvé : ID=" + pId);
        }
        daoFactory.getTypeRocherDao().delete(pId);
    }

    @Override
    public void update(TypeRocher pTypeRocher) throws FunctionalException {
        if (pTypeRocher == null) {
            throw new FunctionalException("L'objet TypeRocher ne doit pas être null !");
        }
        daoFactory.getTypeRocherDao().update(pTypeRocher);
    }
}
