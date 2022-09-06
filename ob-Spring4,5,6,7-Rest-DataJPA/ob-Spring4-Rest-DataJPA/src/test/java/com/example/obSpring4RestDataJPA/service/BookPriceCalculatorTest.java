package com.example.obSpring4RestDataJPA.service;

import com.example.obSpring4RestDataJPA.entities.Book;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Test generado en: src/main/java/com/example/obSpring4RestDataJPA/service/BookPriceCalculator.java
 * se crea como los constructores o los getter y setter
 * ClickDcho->Generate->test (seleccionar los métodos que queramos testear)
 */
class BookPriceCalculatorTest {

    @Test
    void calculatePriceTest() {
//configuración del test:

    //Creamos un libro ficticio para pasárselo a calculator.calculatePrice(book); Lin 27
        Book book = new Book(1l, "El Señor De Los Anillos", "JRR Tolkien", 1000, 49.99, LocalDate.now(), true);

    //Creamos un objeto de la clase a testear
        BookPriceCalculator calculator = new BookPriceCalculator();

    //Se ejecuta el comportamiento a testear (le pasamos el libro ficticio para que lo pruebe)
        double price = calculator.calculatePrice(book);

        //Imprimimos el resultado (Es opcional)
        System.out.println(price);

    //Comprobamos aserciones
        assertTrue(price>0);
        //assertTrue(price<0); Si pusiéramos esto, nos mostraría el fallo en terminal
        assertEquals(57.980000000000004, price);

    }
}