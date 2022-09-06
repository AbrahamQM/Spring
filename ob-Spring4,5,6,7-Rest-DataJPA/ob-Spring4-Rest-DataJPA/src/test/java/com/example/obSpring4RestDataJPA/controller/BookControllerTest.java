package com.example.obSpring4RestDataJPA.controller;

import com.example.obSpring4RestDataJPA.entities.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.*;

import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

/**
 * SESIÓN 9 TEST
 * Lo importante de esta sesión es quedarse con el concepto de los test y el método general:
 * >>configurar la prueba<< creando las entidades que necesitemos
 * >>Ejecutar el comportamiento a testear<<
 * >>Comprobaciones "Aserciones"<<
 */

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class BookControllerTest {

    private TestRestTemplate testRestTemplate;

    @Autowired
    private RestTemplateBuilder restTemplateBuilder;

    @LocalServerPort //Le asigna a port el puerto local que se está usando
    private int port;

    @BeforeEach //Creado con ClickDcho->generate-SetUp Method
    void setUp() {
        restTemplateBuilder = restTemplateBuilder.rootUri("http://localhost:" + port);
        testRestTemplate = new TestRestTemplate(restTemplateBuilder);
    }

    @DisplayName("Comprobar holaMundo, desde controladores Spring REST") //Esta línea muestra el nombre del test
    @Test
    void hello() {
       ResponseEntity<String> response = testRestTemplate.getForEntity("/hola", String.class); //getForEntity, lanza
        //una petición http a la url: Localhost:puerto/hola

        //assertEquals comprueba que algo es igual a algo
       assertEquals(HttpStatus.OK, response.getStatusCode()); //Comprobamos que el código Http devuelto es ok
       assertEquals("Hola a todos y todas", response.getBody()); //Comprobamos que el body devuelve el texto
        //que hemos indicado en la función holaMundo
    }

    @DisplayName("Comprobar findAll, desde controladores Spring REST")
    @Test
    void findAll() {
        // Creamos una ResponseEntity <con array de libros> llamada response, y le asignamos el resultado de la llamada
        // a /api/books que devuelve un array de libros (.class le resuelve el tipo de elemento que es Book[])
        ResponseEntity<Book[]> response = testRestTemplate.getForEntity("/api/books", Book[].class);
        assertEquals(HttpStatus.OK, response.getStatusCode()); /**Esto es lo mismo que poner:  assertEquals(200, response.getStatusCodeValue());**/

        //Obtenemos los libros en una List<Book>
        List<Book> books = Arrays.asList(response.getBody()); //Arrays.asList se encarga de convertir un (array[]) normal a ArrayList
        System.out.println(books.size());//Imprimimos el nº de libros en consola
    }

    @DisplayName("Comprobar findByID, desde controladores Spring REST")
    @Test
    void findOneById() {
        ResponseEntity<Book> response = testRestTemplate.getForEntity("/api/books/1", Book.class); //getForEntity, lanza
        //una petición http a la url: Localhost:puerto/api/books/{1}

        //assertEquals comprueba que algo es igual a algo
        assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode()); // Comprobamos que no hay libros


    }

    @DisplayName("Comprobar create(Añadir libro nuevo), desde controladores Spring REST")
    @Test
    void create() {
        HttpHeaders headers = new HttpHeaders(); //Creamos cabeceras para poder trabajar con ellas
        headers.setContentType(MediaType.APPLICATION_JSON); //setContentType para indicarle la aplicación es json
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON)); //setAccept para indicarle que tipo de elementos acepta
        
        //Copiamos el código JSON que pusimos en postman para añadir un libro y modificamos lo que queramos
        String json = """ 
                {
                    "title": "Libro añadido desde SpringTest de create()",
                    "author": "Yo Mismo",
                    "pages": 500,
                    "price": 25.25,
                    "releaseDate": "1987-12-11",
                    "online": false
                }
                """;
        //Creamos una request de tipo http que envíe el String json creado arriba
        HttpEntity<String> request = new HttpEntity<>(json, headers);

        //Comprobamos cosas con la request y si funciona, le asignamos el nuevo libro a response
        ResponseEntity<Book> response = testRestTemplate.exchange("/api/books", HttpMethod.POST, request, Book.class);

        //Creamos una clase Book que se va a llamar result y le asignamos el cuerpo de response
        Book result = response.getBody();

        //Realizamos los assertEquals
        assertEquals(1L, result.getId()); // comprobamos que el libro creado tiene la id 1
        assertEquals("Libro añadido desde SpringTest de create()", result.getTitle()); // comprobamos que el
        // libro creado tiene el nombre indicado desde json

    }


}