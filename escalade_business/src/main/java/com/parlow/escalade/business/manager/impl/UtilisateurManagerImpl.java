package com.parlow.escalade.business.manager.impl;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.consumer.dao.contract.UtilisateurDao;
import org.apache.commons.lang3.StringUtils;

import com.parlow.escalade.business.manager.contract.UtilisateurManager;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.NotFoundException;


@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    @Inject
    private UtilisateurDao utilisateurDao;
    @Inject
    private DaoFactory daoFactory;

    @Override
    public Utilisateur getUtilisateur(Integer pId) throws NotFoundException {
        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        if (pId < 0) {
            throw new NotFoundException("Utilisateur non trouvé : ID=" + pId);
        }
        Utilisateur vUtilisateur = daoFactory.getUtilisateurDao().findById(pId);
        return vUtilisateur;
    }

    @Override
    public Utilisateur getUtilisateur(String pLogin, String pPassword) throws NotFoundException {
        if (StringUtils.equals(pLogin, "joe") && StringUtils.equals(pPassword, "joe")) {
            return newUtilisateur("Mickael");
        }
        throw new NotFoundException("Aucun utilisateur correspondant au couple login/password fourni.");
    }


    @Override
    public List<Utilisateur> getListUtilisateur() {
        // Je n'ai pas codé la DAO, je mets juste un code pour le cours...
        List<Utilisateur> vList = new ArrayList<>();
        for (int vI = 0; vI < 9; vI++) {
            Utilisateur vUtilisateur = newUtilisateur("Mickael"+vI);
            vList.add(vUtilisateur);
        }
        return vList;
    }


    /**
     * Crée une instance d'{@link Utilisateur}
     * @param pNom -
     * @return Utilisateur
     */
    private Utilisateur newUtilisateur(String pNom) {

        Utilisateur vUtilisateur = new Utilisateur(pNom);
        vUtilisateur.setPrenom("Mac");
        return vUtilisateur;
    }

}
