package com.example;
//Crear la clase NotificationService, con un método que imprima un saludo.
//Utilizar la anotación @Component en cada clase.

import org.springframework.stereotype.Component;

@Component
public class NotificationService {
    public void imprSaludo()    {
        System.out.println("*****Este es el saludo dentro de NotificationService.java*****");
    }
}
