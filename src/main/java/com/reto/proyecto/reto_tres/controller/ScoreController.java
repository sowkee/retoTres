package com.reto.proyecto.reto_tres.controller;



import com.reto.proyecto.reto_tres.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;


@RestController

public class ScoreController {

    @Autowired
    private ScoreService scoreService;

  
 
}
