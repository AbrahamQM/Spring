package com.example;

import org.springframework.stereotype.Component;


@Component //Esto es para que nos acepte esta clase GestorFacturas.java
public class GestorFacturas {
    //Atributos
    Calculadora calculadora;


    //Constructores
    public GestorFacturas(Calculadora calculadora){
        System.out.println("Ejecutando constructor GestorFacturas");
        this.calculadora = calculadora;

    }


    //Métodos
}
