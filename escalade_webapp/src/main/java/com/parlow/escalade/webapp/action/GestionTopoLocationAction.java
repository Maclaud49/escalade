package com.parlow.escalade.webapp.action;

import com.opensymphony.xwork2.ActionSupport;
import com.parlow.escalade.business.manager.contract.ManagerFactory;
import com.parlow.escalade.model.bean.Location;
import com.parlow.escalade.model.bean.Topo;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.FunctionalException;
import com.parlow.escalade.model.exception.NotFoundException;
import com.parlow.escalade.model.exception.TechnicalException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Value;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.*;

/**
 * Action de gestion des locations de {@link Topo}
 */
public class GestionTopoLocationAction extends ActionSupport implements SessionAware {


    // ==================== Attributs ====================

    @Inject
    private ManagerFactory managerFactory;
    private Map<String, Object> session;

    private static final Logger logger = LogManager.getLogger(GestionTopoAction.class);

    // ----- Paramètres en entrée
    private Integer topoId;
    private List<Location> listTopoLocation;
    private Topo topo;
    private int locationId;



    // ==================== Getters/Setters ====================


    public Integer getTopoId() {
        return topoId;
    }
    public void setTopoId(Integer topoId) {
        this.topoId = topoId;
    }
    public List<Location> getListTopoLocation() {
        if(this.listTopoLocation==null){
            this.listTopoLocation=selectTopoLocations();
        }
        return listTopoLocation;
    }
    public void setListTopoLocation(List<Location> listTopoLocation) {
        this.listTopoLocation = listTopoLocation;
    }
    public Topo getTopo() {
        return topo;
    }
    public void setTopo(Topo topo) {
        this.topo = topo;
    }
    public Map<String, Object> getSession() {
        return session;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    // ==================== Méthodes ====================

    /**
     * Action de demande de location de {@link Topo}
     * @return success
     */
    public String doLocationRequest() {

        String vResult = ActionSupport.SUCCESS;

        if (topoId == null) {
            this.addActionError(getText("error.topo.missing.id"));
        } else {
            try {
                topo = managerFactory.getTopoManager().findById(topoId);
            } catch (NotFoundException pE) {
                this.addActionError(getText("error.topo.notfound", Collections.singletonList(topoId)));
            } catch (TechnicalException e) {
                this.addActionError(e.getMessage());
            } catch (FunctionalException e) {
                this.addActionError(e.getMessage());
            }

            topo.setDisponible(false);
            Location loc = new Location();
            Date date = new Date();
            loc.setDateDebut(new Timestamp(date.getTime()));
            Utilisateur demandeur = (Utilisateur)this.session.get("escalade_user");
            loc.setTopoLoueur(demandeur.getId());
            loc.setTopoProprio(topo.getUtilisateur().getId());
            loc.setTopo(topo);
            loc.setStatus("Demande");
            try {
                loc.setId(managerFactory.getLocationManager().insert(loc));
            } catch (FunctionalException e) {
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            } catch (TechnicalException e) {
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            }
        }
        return vResult;
    }

    private List<Location> selectTopoLocations(){
        List<Location> listLocations = new ArrayList<>();
        listLocations = managerFactory.getLocationManager().findAll();
        return listLocations;
    }

    /**
     * Action d'acceptation de location de {@link Topo}
     * @return success
     */
    public String doLocationAccept() {
        String vResult = ActionSupport.SUCCESS;

        if (locationId > 0) {
            //Récupération du Location
            Location location = new Location();
            try {
                location = managerFactory.getLocationManager().findById(locationId);
            } catch (NotFoundException e) {
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            }
            //Mise à jour du location
            location.setStatus("Acceptation");
            try {
                managerFactory.getLocationManager().update(location);
            } catch (FunctionalException e) {
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            }
            //Topo passe en non disponible
            Topo topo = location.getTopo();
            topo.setDisponible(false);
            try {
                managerFactory.getTopoManager().update(topo);
            } catch (FunctionalException e) {
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            }


        }

        return vResult;
    }

    /**
     * Action de refus de location de {@link Topo}
     * @return success
     */
    public String doLocationReject() {
        String vResult = ActionSupport.SUCCESS;

        if (locationId > 0) {
            //Récupération du Location
            Location location = new Location();
            try {
                location = managerFactory.getLocationManager().findById(locationId);
            } catch (NotFoundException e) {
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            }
            //Mise à jour du location
            location.setStatus("Refus");
            Date date = new Date();
            location.setDateFin(new Timestamp(date.getTime()));
            try {
                managerFactory.getLocationManager().update(location);
            } catch (FunctionalException e) {
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            }
            //Topo passe en disponible
            Topo topo = location.getTopo();
            topo.setDisponible(true);
            try {
                managerFactory.getTopoManager().update(topo);
            } catch (FunctionalException e) {
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            }
        }

        return vResult;
    }
    /**
     * Action de refus de location de {@link Topo}
     * @return success
     */
    public String doLocationFinish() {
        String vResult = ActionSupport.SUCCESS;

        if (locationId > 0) {
            //Récupération du Location
            Location location = new Location();
            try {
                location = managerFactory.getLocationManager().findById(locationId);
            } catch (NotFoundException e) {
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            }
            //Mise à jour du location
            location.setStatus("Clos");
            Date date = new Date();
            location.setDateFin(new Timestamp(date.getTime()));
            try {
                managerFactory.getLocationManager().update(location);
            } catch (FunctionalException e) {
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            }
            //Topo passe en disponible
            Topo topo = location.getTopo();
            topo.setDisponible(true);
            try {
                managerFactory.getTopoManager().update(topo);
            } catch (FunctionalException e) {
                this.addActionError(e.getMessage());
                vResult = ActionSupport.ERROR;
            }

        }

        return vResult;
    }


    /**
     * Action listant les {@link Location}
     * @return success
     */
    public String doLocationList() {

        this.listTopoLocation = managerFactory.getLocationManager().findAll();
        return ActionSupport.SUCCESS;
    }


    @Override
    public void setSession(Map<String, Object> pSession) {
        this.session = pSession;
    }


}
