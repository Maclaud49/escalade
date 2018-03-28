package com.parlow.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;
import java.util.Collections;


/**
 * Action de gestion des {@link Utilisateur}
 */
public class GestionUtilistateurAction extends ActionSupport {


    // ==================== Attributs ====================

    @Inject
    private ManagerFactory managerFactory;
    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private Utilisateur utilisateur;

    private static Logger logger = LogManager.getLogger();



    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public Utilisateur getUtilisateur() {
        return utilisateur;
    }


    // ==================== Méthodes ====================
    /**
     * Action affichant les détails d'un {@link Utilisateur}
     * @return success / error
     */
    public String doDetail() {

        if (id == null) {
            this.addActionError(getText("error.user.missing.id"));
        } else {
            try {
                utilisateur = managerFactory.getUtilisateurManager().findById(id);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.user.notfound", Collections.singletonList(id)));
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }

}
