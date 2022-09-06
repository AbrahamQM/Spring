package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
/*
        //Crear un objeto de la manera habitual
        Calculadora service = new Calculadora();
*/
        //CONCEPTO 1: "Cómo obtener beans de Spring
        //Ahora con Spring, recibir un objeto(bean) de Spring. Se va a hacer así:
        Calculadora calculadora = (Calculadora) context.getBean("calculadora");

        String texto = calculadora.holaMundo();
        System.out.println(texto);

        //Accedemos al objeto GestorFacturas (Sesión2)
        // CONCEPTO 2: "Cargar un bean dentro de otro bean"
        GestorFacturas gestor = (GestorFacturas) context.getBean("gestorFacturas");
        System.out.println(gestor.calculadora.holaMundo());


        //CONCEPTO 3: "Scope o alcance"
        //Los beans por defecto son scope(alcance)="singleton", se crea el objeto y se reutiliza para toda la
        //aplicación beans.xml Lin 7. Podemos cambiarlo a scope= "prototype" si queremos que se cree
        //un objeto cada vez.

    }
}
