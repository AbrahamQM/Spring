package com.example.obspringsecuritycsrf.controller;

import com.example.obspringsecuritycsrf.DTO.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Los controladores REST, lo hacen desde un entorno o api como postman
 * (Los controladores mvc, utilizan páginas html (Con formularios) para enviar y recibir la información)
 *
 */

@RestController
public class UserRESTController {
    //URL autenticación NO NECESARIA ->SecurityConfig
    @GetMapping("/api/hola")
    public String hola(){
        return "Hola Mundo";
    }


    //URLs Autenticación NECESARIA ->SecurityConfig
    @GetMapping("/api/adios")
    public String adios(){
        return "Good by WORLD";
    }


    @PostMapping("/api/users")
    public String save(@RequestBody UserDTO user){ //Para recibir objetos en api REST se usa @RequestBody
        System.out.println(user);
        return "OK";
    }
}
