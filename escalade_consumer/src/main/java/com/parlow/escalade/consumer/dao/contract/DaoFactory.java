package com.parlow.escalade.consumer.dao.contract;

public interface DaoFactory {


    AdresseDao getAdresseDao();

    void setAdresseDao(AdresseDao adresseDao);

    CommentaireDao getCommentaireDao();

    void setCommentaireDao(CommentaireDao commentaireDao);

    CotationDao getCotationDao();

    void setCotationDao(CotationDao cotationDao);

    ImageDao getImageDao();

    void setImageDao(ImageDao imageDao);

    LocationDao getLocationDao();

    void setLocationDao(LocationDao locationDao);

    LongueurDao getLongueurDao();

    void setLongueurDao(LongueurDao longueurDao);

    PeriodeFavDao getPeriodeFavDao();

    void setPeriodeFavDao(PeriodeFavDao periodeFavDao);

    ProfilDao getProfilDao();

    void setProfilDao(ProfilDao profilDao);

    RegionDao getRegionDao();

    void setRegionDao(RegionDao regionDao);

    SecteurDao getSecteurDao();

    void setSecteurDao(SecteurDao secteurDao);

    SiteDao getSiteDao();

    void setSiteDao(SiteDao siteDao);

    TopoDao getTopoDao();

    void setTopoDao(TopoDao topoDao);

    TypeRocherDao getTypeRocher();

    void setTypeRocher(TypeRocherDao typeRocher);

    UtilisateurDao getUtilisateurDao();

    void setUtilisateurDao(UtilisateurDao utilisateurDao);

    VoieDao getVoieDao();

    void setVoieDao(VoieDao voieDao);
}
