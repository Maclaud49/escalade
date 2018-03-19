package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.RegionManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.listes.Region;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

@Named
public class RegionManagerImpl implements RegionManager {

    @Inject
    private DaoFactory daoFactory;

    @Override
    public Region getRegion(int id) throws NotFoundException {
        return null;
    }

    @Override
    public List<Region> getListRegion() {
        List<Region> vList = new ArrayList<>();
        vList = daoFactory.getRegionDao().findAll();
        return vList;
    }
}
