package com.formation.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.formation.metier.Utilisateur;

public class UtilisateurDaoImp implements IUtilisateurDao {

	@Override
	public boolean createUtilisateur(Utilisateur utilisateur) {
		// 1 - chargement du driver
		// 2 - Etablir connexion
		// 3 - Préparer les requêtes
		// 4 - Executer et récupérer résultats
		// 5 - Fermer connexions et libérer les ressources
		//
		// -> On voit ici les inconvennients d'utiliser directement JDBC :
		// beaucoupd de code répété
		Statement state = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver JDBC chargé pour createUtilisateur");

			String url = "jdbc:mysql://localhost:3306/global";
			String user = "root";
			String password = "";

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection effectuée");

			state = conn.createStatement();

			int result = state
					.executeUpdate("INSERT INTO `employe` (`id`, `nom`, `prenom`, `login`, `password`) VALUES ('"
							+ utilisateur.getId() + "', '" + utilisateur.getNom() + "', 'NULL', '"
							+ utilisateur.getAdresseMail() + "', '" + utilisateur.getMotDePasse() + "')");
			state.close();
			conn.close();

			if (result != 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println("ERREUR !");
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (state != null)
					state.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public Utilisateur retrieveUtilisateurAvecId(int id) {

		Statement state = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver JDBC chargé pour retrieveUtilisateurAvecId");

			String url = "jdbc:mysql://localhost:3306/global";
			String user = "root";
			String password = "";

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection effectuée");

			state = conn.createStatement();

			ResultSet result = state.executeQuery("SELECT * FROM `employe` WHERE `id`=" + id);

			if (result.next()) {
				Utilisateur foundUser = new Utilisateur();
				foundUser.setId(result.getInt("id"));
				foundUser.setNom(result.getString("nom"));
				foundUser.setAdresseMail(result.getString("login"));
				foundUser.setMotDePasse(result.getString("password"));
				state.close();
				conn.close();
				return foundUser;
			} else {
				state.close();
				conn.close();
				return null;
			}

		} catch (Exception e) {
			System.out.println("ERREUR !");
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (state != null)
					state.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public List<Utilisateur> retrieveAllUtilisateur() {

		Statement state = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver JDBC chargé pour retrieveAllUtilisateur");

			String url = "jdbc:mysql://localhost:3306/global";
			String user = "root";
			String password = "";

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection effectuée");

			state = conn.createStatement();

			ResultSet result = state.executeQuery("SELECT * FROM employe");

			Utilisateur foundUser;
			List<Utilisateur> usersList = new ArrayList<>();

			while (result.next()) {
				foundUser = new Utilisateur();
				foundUser.setId(result.getInt("id"));
				foundUser.setNom(result.getString("nom"));
				foundUser.setAdresseMail(result.getString("login"));
				foundUser.setMotDePasse(result.getString("password"));
				usersList.add(foundUser);
			}
			state.close();
			conn.close();
			return usersList;

		} catch (Exception e) {
			System.out.println("ERREUR !");
			e.printStackTrace();
			return null;
		} finally {
			try {
				if (state != null)
					state.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

	@Override
	public boolean updateUtilisateur(Utilisateur utilisateur) {

		Statement state = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver JDBC chargé pour updateUtilisateur");

			String url = "jdbc:mysql://localhost:3306/global";
			String user = "root";
			String password = "";

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection effectuée");

			state = conn.createStatement();

			int result = state.executeUpdate("UPDATE `employe` SET `nom` = '" + utilisateur.getNom() + "', `login` = '"
					+ utilisateur.getAdresseMail() + "', `password` = '" + utilisateur.getMotDePasse()
					+ "' WHERE `employe`.`id` = " + utilisateur.getId());
			state.close();
			conn.close();

			if (result != 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println("ERREUR !");
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (state != null)
					state.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	@Override
	public boolean deleteUtilisateurAvecId(int id) {

		Statement state = null;
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver JDBC chargé pour deleteUtilisateurAvecId");

			String url = "jdbc:mysql://localhost:3306/global";
			String user = "root";
			String password = "";

			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection effectuée");

			state = conn.createStatement();

			int result = state.executeUpdate("DELETE FROM `employe` WHERE `employe`.`id` =" + id);
			state.close();
			conn.close();

			if (result != 0)
				return true;
			else
				return false;

		} catch (Exception e) {
			System.out.println("ERREUR !");
			e.printStackTrace();
			return false;
		} finally {
			try {
				if (state != null)
					state.close();

				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

	}

}
