package com.example.obspringsecuritycifrado;

import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.argon2.Argon2PasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.*;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class EncryptionTest {

    /**
     * BCrypt genera su propio "salt" de 16 bytes
     *
     * El resultado de cifrar con Bcrypt será un String de 60 caracteres
     *
     * $a versión
     * $10 fuerza (se puede modificar, es un valor que va de 4 a 31. por defecto es 10)
     * Los 22 siguientes caracteres son el salt generado
     *
     */

    @Test
    void bcryptTest(){
    //Creamos un objeto de clave encriptada BCrypt
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
    //encode (codificar)
        String hashedPassword = passwordEncoder.encode("admin"); //admin es un ejemplo de contraseña
        System.out.println(hashedPassword); //Imprimimos la clave admin codificada
        //devuelve esto: $2a$10$HRUjIHIfkqi7pXM1TCQ9b.ushDABTEQ35j6KigfyuTh7U.A0GUjY.
        //Pero si lo ejecutamos de nuevo, al cambiar el "salt", cambia también la clave:
        //$2a$10$f7Ft5AAa.ctuphnsQ.MYfOQIMm7t7w5uXrh.WfoQHxNpH.awZWuSK

    //match (Comprobar que corresponde)
        boolean matches = passwordEncoder.matches("admin", hashedPassword ); //Le pasamos la contraseña sin codificar y
        // la contraseña codificada, Va a devolver un boolean
        System.out.println(matches);

    }

//Así podemos ver como cada vez que encriptamos, da una clave diferente debido al "salt"
    @Test
    void bcryptCheckMultiplePasswords(){
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        for (int i = 0; i<30; i++){
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

//Ahora podemos comprobar como codifica el algoritmo PBKDF2
    @Test
    void pbkdf2() {
        //Creamos un objeto de clave encriptada PBKDF2
        Pbkdf2PasswordEncoder passwordEncoder = new Pbkdf2PasswordEncoder();

           for (int i = 0; i<30; i++){
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

//Ahora podemos comprobar como codifica el algoritmo ARGON2
    @Test
    void argon() {
        //Creamos un objeto de clave encriptada Argon2
        Argon2PasswordEncoder passwordEncoder = new Argon2PasswordEncoder();

           for (int i = 0; i<30; i++){
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

//Ahora podemos comprobar como codifica el algoritmo Scrypt
    @Test
    void scrypt() {
        //Creamos un objeto de clave encriptada Scrypt
        SCryptPasswordEncoder passwordEncoder = new SCryptPasswordEncoder();

           for (int i = 0; i<30; i++){
            System.out.println(passwordEncoder.encode("admin"));
        }
    }

//Usaremos la Clase"DelegatingPasswordEncoder" para pasarle un mapa con los protocolos de codificación que queramos.
//Así en caso de querer cambiar el protocolo de codificación, sólo habría que añadirlo al mapa y modificar la clave al
//crear el objeto "PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("Clave", encoders);"

    @Test
    void springPasswordEncoders(){
        //Creamos un mapa de encoders para pasárselo como parámetro a DelegatingPasswordEncoder("ideForEncode", mapa de encoders)
        Map<String, PasswordEncoder> encoders = new HashMap<>();
        // Vamos añadiendo protocolos a nuestro mapa
        encoders.put("bcrypt", new BCryptPasswordEncoder());
        encoders.put("pbkdf2", new Pbkdf2PasswordEncoder());
        encoders.put("argon2", new Argon2PasswordEncoder());
        encoders.put("scrypt", new SCryptPasswordEncoder());
        encoders.put("noop", NoOpPasswordEncoder.getInstance()); //este está deprecado "Deprecated" porque ya no es seguro
        encoders.put("sha256", new StandardPasswordEncoder()); //este está deprecado "Deprecated" porque ya no es seguro
        /**
         *  Creamos el objeto passwordEncoder,
         *  Cambiando sólo la clave "idForEncode" de DelegatingPasswordEncoder,
         *  Cambiaríamos el protocolo con el que vamos a codificar las claves
         */
        PasswordEncoder passwordEncoder = new DelegatingPasswordEncoder("bcrypt", encoders);

        String hashedPassword = passwordEncoder.encode("admin");
        System.out.println(hashedPassword); //Imprimimos {clave de protocolo}clave encriptada


    }

}
