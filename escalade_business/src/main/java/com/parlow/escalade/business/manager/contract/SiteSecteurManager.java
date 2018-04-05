package com.parlow.escalade.business.manager.contract;

import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.TechnicalException;

import java.util.List;

public interface SiteSecteurManager {


    /**
     * Insert l'association entre le {@link Site} et le {@link Secteur}
     * @param pSite,pSecteur le {@link Site} et le {@link Secteur}
     * @return Le id généré
     * @throws FunctionalException si le site ou le secteur est null
     * @throws TechnicalException si problème avec la base de données
     */
    int insert( Site pSite, Secteur pSecteur )throws FunctionalException, TechnicalException;


    /**
     * Renvoie la liste des {@link Site}
     * @param pSecteurId le id du {@link Secteur}
     * @return List de {@link Site}
     * @throws FunctionalException si le secteur est null
     * @throws TechnicalException si problème avec la base de données
     */
    List<Site> findAllBySecteur(int pSecteurId)throws FunctionalException, TechnicalException;

    /**
     * Renvoie la liste des {@link Secteur}
     * @param pSiteId le id du {@link Site}
     * @return List de {@link Secteur}
     * @throws FunctionalException si le site est null
     * @throws TechnicalException si problème avec la base de données
     */

    List<Secteur> findAllBySite(int pSiteId)throws FunctionalException, TechnicalException;
}
