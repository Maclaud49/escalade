package com.parlow.escalade.consumer.dao.impl;

import com.parlow.escalade.consumer.dao.contract.UtilisateurDao;
import com.parlow.escalade.consumer.dao.util.DAOException;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;

import javax.inject.Named;
import java.util.List;

@Named
public class UtilisateurDaoImpl implements UtilisateurDao {
    @Override
    public void insert(Utilisateur utilisateur) throws DAOException {

    }

    @Override
    public Utilisateur findById(int id) throws DAOException {
        Utilisateur user = new Utilisateur("Parlow");
        user.setPrenom("Aimée");
        user.setId(2);

        return user;
    }

    @Override
    public List<Utilisateur> findAll() throws DAOException {
        return null;
    }

    @Override
    public void delete(int utilisateurid) throws DAOException {

    }
}
