package com.parlow.escalade.business.manager.impl;

import com.parlow.escalade.business.manager.contract.*;

import javax.inject.Named;
import javax.inject.Inject;

@Named
public final class ManagerFactoryImpl implements ManagerFactory {

    @Inject
    private AdresseManager adresseManager;
    @Inject
    private CommentaireManager commentaireManager;
    @Inject
    private CotationManager cotationManager;
    @Inject
    private ImageManager imageManager;
    @Inject
    private LocationManager locationManager;
    @Inject
    private LongueurManager longueurManager;
    @Inject
    private PeriodeFavManager periodeFavManager;
    @Inject
    private ProfilManager profilManager;
    @Inject
    private RegionManager regionManager;
    @Inject
    private SecteurManager secteurManager;
    @Inject
    private SiteManager siteManager;
    @Inject
    private TopoManager topoManager;
    @Inject
    private TypeRocherManager typeRocher;
    @Inject
    private UtilisateurManager utilisateurManager;
    @Inject
    private VoieManager voieManager;
    @Inject
    private DepartementManager departementManager;


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
    public RegionManager getRegionManager() {
        return this.regionManager;
    }

    @Override
    public void setRegionManager(RegionManager pRegionManager) {
         this.regionManager = pRegionManager;
    }
    @Override
    public AdresseManager getAdresseManager() {
        return adresseManager;
    }
    @Override
    public void setAdresseManager(AdresseManager adresseManager) {
        this.adresseManager = adresseManager;
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
    public CotationManager getCotationManager() {
        return cotationManager;
    }
    @Override
    public void setCotationManager(CotationManager cotationManager) {
        this.cotationManager = cotationManager;
    }
    @Override
    public ImageManager getImageManager() {
        return imageManager;
    }
    @Override
    public void setImageManager(ImageManager imageManager) {
        this.imageManager = imageManager;
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
    public PeriodeFavManager getPeriodeFavManager() {
        return periodeFavManager;
    }
    @Override
    public void setPeriodeFavManager(PeriodeFavManager periodeFavManager) {
        this.periodeFavManager = periodeFavManager;
    }
    @Override
    public ProfilManager getProfilManager() {
        return profilManager;
    }
    @Override
    public void setProfilManager(ProfilManager profilManager) {
        this.profilManager = profilManager;
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
    public TypeRocherManager getTypeRocher() {
        return typeRocher;
    }
    @Override
    public void setTypeRocher(TypeRocherManager typeRocher) {
        this.typeRocher = typeRocher;
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
    public DepartementManager getDepartementManager() {
        return departementManager;
    }
    @Override
    public void setDepartementManager(DepartementManager departementManager) {
        this.departementManager = departementManager;
    }
}
