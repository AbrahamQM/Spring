package com.example.obspringsecurityoauthgithub.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClient;
import org.springframework.security.oauth2.client.annotation.RegisteredOAuth2AuthorizedClient;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller //controlador mvc (no devuelve JSON, sino que te redirige a una plantilla html creada en
// resources/templates/index.html)
public class HelloController {

    @GetMapping("/")
    public String index(){
        return "index";
    }//Redirige a index.html

    @GetMapping("/page1") //ésta web está protegida por autenticación OAuth
    public String page1(Model model){
        model.addAttribute("message", "Hola desde Spring MVC!!");
        return "page1";
    }

    @GetMapping("/page2") //web protegida por OAuth, Vamos a mostrar atributos
    public String page2(Model model,
            @RegisteredOAuth2AuthorizedClient OAuth2AuthorizedClient client,
            @AuthenticationPrincipal OAuth2User user)
    {
        model.addAttribute("clientName", client.getClientRegistration().getClientName());
        model.addAttribute("userName", user.getName());
        model.addAttribute("userAttributes", user.getAttributes());
        return "page2";
    }
}
