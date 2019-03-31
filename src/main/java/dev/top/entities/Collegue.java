package dev.top.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Collegue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private Integer id;

    private String pseudo;
    private Integer score;

    private String photoUrl;
    
    private String matricule;



    public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public Collegue(Integer id, Integer score, String photo, String pseudo, String matricule) {
        
        this.id = id;
        this.score = score;
        this.photoUrl = photo;
        this.pseudo = pseudo;
        this.matricule = matricule;
        
       }
    
   public Collegue(String photo, String pseudo) {
        
    
        this.score = 800;
        this.photoUrl = photo;
        this.pseudo = pseudo;    
        
       }

       public Collegue() {
    }
    public Collegue(String nom) {
		// TODO Auto-generated constructor stub
    	  this.score = 800;
    	   this.pseudo = nom;    
	}

	/**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the score
     */
    public Integer getScore() {
        return score;
    }

    /**
     * @param score the score to set
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * @return the photo
     */
    public String getphotoUrl() {
        return photoUrl;
    }

    /**
     * @param photo the photo to set
     */
    public void setphotoUrl(String photo) {
        this.photoUrl = photo;
    }

    /**
     * @return the pseudo
     */
    public String getPseudo() {
        return pseudo;
    }

    /**
     * @param pseudo the pseudo to set
     */
    public void setPseudo(String pseudo) {
        this.pseudo = pseudo;
    }

	@Override
	public String toString() {
		return "Collegue [id=" + id + ", pseudo=" + pseudo + ", score=" + score + ", photoUrl=" + photoUrl + "]";
	}
    
    
}
