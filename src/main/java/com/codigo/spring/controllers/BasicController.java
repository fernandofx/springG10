package com.codigo.spring.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BasicController {

    @GetMapping("/hola")
    public String holaMethos(){
        return "Hola";
    }



    @GetMapping("/adios")
    public String adiosMethos(){
        return "Hola";
    }
}
