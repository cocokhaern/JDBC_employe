package com.formation.dao;

import java.util.List;

import com.formation.metier.Utilisateur;

public interface IUtilisateurDao {

	// Opérations de CRUD

	public boolean createUtilisateur(Utilisateur utilisateur);

	public Utilisateur retrieveUtilisateurAvecId(int id);

	public List<Utilisateur> retrieveAllUtilisateur();

	public boolean updateUtilisateur(Utilisateur utilisateur);

	public boolean deleteUtilisateurAvecId(int id);

}
