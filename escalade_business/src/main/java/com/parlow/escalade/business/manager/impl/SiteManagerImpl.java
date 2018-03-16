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

    @Inject
    private UtilisateurManager utilisateurManager;

    // Je stocke les sites en mémoire car je n'ai pas codé de persistance
    private final List<Site> listSite = new ArrayList<>();

    /**
     * Renvoie le site demandé
     *
     * @param pId l'identifiant du site
     * @return Le {@link Site}
     * @throws NotFoundException Si le site n'est pas trouvé
     */
    @Override
    public Site getSite(Integer pId) throws NotFoundException {
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        if (pId < 1) {
            throw new NotFoundException("Site non trouvé : ID=" + pId);
        }

        Site vSite = daoFactory.getSiteDao().findById(pId);
        return vSite;
    }


    /**
     * Renvoie la liste des {@link Site}
     *
     * @return List
     */
    @Override
    public List<Site> getListSite() {

        List<Site> vList = new ArrayList<>();
        for (int vI = 0; vI < 9; vI++) {
            Site vSite = new Site();
            vSite.setId(vI);
            vSite.setNom("Site n°" + vI);
            vSite.setPresentation("Un site tip top");
            Utilisateur mac = new Utilisateur();
            mac.setId(1);
            mac.setPrenom("Mickael");
            vSite.setUtilisateur(mac);
            vList.add(vSite);
        }
        return vList;
    }

    @Override
    public void insert(Site pSite) throws FunctionalException {
        if (pSite == null) {
            throw new FunctionalException("L'objet Site ne doit pas être null !");
        }

        Set<ConstraintViolation<Site>> vViolations = getConstraintValidator().validate(pSite);
        if (!vViolations.isEmpty()) {
            throw new FunctionalException("L'objet Site est invalide",
                    new ConstraintViolationException(vViolations));
        }

        // TODO Persistance
        pSite.setId(999);
        this.listSite.add(pSite);
        
    }

    @Override
    public Site findById(int id) {
        return null;
    }

    @Override
    public List<Site> findAll() {
        return null;
    }

    @Override
    public void delete(int siteid) {

    }
}
