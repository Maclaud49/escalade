package com.parlow.escalade.business.manager.impl;

import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Named;

import com.parlow.escalade.consumer.dao.contract.DaoFactory;
import com.parlow.escalade.consumer.dao.contract.UtilisateurDao;
import com.parlow.escalade.model.exception.FunctionalException;
import org.apache.commons.lang3.StringUtils;

import com.parlow.escalade.business.manager.contract.UtilisateurManager;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.NotFoundException;


@Named
public class UtilisateurManagerImpl extends AbstractManager implements UtilisateurManager {

    @Override
    public Utilisateur findByEmail( String pEmail )throws NotFoundException{
        Utilisateur user = daoFactory.getUtilisateurDao().findByEmail(pEmail);
        if(user != null){
            return user;
        }
        else {
            throw new NotFoundException("Aucun utilisateur correspondant à cet adresse email fournie.");
        }
    }

    @Override
    public Utilisateur login(String pEmail, String pPassword) throws NotFoundException {

        Utilisateur user = daoFactory.getUtilisateurDao().findByEmailAndPassword(pEmail,pPassword);
        if(user != null){
            return user;
        }
        else {
            throw new NotFoundException("Aucun utilisateur correspondant au couple email/mot de passe fourni.");
        }
    }

    @Override
    public Utilisateur findById(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Utilisateur non trouvé : ID=" + pId);
        }
        Utilisateur vUtilisateur = daoFactory.getUtilisateurDao().findById(pId);
        return vUtilisateur;
    }

    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> vList = daoFactory.getUtilisateurDao().findAll();
        if (vList == null) {
            Utilisateur utilisateur = new Utilisateur();
            utilisateur.setId(1);
            utilisateur.setNom("Pas de données");
            vList.add(utilisateur);
        }
        return vList;
    }

    @Override
    public int insert(Utilisateur pUtilisateur) throws FunctionalException {
        if (pUtilisateur == null) {
            throw new FunctionalException("L'objet Utilisateur ne doit pas être null !");
        }
        return daoFactory.getUtilisateurDao().insert(pUtilisateur);
    }

    @Override
    public void delete(int pId) throws NotFoundException {
        if (pId < 1) {
            throw new NotFoundException("Utilisateur non trouvé : ID=" + pId);
        }
        daoFactory.getUtilisateurDao().delete(pId);
    }

    @Override
    public void update(Utilisateur pUtilisateur) throws FunctionalException {
        if (pUtilisateur == null) {
            throw new FunctionalException("L'objet Utilisateur ne doit pas être null !");
        }
        daoFactory.getUtilisateurDao().update(pUtilisateur);
    }





}
