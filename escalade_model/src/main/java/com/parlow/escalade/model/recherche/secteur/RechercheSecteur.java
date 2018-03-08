package com.parlow.escalade.model.recherche.secteur;

/**
 * Classe de critères de recherche de Secteur.
 *
 * @author Parlow
 */
public class RechercheSecteur {

    // ==================== Attributs ====================
    private Integer siteId;
    private Integer auteurId;


    // ==================== Constructeurs ====================
    /**
     * Constructeur par défaut.
     */
    public RechercheSecteur() {

    }


    // ==================== Getters/Setters ====================
    public Integer getAuteurId() {
        return auteurId;
    }

    /**
     * Assigne le critère de recherche : id de l'auteur.
     *
     * @param pAuteurId -
     * @return {@code this}
     */
    public RechercheSecteur setAuteurId(Integer pAuteurId) {
        auteurId = pAuteurId;
        return this;
    }

    public Integer getSiteId() {
        return siteId;
    }

    /**
     * Assigne le critère de recherche : id du site.
     *
     * @param pSiteId -
     * @return {@code this}
     */
    public RechercheSecteur setSiteId(Integer pSiteId) {
        siteId = pSiteId;
        return this;
    }
}
