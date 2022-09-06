package com.example.obSpring4RestDataJPA;

import com.example.obSpring4RestDataJPA.entities.Book;
import com.example.obSpring4RestDataJPA.repository.BookRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.time.LocalDate;



@SpringBootApplication
public class ObSpring4RestDataJpaApplication {

	public static void main(String[] args) {
//contexto y repositorio
		ApplicationContext context = SpringApplication.run(ObSpring4RestDataJpaApplication.class, args);
		BookRepository repository = context.getBean(BookRepository.class);

//CRUD
		//Crear Libro.
		Book book1 = new Book(null/*Sin id hasta que lo guardemos en bbdd y se genere automáticamente */,
				"El perfume", "Patrick Süskind", 255, 20.95d, LocalDate.of(1985, 8, 19), true );
		Book book2 = new Book(null/*idem Lin 22 */,"El Señor de los Anillos", "J.R.R. Tolkien", 523,
				29.45d, LocalDate.of(1954, 2, 11), true );

		System.out.println("Nº Libros en bbdd: "+ repository.findAll().size());//mostramos el nº de libros actuales
		//Almacenar un libro.
		repository.save(book1);
		repository.save(book2);

		//Recuperar todos los libros
		System.out.println("Nº Libros en bbdd: "+ repository.findAll().size());//mostramos el nº de libros actuales


		//Borrar un libro.
//		repository.deleteById(1l);
		System.out.println("Nº Libros en bbdd: "+ repository.findAll().size());//mostramos el nº de libros actuales

	}

}
