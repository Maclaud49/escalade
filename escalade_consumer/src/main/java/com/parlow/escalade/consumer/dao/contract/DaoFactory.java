package com.parlow.escalade.consumer.dao.contract;


public interface DaoFactory {



    CommentaireDao getCommentaireDao();

    void setCommentaireDao(CommentaireDao commentaireDao);

    LocationDao getLocationDao();

    void setLocationDao(LocationDao locationDao);

    LongueurDao getLongueurDao();

    void setLongueurDao(LongueurDao longueurDao);

    SecteurDao getSecteurDao();

    void setSecteurDao(SecteurDao secteurDao);

    SiteDao getSiteDao();

    void setSiteDao(SiteDao siteDao);

    TopoDao getTopoDao();

    void setTopoDao(TopoDao topoDao);

    UtilisateurDao getUtilisateurDao();

    void setUtilisateurDao(UtilisateurDao utilisateurDao);

    VoieDao getVoieDao();

    void setVoieDao(VoieDao voieDao);

    SiteSecteurAssoDao getSiteSecteurAssoDao();

    void setSiteSecteurAssoDao(SiteSecteurAssoDao siteSecteurAssoDao);

    SecteurVoieAssoDao getSecteurVoieAssoDao();

    void setSecteurVoieAssoDao(SecteurVoieAssoDao secteurVoieAssoDao);

}
