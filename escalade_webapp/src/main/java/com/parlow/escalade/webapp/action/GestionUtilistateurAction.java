package com.parlow.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;

import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.NotFoundException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.inject.Inject;


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
        logger.debug("id "+ id);
        System.out.println("id "+ id);

        /*if (id == null) {
            this.addActionError("Vous devez indiquer un id d'utilisateur");
        } else {*/
            try {
                utilisateur = managerFactory.getUtilisateurManager().getUtilisateur(id);
            } catch (NotFoundException pE) {
                this.addActionError("Utilisateur non trouvé. ID = " + id);
            }
        //}

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
