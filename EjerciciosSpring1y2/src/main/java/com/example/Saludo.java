package com.example;//crear una clase com.example.Saludo con un método imprimirSaludo que imprima un texto por consola.

import org.springframework.stereotype.Component;

//Utilizar la anotación @Component en cada clase.
@Component
public class Saludo {
    public String imprimirSaludo () {
        System.out.println("Estamos dentro de Saludo.imprimirSaludo");

        return "Hola!! Este es el saludo que devuelve Saludo.java";
    }
}
