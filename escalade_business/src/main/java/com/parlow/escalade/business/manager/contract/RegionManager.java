package com.parlow.escalade.business.manager.contract;

import com.parlow.escalade.model.bean.listes.Region;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface RegionManager {

    Region getRegion(int id) throws NotFoundException;

    List<Region> getListRegion();
}
