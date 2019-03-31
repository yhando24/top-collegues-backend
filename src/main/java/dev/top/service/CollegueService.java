package dev.top.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.top.controller.Avis;
import dev.top.controller.CollegueException;
import dev.top.controller.VoteWeb;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@Service
public class CollegueService {

    private CollegueRepo collegueRepo;

    public CollegueService(CollegueRepo collegueRepo){
        this.collegueRepo = collegueRepo;
    }


    public Collegue save(Collegue collegue){
        collegueRepo.save(collegue);
        return collegue;
    }


    
    public Optional<Collegue> findById(Long id) {
        return collegueRepo.findById(id);
    }

    public List<Collegue> findAll() {
        return collegueRepo.findAll();
    }
    
    
    public Collegue findByPseudo(String pseudo) {
        return collegueRepo.findByPseudo(pseudo).orElseThrow(() -> new CollegueException("Personne n'existe dans la base avec ce pseudo "));
    
    }
    @Transactional
    public Collegue setActionToCollegue(String pseudo, Avis action) {
        Collegue c = collegueRepo.findByPseudo(pseudo).orElseThrow(() -> new RuntimeException("ddd"));

        if(action.equals(Avis.AIMER)){
            c.setScore(c.getScore()+10) ;
     
        }else{
            c.setScore(c.getScore() - 5);
         
        }
 
        return c;
    }


	public Collegue findByMatricule(String matricule) {
	      return collegueRepo.findByMatricule(matricule).orElseThrow(() -> new CollegueException("Personne n'existe dans la base avec ce matricule "));
	}
  
}