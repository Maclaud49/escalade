package com.parlow.escalade.webapp.action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.Site;
import com.parlow.escalade.model.exception.NotFoundException;


import javax.inject.Inject;


/**
 * Action de gestion des {@link Site}
 */
public class GestionSiteAction extends ActionSupport {




    // ==================== Attributs ====================
    @Inject
    private ManagerFactory managerFactory;

    // ----- Paramètres en entrée
    private Integer id;

    // ----- Eléments en sortie
    private List<Site> listSite;
    private Site site;




    // ==================== Getters/Setters ====================
    public Integer getId() {
        return id;
    }
    public void setId(Integer pId) {
        id = pId;
    }
    public List<Site> getListSite() {
        return listSite;
    }
    public Site getSite() {
        return site;
    }


    // ==================== Méthodes ====================
    /**
     * Action listant les {@link Site}
     * @return success
     */
    public String doList() {
        listSite = managerFactory.getSiteManager().getListSite();
        return ActionSupport.SUCCESS;
    }


    /**
     * Action affichant les détails d'un {@link Site}
     * @return success / error
     */
    public String doDetail() {
        if (id == null) {
            this.addActionError("Vous devez indiquer un id de site");
        } else {
            try {
                site = managerFactory.getSiteManager().getSite(id);
            } catch (NotFoundException pE) {
                this.addActionError("Site non trouvé. ID = " + id);
            }
        }

        return (this.hasErrors()) ? ActionSupport.ERROR : ActionSupport.SUCCESS;
    }
}
