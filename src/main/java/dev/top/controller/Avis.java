package dev.top.controller;


public enum Avis {

    AIMER("aime"),
    DETESTER("detester");

   
  private String name = "";
   
  //Constructeur
  Avis(String name){
    this.name = name;
  }
   
  public String toString(){
    return name;
  }
}

