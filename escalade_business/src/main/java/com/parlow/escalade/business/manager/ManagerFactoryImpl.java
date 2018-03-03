package com.parlow.escalade.business.manager;

public final class ManagerFactoryImpl implements ManagerFactory {

    /** Instance unique de la classe (design pattern Singleton) */
    public static final ManagerFactoryImpl INSTANCE = new ManagerFactoryImpl();

    private SiteManager siteManager;
    private SecteurManager secteurManager;



    /**
     * Constructeur.
     */
    public ManagerFactoryImpl() {
        super();
    }

    /**
     * Renvoie l'instance unique de la classe (design pattern Singleton).
     *
     * @return {@link ManagerFactoryImpl}
     */
    public static ManagerFactoryImpl getInstance() {
        return ManagerFactoryImpl.INSTANCE;
    }


    // On renvoie désormais simplement l'attribut siteManager
    @Override
    public SiteManager getSiteManager() {
        return siteManager;
    }

    // Ajout d'un setter pour l'attribut siteManager
    @Override
    public void setSiteManager(SiteManager pSiteManager) {
        siteManager = pSiteManager;
    }
    // On renvoie désormais simplement l'attribut secteurManager
    @Override
    public SecteurManager getSecteurManager() {
        return secteurManager;
    }

    // Ajout d'un setter pour l'attribut secteurManager
    @Override
    public void setSecteurManager(SecteurManager pSecteurManager) {
        secteurManager = pSecteurManager;
    }

}
