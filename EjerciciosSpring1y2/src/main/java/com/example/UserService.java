package com.example;
//Crear una clase UserService que tenga un atributo de clase NotificationService.

import org.springframework.stereotype.Component;

@Component
public class UserService {
    NotificationService userService;

    public UserService(NotificationService userService) {
        this.userService = userService;
        System.out.println("Estamos dentro de UserService.java");
    }
}
