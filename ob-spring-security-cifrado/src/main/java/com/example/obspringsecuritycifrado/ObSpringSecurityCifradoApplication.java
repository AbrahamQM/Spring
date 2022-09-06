package com.example.obspringsecuritycifrado;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class ObSpringSecurityCifradoApplication {

	//Creamos el bean para codificar la password. Suele ponerse en una clase SecurityConfig aparte para los beans
	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ObSpringSecurityCifradoApplication.class, args);
		UserRepository repository = context.getBean(UserRepository.class);

		//Creamos un usuario con clave no codificada
		User user1 = new User(null, "Usuario no security", "admin");
		repository.save(user1); //La guardamos en nuestra bbdd postgreSQL


		//Creamos un usuario con clave codificada
		PasswordEncoder encoder = context.getBean(PasswordEncoder.class); //Creamos el objeto codificador

		User user = new User(null, "usuario", encoder.encode("admin"));//Le pasamos la clave codificada
		repository.save(user); //La guardamos en nuestra bbdd postgreSQL

	}

}
