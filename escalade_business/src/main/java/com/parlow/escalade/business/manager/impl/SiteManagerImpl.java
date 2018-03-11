package com.parlow.escalade.business.manager.impl;


import java.util.ArrayList;
import java.util.List;

import com.parlow.escalade.business.manager.contract.SiteManager;
import com.parlow.escalade.business.manager.contract.UtilisateurManager;
import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.NotFoundException;

import javax.inject.Inject;
import javax.inject.Named;


/**
 * Manager des beans du package Site.
 *
 * @author lgu
 */
@Named
public class SiteManagerImpl implements SiteManager {

    @Inject
    private DaoFactory daoFactory;

    @Inject
    private UtilisateurManager utilisateurManager;



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
        Site vSite = new Site();
        vSite.setNom("Site n°" + pId);
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
            vSite.setNom("Site n°" + vI);
            Utilisateur mac = new Utilisateur("Parlow");
            mac.setId(1);
            mac.setPrenom("Mickael");
            vSite.setUtilisateur(mac);
            vList.add(vSite);
        }
        return vList;
    }
}
