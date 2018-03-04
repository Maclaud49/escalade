package com.parlow.escalade.business.manager.contract;

import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface SiteManager {

    Site getSite(Integer pId) throws NotFoundException;

    List<Site> getListSite();
}
