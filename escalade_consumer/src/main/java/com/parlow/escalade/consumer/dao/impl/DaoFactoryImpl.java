package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.*;

import javax.inject.Named;
import javax.inject.Inject;


@Named
public class DaoFactoryImpl implements DaoFactory {

    @Inject
    private AdresseDao adresseDao;
    @Inject
    private CommentaireDao commentaireDao;
    @Inject
    private CotationDao cotationDao;
    @Inject
    private ImageDao imageDao;
    @Inject
    private LocationDao locationDao;
    @Inject
    private LongueurDao longueurDao;
    @Inject
    private PeriodeFavDao periodeFavDao;
    @Inject
    private ProfilDao profilDao;
    @Inject
    private RegionDao regionDao;
    @Inject
    private SecteurDao secteurDao;
    @Inject
    private SiteDao siteDao;
    @Inject
    private TopoDao topoDao;
    @Inject
    private TypeRocherDao typeRocherDao;
    @Inject
    private UtilisateurDao utilisateurDao;
    @Inject
    private VoieDao voieDao;
    @Inject
    private DepartementDao departementDao;

    @Override
    public AdresseDao getAdresseDao() {
        return adresseDao;
    }
    @Override
    public void setAdresseDao(AdresseDao adresseDao) {
        this.adresseDao = adresseDao;
    }
    @Override
    public CommentaireDao getCommentaireDao() {
        return commentaireDao;
    }
    @Override
    public void setCommentaireDao(CommentaireDao commentaireDao) {
        this.commentaireDao = commentaireDao;
    }
    @Override
    public CotationDao getCotationDao() {
        return cotationDao;
    }
    @Override
    public void setCotationDao(CotationDao cotationDao) {
        this.cotationDao = cotationDao;
    }
    @Override
    public ImageDao getImageDao() {
        return imageDao;
    }
    @Override
    public void setImageDao(ImageDao imageDao) {
        this.imageDao = imageDao;
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
    public PeriodeFavDao getPeriodeFavDao() {
        return periodeFavDao;
    }
    @Override
    public void setPeriodeFavDao(PeriodeFavDao periodeFavDao) {
        this.periodeFavDao = periodeFavDao;
    }
    @Override
    public ProfilDao getProfilDao() {
        return profilDao;
    }
    @Override
    public void setProfilDao(ProfilDao profilDao) {
        this.profilDao = profilDao;
    }
    @Override
    public RegionDao getRegionDao() {
        return regionDao;
    }
    @Override
    public void setRegionDao(RegionDao regionDao) {
        this.regionDao = regionDao;
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
    public TypeRocherDao getTypeRocherDao() {
        return typeRocherDao;
    }
    @Override
    public void setTypeRocherDao(TypeRocherDao typeRocherDao) {
        this.typeRocherDao = typeRocherDao;
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
    public DepartementDao getDepartementDao() {
        return departementDao;
    }
    @Override
    public void setDepartementDao(DepartementDao departementDao) {
        this.departementDao = departementDao;
    }
}
