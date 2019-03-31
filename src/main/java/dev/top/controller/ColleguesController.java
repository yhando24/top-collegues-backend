package dev.top.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.el.stream.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dev.top.entities.Collegue;
import dev.top.service.CollegueService;

@RestController
@RequestMapping("/collegues")
@CrossOrigin
public class ColleguesController {

    @Autowired
    private CollegueService collegueService;

    @GetMapping
    public List<Collegue> findAll() {
        return this.collegueService.findAll();
    }
    
    @GetMapping(value = "/{matricule}")
    public boolean verifMatricule(@PathVariable String matricule){
    
    	boolean exist = true;
    	Collegue col = new Collegue();
    	try {
    		col = this.collegueService.findByMatricule(matricule);
    		System.out.println("il existe");
    	}catch(CollegueException e) {
    		exist = false;
    		System.out.println("il n'existe pas");
    	}
   
    	return exist;
    		
    	
    }

    @PatchMapping(value = "/{pseudo}")
    public Collegue voter(@PathVariable String pseudo, @RequestBody VoteWeb action){
          return  collegueService.setActionToCollegue(pseudo, action.getAction());
    }
    
    @PostMapping
    public void  AjoutCollegue(@RequestBody CollegueDTO c)  {
    	System.out.println(c.getMatricule() +" 1111111111111111111111111");
    	System.out.println(c.getMatricule() +" LAAAAAAAAAAAAAAAAAAAAAAAAAA");
    	boolean exist = true;
    	Collegue col = new Collegue();
    	try {
    		col = collegueService.findByPseudo(c.getNom());
    	}catch(CollegueException e) {
    		exist = false;
    	}
   
    	if(!exist) {
    	
    		collegueService.save(utils.recupDonne(c));
    		
    	}else {
    	 throw new CollegueException("Une personne avec ce pseudo existe deja");
    	}
    	
    }
    
 
    	    		
}
  	
    



