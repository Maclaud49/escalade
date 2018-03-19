package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.utilisateur.Utilisateur;
import com.parlow.escalade.model.exception.NotFoundException;

import java.util.List;

public interface UtilisateurDao {

    void insert(Utilisateur utilisateur);

    Utilisateur findById(int id) throws NotFoundException;

    Utilisateur findByEmail(String email, String password) throws NotFoundException;

    List<Utilisateur> findAll();

    void delete(int utilisateurid) throws NotFoundException;
}
