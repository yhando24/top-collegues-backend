package dev.top.controller;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController{

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity <?> erreur(Throwable ex){
        return ResponseEntity.badRequest().body(ex.getMessage());
    }
    
}