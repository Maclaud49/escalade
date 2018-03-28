package com.parlow.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class IndexAction extends ActionSupport implements ServletRequestAware, SessionAware {

    // ==================== Attributs ====================

    private static final Logger logger = LogManager.getLogger(IndexAction.class);
    @Inject
    private ManagerFactory managerFactory;
    private Map<String, Object> session;
    private HttpServletRequest servletRequest;

    // ----- Element en sortie

    private Utilisateur vutilisateur;

    // ==================== Getters/Setters ====================



    // ==================== Méthodes ====================
    /**
     * Action permettant la connexion d'un utilisateur
     * @return input / success
     */
    public String doIndex() {

        logger.debug("debug test");
        logger.info("info test");
        logger.error("error test");

        if (rememberMeLoad() >0){
            Utilisateur vUtilisateur = null;
            try {
                vUtilisateur = managerFactory.getUtilisateurManager().findById(rememberMeLoad());
            } catch (NotFoundException pEx) {
                this.addActionError(getText("error.login.incorrect"));
            }
            this.session.put("user", vUtilisateur);
        }

        String vResult = ActionSupport.SUCCESS;

        return vResult;
    }

    public int rememberMeLoad() {
        int vUtilisateurId = 0;
        Cookie[] cookies = servletRequest.getCookies();
        for(int i=0;cookies!=null&&i<cookies.length;i++) {
            if (cookies[i].getName().equals("escalade_user")) {
                vUtilisateurId = Integer.parseInt(cookies[i].getValue());
                logger.info("id du user en session" + cookies[i].getValue());
            }
        }
        return vUtilisateurId;
    }


    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    @Override
    public void setServletRequest(HttpServletRequest pRequest) {
        this.servletRequest = pRequest;
    }
}
