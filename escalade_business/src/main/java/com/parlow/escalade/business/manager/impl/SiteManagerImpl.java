package com.parlow.escalade.business.manager.impl;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.parlow.escalade.business.manager.contract.SiteManager;
import com.parlow.escalade.business.manager.contract.UtilisateurManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.consumer.dao.contract.SiteDao;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import org.joda.time.DateTime;

import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;


/**
 * Manager des beans du package Site.
 *
 * @author lgu
 */
@Named
public class SiteManagerImpl extends AbstractManager implements SiteManager {

    @Inject
    private DaoFactory daoFactory;

    @Override
    public Site findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Site non trouvé : ID=" + pId);
        }
        Site vSite = daoFactory.getSiteDao().findById(pId);
        return vSite;
    }

    @Override
    public List<Site> findAll() {
        List<Site> vList = daoFactory.getSiteDao().findAll();
        if (vList == null) {
            Site site = new Site();
            site.setId(1);
            site.setNom("Pas de données");
            vList.add(site);
        }
        return vList;
    }

    @Override
    public int insert(Site pSite) throws FunctionalException {
        if (pSite == null) {
            throw new FunctionalException("L'objet Site ne doit pas être null !");
        }
        return daoFactory.getSiteDao().insert(pSite);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Site non trouvé : ID=" + pId);
        }
        daoFactory.getSiteDao().delete(pId);
    }

    @Override
    public void update(Site pSite) throws FunctionalException {
        if (pSite == null) {
            throw new FunctionalException("L'objet Site ne doit pas être null !");
        }
        daoFactory.getSiteDao().update(pSite);
    }
}
