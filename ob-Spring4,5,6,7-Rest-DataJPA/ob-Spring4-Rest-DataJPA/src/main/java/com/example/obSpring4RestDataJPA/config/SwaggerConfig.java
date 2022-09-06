package com.example.obSpring4RestDataJPA.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

//Sesión 8

/**
 * Configuración Swagger para que se genere documentación de la API REST
 *
 * En la siguiente url podremos acceder a la documentación de nuestro proyecto
 * http://localhost:8080/swagger-ui/
 */
@Configuration //Se añade en las clases de configuración
public class SwaggerConfig { //documentación de springfox swagger: http://springfox.github.io/springfox/docs/current/

    //Generamos un bean
    @Bean //Para que Spring cree este objeto Docket y lo inyecte en la dependencia que corresponda
    public Docket api(){    //Aqui vamos a configurar como se va a generar la documentación del proyecto
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiDetails()) //concatenando métodos que añadirán a la documentación all lo que le
                .select()              // pongamos aquí.
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiDetails(){ //Este método crea los detalles de la ApiInfo "La información añadida es toda inventada
        return new ApiInfo("Spring Boot book API REST", // para este ejemplo"
                "Library Api rest docs",
                "1.0",
                "http://www.google.es",
                 new Contact("Abraham", "http://www.google.es", "abraham@example.com"),
                "MIT",
                "http://www.google.es",
                Collections.emptyList());
    }
}
