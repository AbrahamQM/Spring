package com.example.obspringsecurityoauthgithub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //ClickDcho->Generate->Override Methods Elegir el que queramos sobreescribir
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Viene este método por defecto, pero es lo que vamos a cambiar: super.configure(http);
        http.antMatcher("/**") //Para hacer referencia a all el contenido "/**"
                .authorizeRequests()
                .antMatchers("/", "/login**").permitAll() //Para que nos permita acceder a la pág principal
                // y al login (porque habrá una pág de login, para hacer login normal sin OAuth)
                .anyRequest().authenticated() //Para todas las demás páginas, ya estaríamos autenticados
                .and().oauth2Login(); //ESTE ES EL MÁS IMPORTANTE!! Nos va a permitir hacer el login con el OAuth
    }


}
