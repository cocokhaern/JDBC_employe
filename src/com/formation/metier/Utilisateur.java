package com.formation.metier;

public class Utilisateur {
	private int id;
	private String nom;
	private String adresseMail;
	private String motDePasse;
	
	public Utilisateur() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Utilisateur(int id, String nom, String adresseMail, String motDePasse) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresseMail = adresseMail;
		this.motDePasse = motDePasse;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getAdresseMail() {
		return adresseMail;
	}

	public void setAdresseMail(String adresseMail) {
		this.adresseMail = adresseMail;
	}

	public String getMotDePasse() {
		return motDePasse;
	}

	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", nom=" + nom + ", adresseMail=" + adresseMail + ", motDePasse=" + motDePasse
				+ "]";
	}
	
	
}
