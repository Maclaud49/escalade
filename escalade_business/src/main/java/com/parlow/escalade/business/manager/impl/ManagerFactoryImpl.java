package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.*;
import com.parlow.escalade.consumer.dao.contract.SecteurVoieAssoDao;
import com.parlow.escalade.consumer.dao.contract.SiteSecteurAssoDao;

import javax.inject.Named;
import javax.inject.Inject;

@Named
public final class ManagerFactoryImpl implements ManagerFactory {


    @Inject
    private CommentaireManager commentaireManager;
    @Inject
    private LocationManager locationManager;
    @Inject
    private LongueurManager longueurManager;
    @Inject
    private SecteurManager secteurManager;
    @Inject
    private SiteManager siteManager;
    @Inject
    private TopoManager topoManager;
    @Inject
    private UtilisateurManager utilisateurManager;
    @Inject
    private VoieManager voieManager;
    @Inject
    private SiteSecteurManager siteSecteurManager;
    @Inject
    private SecteurVoieManager secteurVoieManager;



    @Override
    public SiteManager getSiteManager() {
        return this.siteManager;
    }

    @Override
    public void setSiteManager(SiteManager pSiteManager) {
        this.siteManager = pSiteManager;
    }

    @Override
    public SecteurManager getSecteurManager() {
        return this.secteurManager;
    }

    @Override
    public void setSecteurManager(SecteurManager pSecteurManager) {
        this.secteurManager = pSecteurManager;
    }

    @Override
    public UtilisateurManager getUtilisateurManager() {
        return this.utilisateurManager;
    }

    @Override
    public void setUtilisateurManager(UtilisateurManager pUtilisateurManager) {
        this.utilisateurManager = pUtilisateurManager;
    }
    @Override
    public CommentaireManager getCommentaireManager() {
        return commentaireManager;
    }
    @Override
    public void setCommentaireManager(CommentaireManager commentaireManager) {
        this.commentaireManager = commentaireManager;
    }
    @Override
    public LocationManager getLocationManager() {
        return locationManager;
    }
    @Override
    public void setLocationManager(LocationManager locationManager) {
        this.locationManager = locationManager;
    }
    @Override
    public LongueurManager getLongueurManager() {
        return longueurManager;
    }
    @Override
    public void setLongueurManager(LongueurManager longueurManager) {
        this.longueurManager = longueurManager;
    }
    @Override
    public TopoManager getTopoManager() {
        return topoManager;
    }
    @Override
    public void setTopoManager(TopoManager topoManager) {
        this.topoManager = topoManager;
    }
    @Override
    public VoieManager getVoieManager() {
        return voieManager;
    }
    @Override
    public void setVoieManager(VoieManager voieManager) {
        this.voieManager = voieManager;
    }

    @Override
    public SiteSecteurManager getSiteSecteurManager() {
        return siteSecteurManager;
    }

    @Override
    public void setSiteSecteurManager(SiteSecteurManager siteSecteurManager) {this.siteSecteurManager = siteSecteurManager;}

    @Override
    public SecteurVoieManager getSecteurVoieManager() {
        return secteurVoieManager;
    }

    @Override
    public void setSecteurVoieManager(SecteurVoieManager secteurVoieManager) {this.secteurVoieManager = secteurVoieManager;}

    }


