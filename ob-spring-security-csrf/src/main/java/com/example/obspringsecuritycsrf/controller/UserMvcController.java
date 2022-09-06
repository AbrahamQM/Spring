package com.example.obspringsecuritycsrf.controller;


import com.example.obspringsecuritycsrf.DTO.UserDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Los controladores mvc, utilizan páginas html para enviar y recibir la información
 * (los controladores REST, lo hacen desde un entorno o api como postman)
 */


@Controller
public class UserMvcController {

    //1º Obtenemos el formulario en el FRONTED (HTML)
    @GetMapping("/")
    public String getForm(Model model){ //Model es una clase que está relacionado con interfaces de usuario html
        model.addAttribute("user", new UserDTO());
        System.out.println("Autenticando");
        return "user-form";
    }

    //2º Recibir el formulario con los datos rellenos
    @PostMapping("/users")
    public String save(@ModelAttribute ("user") UserDTO user){ //para recibir objetos en mvc, se usa @ModelAttribute
        //en cambio, para recibir objetos en api REST se usa @RequestBody
        System.out.println("/users save() :   " + user);
        return "congratulations";
    }
}
