package com.example.obspringsecuritycifrado;

import javax.persistence.*;

@Entity
@Table(name="ob_user") //Añadimos un prefijo para evitar problemas con la base de datos prostgreSQL que ya tiene una tabla de user
public class User {
    //Atributos
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Para que genere automáticamente el id
    private Long id;
    private String username;
    private String password;

    //Constructor
    public User(){

    }

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    //Getter y setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
