package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.LocationManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Location;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class LocationManagerImpl extends AbstractManager implements LocationManager{
    @Inject
    private DaoFactory daoFactory;

    @Override
    public Location findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Location non trouvé : ID=" + pId);
        }
        Location vLocation = daoFactory.getLocationDao().findById(pId);
        return vLocation;
    }

    @Override
    public List<Location> findAll() {
        List<Location> vList = daoFactory.getLocationDao().findAll();
        if (vList == null) {
            Location location = new Location();
            location.setId(1);
            location.setNom("Pas de données");
            vList.add(location);
        }
        return vList;
    }

    @Override
    public int insert(Location pLocation) throws FunctionalException {
        if (pLocation == null) {
            throw new FunctionalException("L'objet Location ne doit pas être null !");
        }
        return daoFactory.getLocationDao().insert(pLocation);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Location non trouvé : ID=" + pId);
        }
        daoFactory.getLocationDao().delete(pId);
    }

    @Override
    public void update(Location pLocation) throws FunctionalException {
        if (pLocation == null) {
            throw new FunctionalException("L'objet Location ne doit pas être null !");
        }
        daoFactory.getLocationDao().update(pLocation);
    }
    
}
