package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.consumer.dao.util.DAOException;
import com.parlow.escalade.model.bean.utilisateur.Utilisateur;

import java.util.List;

public interface UtilisateurDao {

    void insert(Utilisateur utilisateur) throws DAOException;

    Utilisateur findById(int id) throws DAOException;

    List<Utilisateur> findAll() throws DAOException;

    void delete(int utilisateurid) throws DAOException;
}
