package com.example.obspringsecurity;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception { //Creado como constructores pero en override methods
        http.authorizeRequests()
                .antMatchers("/hola").permitAll()//agregamos esta línea para permitir usar /hola sin autenticarnos
                .antMatchers("/bootstrap").hasRole("ADMIN") //Con esta línea, sólo pueden acceder a / los ADMIN
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .and()
                .httpBasic(); //lin14-24 copiado de WebSecurityConfigurerAdapter.java excepto lin15 y 16
    }

    //Configuración de el firewall
    @Bean
    public HttpFirewall looseHttpFirewall(){
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowBackSlash(true);//para permitir '\'
        firewall.setAllowSemicolon(true);//para permitir ';'
        return firewall;
    }

    //Configuracion de la autenticación usuarios, contraseñas y roles
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .passwordEncoder(passwordEncoder())//En esta línea indicamos que codifique el password
                .withUser("user").password(passwordEncoder().encode("password")).roles("USER")//Hay que incluir manualmente lo que hay dentro de .password
                .and()
                .withUser("admin").password(passwordEncoder().encode("password")).roles("USER", "ADMIN");//Hay que incluir manualmente lo que hay dentro de .password

    }
    @Bean
    public PasswordEncoder passwordEncoder(){
        return  new BCryptPasswordEncoder();
    }


//
//    // Expose the UserDetailsService as a Bean
//    @Bean
//    @Override
//    public UserDetailsService userDetailsServiceBean() throws Exception {
//        return super.userDetailsServiceBean();
//    }
}
