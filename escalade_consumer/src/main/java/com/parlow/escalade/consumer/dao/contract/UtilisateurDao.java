package com.parlow.escalade.consumer.dao.contract;

import com.parlow.escalade.model.bean.utilisateur.Utilisateur;

import java.util.List;

public interface UtilisateurDao {

    void insert(Utilisateur utilisateur);

    Utilisateur findById(int id);

    Utilisateur findByEmail(String email, String password);

    List<Utilisateur> findAll();

    void delete(int utilisateurid);
}
