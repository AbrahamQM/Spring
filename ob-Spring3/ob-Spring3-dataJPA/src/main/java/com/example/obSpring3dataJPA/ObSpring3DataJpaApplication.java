package com.example.obSpring3dataJPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ObSpring3DataJpaApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(ObSpring3DataJpaApplication.class, args);
		CocheRepository repository = context.getBean(CocheRepository.class);

		//Comprobamos que se accede correctamente
		System.out.println("\n********Nº de coches en actualmente en bbdd: " + repository.count()); //Muestra el nº de entradas en el repositorio

		//Crear y almacenar un coche en bbdd
		Coche toyota = new Coche(null, "Prius", "Toyota", 2010 );
		repository.save(toyota);
		Coche bmw = new Coche(null, "X5", "BMW", 2007 );
		repository.save(bmw);


		System.out.println("\n********El nº de coches en bbdd es: "+ repository.count());//Para comprobar que se han añadido

		//Leer todos los coches
		System.out.println(repository.findAll());//Devuelve una lista con todos los coches

		//Leer un coche por la id (Empieza por 1)
		System.out.println(repository.findById(1L));//Devuelve el coche 1 (L porque es de tipo Long)
		System.out.println(repository.findById(2L));//Devuelve el coche 2


	}

}
