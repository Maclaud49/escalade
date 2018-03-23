package com.parlow.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

public class IndexAction extends ActionSupport implements ServletRequestAware, SessionAware {

    // ==================== Attributs ====================
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

        String vResult = ActionSupport.SUCCESS;

        return vResult;
    }

    public int rememberMeLoad() {
        int vUtilisateurId = 0;
        for(Cookie c : servletRequest.getCookies()) {
            if (c.getName().equals("escalade_user"))
                vUtilisateurId=Integer.parseInt(c.getValue());
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
