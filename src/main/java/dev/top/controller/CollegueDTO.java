package dev.top.controller;

public class CollegueDTO {
		
	
	 private String matricule;
	 private String nom;

	 private String photo;
	 
	 private String prenom;
	 
	 private String email;
	 
	 public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresse() {
		return Adresse;
	}

	public void setAdresse(String adresse) {
		Adresse = adresse;
	}

	private String Adresse;

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Override
	public String toString() {
		return "CollegueDTO [matricule=" + matricule + ", nom=" + nom + ", photo=" + photo + "]";
	}
	 
	 
	 
	 
	 
	 
	 
	 
	 
}



