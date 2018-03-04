package com.parlow.escalade.consummer.dao.impl;

import com.parlow.escalade.consummer.dao.contract.SiteDao;
import com.parlow.escalade.consummer.dao.util.DAOException;
import com.parlow.escalade.model.bean.Site;

import javax.inject.Named;
import java.util.List;

@Named
public class SiteDaoImpl implements SiteDao {
    @Override
    public void creer(Site site) throws DAOException {

    }

    @Override
    public Site trouver(int id) throws DAOException {
        return null;
    }

    @Override
    public List<Site> lister() throws DAOException {
        return null;
    }

    @Override
    public void supprimer(Site site) throws DAOException {

    }
}
