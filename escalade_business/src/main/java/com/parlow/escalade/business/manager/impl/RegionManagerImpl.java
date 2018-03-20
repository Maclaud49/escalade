package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.RegionManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Region;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class RegionManagerImpl extends AbstractManager implements RegionManager {


    @Inject
    private DaoFactory daoFactory;

    @Override
    public Region findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Region non trouvé : ID=" + pId);
        }
        Region vRegion = daoFactory.getRegionDao().findById(pId);
        return vRegion;
    }

    @Override
    public List<Region> findAll() {
        List<Region> vList = daoFactory.getRegionDao().findAll();
        if (vList == null) {
            Region region = new Region();
            region.setId(1);
            region.setRegion("Pas de données");
            vList.add(region);
        }
        return vList;
    }

    @Override
    public int insert(Region pRegion) throws FunctionalException {
        if (pRegion == null) {
            throw new FunctionalException("L'objet Region ne doit pas être null !");
        }
        return daoFactory.getRegionDao().insert(pRegion);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Region non trouvé : ID=" + pId);
        }
        daoFactory.getRegionDao().delete(pId);
    }

    @Override
    public void update(Region pRegion) throws FunctionalException {
        if (pRegion == null) {
            throw new FunctionalException("L'objet Region ne doit pas être null !");
        }
        daoFactory.getRegionDao().update(pRegion);
    }
}
