package dev.top.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

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

    @PatchMapping(value = "/{pseudo}")
    public Collegue voter(@PathVariable String pseudo, @RequestBody VoteWeb action){
          return  collegueService.setActionToCollegue(pseudo, action.getAction());
    }


}