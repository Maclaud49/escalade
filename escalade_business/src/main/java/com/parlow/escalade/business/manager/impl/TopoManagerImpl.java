package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.TopoManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Topo;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class TopoManagerImpl extends AbstractManager implements TopoManager{

    @Inject
    private DaoFactory daoFactory;

    @Override
    public Topo findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Topo non trouvé : ID=" + pId);
        }
        Topo vTopo = daoFactory.getTopoDao().findById(pId);
        return vTopo;
    }

    @Override
    public List<Topo> findAll() {
        List<Topo> vList = daoFactory.getTopoDao().findAll();
        if (vList == null) {
            Topo topo = new Topo();
            topo.setId(1);
            topo.setNom("Pas de données");
            vList.add(topo);
        }
        return vList;
    }

    @Override
    public int insert(Topo pTopo) throws FunctionalException {
        if (pTopo == null) {
            throw new FunctionalException("L'objet Topo ne doit pas être null !");
        }
        return daoFactory.getTopoDao().insert(pTopo);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Topo non trouvé : ID=" + pId);
        }
        daoFactory.getTopoDao().delete(pId);
    }

    @Override
    public void update(Topo pTopo) throws FunctionalException {
        if (pTopo == null) {
            throw new FunctionalException("L'objet Topo ne doit pas être null !");
        }
        daoFactory.getTopoDao().update(pTopo);
    }
}
