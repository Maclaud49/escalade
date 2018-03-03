package com.parlow.escalade.business.manager;


import java.util.ArrayList;
import java.util.List;

import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.NotFoundException;


/**
 * Manager des beans du package Site.
 *
 * @author lgu
 */
public class SiteManagerImpl implements SiteManager{

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
        // Je n'ai pas encore codé la DAO
        // Je mets juste un code temporaire pour commencer le cours...
        List<Site> vList = new ArrayList<>();
        for (int vI = 0; vI < 9; vI++) {
            Site vSite = new Site();
            vSite.setNom("Site n°" + vI);
            vList.add(vSite);
        }
        return vList;
    }
}
