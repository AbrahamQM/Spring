package com.example.obSpring4RestDataJPA.controller;
//Esta es la clase va a ser un controlador de tipo REST que se va a encargar de devolver JSON

import com.example.obSpring4RestDataJPA.entities.Book;
import com.example.obSpring4RestDataJPA.repository.BookRepository;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger; //Ojo importante para el log
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;
import java.util.Optional;


@RestController  //Le indicamos que va a ser un controlador tipo REST
public class BookController {
    private final Logger log = LoggerFactory.getLogger(BookController.class); //Creamos el log para lin64
//Atributos
    private BookRepository bookRepository;  //Esto para lin36


//Constructores

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }



//Método para hacer operaciones CRUD sobre la entidad Book

  //buscar todos los libros. Devuelve una lista de libros
    @GetMapping("/api/books") //Permite vincular una URL, al entrar con navegador en localhost:8080/api/books accede a este controlador
    public List<Book> findAll(){
        return bookRepository.findAll(); //recuperar y devolver los libros
    }

  //Buscar un libro según la id
   @GetMapping("/api/books/{id}") //Con {id} le indicamos una variable
   @ApiOperation("Buscar un libro por clave primaria id Long") //Anotación para Swagger http://localhost:8080/swagger-ui/#/book-controller/findOneByIdUsingGET
   // "Añadido en sesión8 min40
   public ResponseEntity<Book> findOneById(@ApiParam("Clave primaria tipo Long") @PathVariable Long id){
        //ResponseEntity devuelve un error o un código html que le indiquemos (ok-200, not found-404,...)
        //---@ApiParam Añade una descripción de la variable id en Swagger Sesión8
       // http://localhost:8080/swagger-ui/#/book-controller/findOneByIdUsingGET
        //---@PathVariable recibe la variable{id}
        Optional <Book> bookOpt = bookRepository.findById(id);

        //Opción 1
        if (bookOpt.isPresent()){ //Comprobamos si existe
            return ResponseEntity.ok(bookOpt.get()); //Si existe devuelve ok(código 200) + el libro
       }else
            return ResponseEntity.notFound().build(); //No existe, construye un error 404(notFound)


        //Opción 2 lo mismo pero en sólo una línea
       //return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
   }

   //Crear un nuevo libro en bbdd
    @PostMapping("/api/books") //OJO (no es GetMapping), usamos @PostMapping, ya que vamos a grabar en la
    // bbdd en lugar de leer de ella
    public ResponseEntity<Book> create(@RequestBody Book book, @RequestHeader HttpHeaders headers){
       //@RequestBody extrae la información de la petición y la guarda en una clase Book que llamaremos book.
       //@RequestHeader devuelve la cabecera.
       System.out.println(headers.get("User-Agent")); //Imprimimos a consola quien es el que ha solicitado añadir libro
       if(book.getId() != null){    //Comprobamos si la id de ese libro ya existe
           log.warn("trying to create a book with id"); //Esto guardará en el log ese error. log creado en BookController
           return ResponseEntity.badRequest().build(); //Devolvería badRequest si el libro ya existe
       }
           Book result = bookRepository.save(book);
           return ResponseEntity.ok(result);//Guardar el libro recibido, en la bbdd y muestra el libro en pantalla

    }

    //Actualizar un libro existente en bbdd
    @PutMapping("/api/books")//vamos a usar PutMapping para  modificar un libro en la bbdd
    public ResponseEntity<Book> update(@RequestBody Book book){

        //Comprobamos si el libro existe o no antes de modificarlo
        if (book.getId() == null){ //Si no tiene id al llamarlo desde postman quiere decir que es una creación.
            log.warn("Trying to update a non existent book");
            return ResponseEntity.badRequest().build(); //Devolver error 400
        }
        if (!bookRepository.existsById(book.getId())){ //Si el libro NO EXISTE
                log.warn("Trying to update a non existent book");
                return ResponseEntity.notFound().build(); //Devolver 404 no encontrado
        }
        //Proceso de actualización
        Book result = bookRepository.save(book);
        return ResponseEntity.ok(result);
    }


    //Borrar un libro en bbdd
    @ApiIgnore //notación para hacer que el método delete no aparezca en la documentación por seguridad
    @DeleteMapping ("/api/books/{id}")//vamos a usar @DeleteMapping para borrar un registro de la bbdd
    public ResponseEntity<Book> delete(@PathVariable Long id){
        if (!bookRepository.existsById(id)){ //Si el libro NO EXISTE
            log.warn("Trying to delete a non existent book");
            System.out.println("Intentando eliminar un libro que no existe"); //Esto lo muestra en el Run
            return ResponseEntity.notFound().build(); //Devolver 404 no encontrado
        }
        bookRepository.deleteById(id);
        return ResponseEntity.noContent().build(); //Devuelve un aviso de que el elemento ya no existe
    }


    //Borrar todos los libros
    @ApiIgnore //notación para hacer que el método deleteAll no aparezca en la documentación por seguridad
    @DeleteMapping("api/books")
    public ResponseEntity<Book> deleteAll(){
        bookRepository.deleteAll(); //Borra all el repositorio
        log.info("REST Request for delete all");
        System.out.println("TODOS LOS LIBROS BORRADOS");
        return ResponseEntity.noContent().build(); //Devuelve que no hay contenido en la bbdd
    }

//CREAMOS TEST SESIÓN 9
    //se genera la clase Book-ControllerTest en Test/java/com.exampleob.../controller

}
