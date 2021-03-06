package dev.top.controller;

import org.springframework.web.client.RestTemplate;

import dev.top.entities.Collegue;

public class utils {
	
	public static Collegue recupDonne( CollegueDTO c) {
		
		final String uri = "https://tommy-sjava.cleverapps.io/collegues?matricule="+c.getMatricule();
 	    System.err.println(uri);
 	    RestTemplate restTemplate = new RestTemplate();
 	    CollegueDTO [] result = restTemplate.getForObject(uri, CollegueDTO[].class);
		 
 	   Collegue collegueToAdd =   new Collegue();
 	    if(result.length==0) {
 	    throw new CollegueException("Personne ne possede ce matricule");
 	    }else {
 	    	
 	    	collegueToAdd.setAdresse(c.getAdresse());
 	    	collegueToAdd.setEmail(c.getEmail());
 	    	collegueToAdd.setPrenom(c.getPrenom());
 	    	collegueToAdd.setPseudo(c.getNom());
 	    	collegueToAdd.setScore(800);
 	    	collegueToAdd.setMatricule(c.getMatricule());
 	    	if(c.getPhoto() == null) {
 	    		collegueToAdd.setphoto(result[0].getPhoto());
 	    	}else {
 	    		collegueToAdd.setphoto(c.getPhoto());
 	    	}
		
 	    }
 	    return collegueToAdd;

	}
}
