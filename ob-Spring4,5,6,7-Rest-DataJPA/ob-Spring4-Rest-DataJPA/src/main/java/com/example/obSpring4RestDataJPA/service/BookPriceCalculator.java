package com.example.obSpring4RestDataJPA.service;
/****Hemos creado esta clase en sesión 9 para hacer testing sobre ella****/
import com.example.obSpring4RestDataJPA.entities.Book;

public class BookPriceCalculator {
    public double calculatePrice(Book book){
        double price = book.getPrice();
        if(book.getPages() > 300){ //Cargo extra si el libro tiene más de 300 páginas
            price +=5;
        }
        //envío
        price += 2.99; //Le añadimos los gastos de envío
        return price;
        /**
         * Ver como crear el test en:
         * src/test/java/com/example/obSpring4RestDataJPA/ObSpring4RestDataJpaApplicationTests.java
         *  * se crea como los constructores o los getter y setter
         *  * ClickDcho->Generate->test (seleccionar los métodos que queramos testear)
         */
    }
}
