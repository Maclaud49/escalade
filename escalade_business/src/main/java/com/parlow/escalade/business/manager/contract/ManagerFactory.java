package com.parlow.escalade.business.manager.contract;


public interface ManagerFactory {

    SiteManager getSiteManager();

    void setSiteManager(SiteManager pSiteManager);

    SecteurManager getSecteurManager();

    void setSecteurManager(SecteurManager pSecteurManager);

    UtilisateurManager getUtilisateurManager();

    void setUtilisateurManager(UtilisateurManager pUtilisateurManager);

    RegionManager getRegionManager();

    void setRegionManager(RegionManager pRegionManager);

    AdresseManager getAdresseManager();

    void setAdresseManager(AdresseManager adresseManager);

    CommentaireManager getCommentaireManager();

    void setCommentaireManager(CommentaireManager commentaireManager);

    CotationManager getCotationManager();

    void setCotationManager(CotationManager cotationManager);

    ImageManager getImageManager();

    void setImageManager(ImageManager imageManager);

    LocationManager getLocationManager();

    void setLocationManager(LocationManager locationManager);

    LongueurManager getLongueurManager();

    void setLongueurManager(LongueurManager longueurManager);

    PeriodeFavManager getPeriodeFavManager();

    void setPeriodeFavManager(PeriodeFavManager periodeFavManager);

    ProfilManager getProfilManager();

    void setProfilManager(ProfilManager profilManager);

    TopoManager getTopoManager();

    void setTopoManager(TopoManager topoManager);

    TypeRocherManager getTypeRocher();

    void setTypeRocher(TypeRocherManager typeRocher);

    VoieManager getVoieManager();

    void setVoieManager(VoieManager voieManager);
}
