package com.formation.presentation;

import java.util.List;
import java.util.Scanner;

import com.formation.dao.IUtilisateurDao;
import com.formation.metier.Utilisateur;

public class UtilisateurViewImp implements IUtilisateurView {

	private static Scanner sc = new Scanner(System.in);
	IUtilisateurDao dao;

	public UtilisateurViewImp(IUtilisateurDao dao) {
		super();
		this.dao = dao;
	}

	@Override
	public void createUtilisateurView() {
		System.out.println("\n-------\nCréer un utilisateur :\n");

		System.out.println("ID :");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Nom :");
		String nom = sc.nextLine();

		System.out.println("Login :");
		String adresseMail = sc.nextLine();

		System.out.println("Mot de passe :");
		String motDePasse = sc.nextLine();

		Utilisateur user = new Utilisateur(id, nom, adresseMail, motDePasse);
		System.out.println("\n" + user);

		boolean utilisateurCréé = dao.createUtilisateur(user);

		if (utilisateurCréé)
			System.out.println("\n=> Utilisateur créé!");
		else
			System.out.println("\n)=> Erreur à la création");

	}

	@Override
	public void retrieveUtilisateurAvecIdView() {
		System.out.println("\n-------\nRetrouver un utilisateur :\n");

		System.out.println("ID :");
		Utilisateur user = dao.retrieveUtilisateurAvecId(sc.nextInt());
		System.out.println("\n" + user);
	}

	@Override
	public void retrieveAllUtilisateurView() {
		System.out.println("\n-------\nRetrouver tous les utilisateurs :\n");
		List<Utilisateur> usersList = dao.retrieveAllUtilisateur();

		if (usersList.isEmpty())
			System.out.println("\nLa BDD est vide !");
		else {
			for (Utilisateur user : usersList)
				System.out.println("- \t" + user);
		}
	}

	@Override
	public void updateUtilisateurView() {
		System.out.println("\n-------\nMettre à jour un utilisateur :\n");

		System.out.println("ID :");
		int id = sc.nextInt();
		sc.nextLine();

		System.out.println("Nom :");
		String nom = sc.nextLine();

		System.out.println("Login :");
		String adresseMail = sc.nextLine();

		System.out.println("Mot de passe :");
		String motDePasse = sc.nextLine();

		Utilisateur user = new Utilisateur(id, nom, adresseMail, motDePasse);
		System.out.println("\n" + user);

		boolean utilisateurMisAJour = dao.updateUtilisateur(user);

		if (utilisateurMisAJour)
			System.out.println("\n=> Utilisateur mis à jour!");
		else
			System.out.println("\n)=> Erreur à la mise à jour update");
	}

	@Override
	public void deleteUtilisateurAvecIdView() {
		System.out.println("\n-------\nSupprimer un utilisateur :\n");
		System.out.println("ID :");
		System.out.println(dao.deleteUtilisateurAvecId(sc.nextInt()));
	}

}
