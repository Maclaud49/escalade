package com.parlow.escalade.business.manager.contract;

import com.parlow.escalade.model.bean.Secteur;
import com.parlow.escalade.model.bean.Voie;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;

import java.util.List;

public interface SecteurVoieManager {

    /**
     * Insert l'association entre le {@link Voie} et le {@link Secteur}
     * @param pVoieId,pSecteurId le id du {@link Voie} et le id du {@link Secteur}
     * @return Le id généré
     * @throws FunctionalException si le voie ou le secteur est null
     * @throws TechnicalException si problème avec la base de données
     */
    int insert( int pSecteurId, int pVoieId )throws FunctionalException, TechnicalException;

    /**
     * Renvoie la liste des {@link Voie}
     * @param pSecteurId le id du{@link Secteur}
     * @return List de {@link Voie}
     * @throws FunctionalException si le secteur est null
     * @throws TechnicalException si problème avec la base de données
     */
    List<Voie> findAllBySecteur(int pSecteurId)throws FunctionalException, TechnicalException;

    /**
     * Renvoie la liste des {@link Secteur}
     * @param pVoieId le id du {@link Voie}
     * @return List de {@link Secteur}
     * @throws FunctionalException si le voie est null
     * @throws TechnicalException si problème avec la base de données
     */

    List<Secteur> findAllByVoie(int pVoieId)throws FunctionalException, TechnicalException;

    /**
     * Renvoie l'association entre le {@link Secteur} et le {@link Voie}
     * @param pSecteurId,pVoieId le id du {@link Secteur} et le id du {@link Voie}
     * @return Le id généré
     * @throws FunctionalException si le id du secteur ou le id du voie est null
     * @throws TechnicalException si problème avec la base de données
     * @throws NotFoundException si non trouvé dans la base de données
     */
    int findBySecteurAndVoie(int pSecteurId, int pVoieId ) throws FunctionalException, TechnicalException, NotFoundException;
}
