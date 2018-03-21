package com.parlow.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.Profil;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class RegisterAction extends ActionSupport implements ServletRequestAware, SessionAware {

    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;
    private Map<String, Object> session;
    private HttpServletRequest servletRequest;

    private static final Logger logger = LogManager.getLogger(RegisterAction.class);

    // ----- Paramètres en entrée
    private String email;
    private String password;
    private String password2;
    private String nom;
    private String prenom;

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
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getPassword2() {
        return password2;
    }

    public void setPassword2(String password2) {
        this.password2 = password2;
    }
    // ==================== Méthodes ====================

    /**
     * Action permettant l'enregistrement d'un utilisateur
     * @return input / success
     */
    public String doRegister() {
        String vResult = ActionSupport.INPUT;
        if (!StringUtils.isAllEmpty(nom, prenom, email, password)) {
            Utilisateur vUtilisateur = new Utilisateur();
            vUtilisateur.setNom(nom);
            vUtilisateur.setPrenom(prenom);
            vUtilisateur.setEmail(email);
            vUtilisateur.setPassword(password);
            Profil vProfil = new Profil();
            vProfil.setId(1);
            vUtilisateur.setProfil(vProfil);
            try {
                int id = managerFactory.getUtilisateurManager().insert(vUtilisateur);
                // Ajout de l'utilisateur en session
                logger.debug("id" + id);
                vUtilisateur.setId(id);
                logger.debug("nom" + vUtilisateur.getNom());
                this.session.put("user", vUtilisateur);
                vResult = ActionSupport.SUCCESS;
            } catch (FunctionalException e) {
                this.addActionError(getText("problème technique"));
            }
        }
        return vResult;
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
