package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.*;
import com.parlow.escalade.consumer.dao.contract.deleted.*;

import javax.inject.Named;
import javax.inject.Inject;


@Named
public class DaoFactoryImpl implements DaoFactory {

    @Inject
    private CommentaireDao commentaireDao;
    @Inject
    private LocationDao locationDao;
    @Inject
    private LongueurDao longueurDao;
    @Inject
    private SecteurDao secteurDao;
    @Inject
    private SiteDao siteDao;
    @Inject
    private TopoDao topoDao;
    @Inject
    private UtilisateurDao utilisateurDao;
    @Inject
    private VoieDao voieDao;
    @Inject
    private SiteSecteurAssoDao siteSecteurAssoDao;
    @Inject
    private SecteurVoieAssoDao secteurVoieAssoDao;

    @Override
    public CommentaireDao getCommentaireDao() {
        return commentaireDao;
    }
    @Override
    public void setCommentaireDao(CommentaireDao commentaireDao) {
        this.commentaireDao = commentaireDao;
    }
    @Override
    public LocationDao getLocationDao() {
        return locationDao;
    }
    @Override
    public void setLocationDao(LocationDao locationDao) {
        this.locationDao = locationDao;
    }
    @Override
    public LongueurDao getLongueurDao() {
        return longueurDao;
    }
    @Override
    public void setLongueurDao(LongueurDao longueurDao) {
        this.longueurDao = longueurDao;
    }
    @Override
    public SecteurDao getSecteurDao() {
        return secteurDao;
    }
    @Override
    public void setSecteurDao(SecteurDao secteurDao) {
        this.secteurDao = secteurDao;
    }
    @Override
    public SiteDao getSiteDao() {
        return siteDao;
    }
    @Override
    public void setSiteDao(SiteDao siteDao) {
        this.siteDao = siteDao;
    }
    @Override
    public TopoDao getTopoDao() {
        return topoDao;
    }
    @Override
    public void setTopoDao(TopoDao topoDao) {
        this.topoDao = topoDao;
    }
    @Override
    public UtilisateurDao getUtilisateurDao() {
        return utilisateurDao;
    }
    @Override
    public void setUtilisateurDao(UtilisateurDao utilisateurDao) {
        this.utilisateurDao = utilisateurDao;
    }
    @Override
    public VoieDao getVoieDao() {
        return voieDao;
    }
    @Override
    public void setVoieDao(VoieDao voieDao) {
        this.voieDao = voieDao;
    }

    @Override
    public SiteSecteurAssoDao getSiteSecteurAssoDao() {
        return null;
    }

    @Override
    public void setSiteSecteurAssoDao(SiteSecteurAssoDao siteSecteurAssoDao) {

    }

    @Override
    public SecteurVoieAssoDao getSecteurVoieAssoDao() {
        return null;
    }

    @Override
    public void setSecteurVoieAssoDao(SecteurVoieAssoDao secteurVoieAssoDao) {

    }

}
