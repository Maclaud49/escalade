package com.parlow.escalade.webapp.action;

import com.parlow.escalade.business.manager.contract.ManagerFactory;
import org.apache.commons.lang3.StringUtils;
import com.opensymphony.xwork2.ActionSupport;

import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.NotFoundException;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;


/**
 * Action de gestion de la connexion/déconnexion d'un utilisateur
 */
public class LoginAction extends ActionSupport implements ServletRequestAware,ServletResponseAware, SessionAware {


    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;
    private Map<String, Object> session;
    private HttpServletRequest servletRequest;
    protected HttpServletResponse servletResponse;

    // ----- Paramètres en entrée
    private String email;
    private String password;
    private boolean remember;
    //todo mettre dans cookie


    // ==================== Getters/Setters ====================
    public String getEmail() {
        return email;
    }
    public void setEmail(String pEmail) {
        email = pEmail;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String pPassword) {
        password = pPassword;
    }
    public boolean isRemember() {
        return remember;
    }
    public void setRemember(boolean remember) {
        this.remember = remember;
    }


    // ==================== Méthodes ====================
    /**
     * Action permettant la connexion d'un utilisateur
     * @return input / success
     */
    public String doLogin() {


        String vResult = ActionSupport.INPUT;

        if (!StringUtils.isAllEmpty(email, password)) {
            try {
                Utilisateur vUtilisateur
                        = managerFactory.getUtilisateurManager().login(email, password);
                // Ajout de l'utilisateur en session
                this.session.put("user", vUtilisateur);
                if(remember){
                    rememberMe(vUtilisateur.getId());
                }
                vResult = ActionSupport.SUCCESS;
            } catch (NotFoundException pEx) {
                this.addActionError(getText("error.login.incorrect"));
            }
        }
        return vResult;
    }


    /**
     * Action de déconnexion d'un utilisateur
     * @return success
     */
    public String doLogout() {
        // Suppression de l'utilisateur en session
        this.session.remove("user");
        this.servletRequest.getSession().invalidate();
        return ActionSupport.SUCCESS;
    }

    public void rememberMe(int vUtilisateurId) {

        Cookie cookie = new Cookie("escalade_user", String.format("%d", vUtilisateurId));
        cookie.setMaxAge(60 * 60 * 24 * 365);
        System.out.println("cookie is set");
        this.servletResponse.addCookie(cookie);
    }



    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }

    @Override
    public void setServletRequest(HttpServletRequest pRequest) {
        this.servletRequest = pRequest;
    }

    @Override
    public void setServletResponse(HttpServletResponse servletResponse) {
        this.servletResponse = servletResponse;
    }
}
