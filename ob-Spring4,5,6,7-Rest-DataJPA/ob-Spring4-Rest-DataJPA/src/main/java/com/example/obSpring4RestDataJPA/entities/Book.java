package com.example.obSpring4RestDataJPA.entities;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.time.LocalDate;

@Entity //Esto es para que se almacene en bbdd javax.persistence.Entity como una tabla de elementos
@Table(name = "books") //Esto es para que al generar la bbdd, tenga ese nombre "books"
@ApiModel("Book: Entidad Libro para representar un elemento de tipo libro con sus atributos") //Para Swagger /models / book...
public class Book {

    //Atributos
    @Id //Esto es para agregarle un identificador a cada uno de los objetos Book
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Estrategia de generación de Id
    @ApiModelProperty("Clave ficticia autoincremental tipo Long") //Para Swagger /models /book
    private Long id; //private para que estén encapsulados
    private String title;
    private String author;
    private Integer pages;
    @ApiModelProperty("Precio en €, con dos decimales. Utilizando . como separador ")//Para Swagger /models /book
    private Double price;
    private LocalDate releaseDate; //Fecha de lanzamiento
    private Boolean online;



    //Constructores

    public Book() {
    }

    public Book(Long id, String title, String author, Integer pages, Double price, LocalDate releaseDate, Boolean online) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
        this.releaseDate = releaseDate;
        this.online = online;
    }

    //Getter y Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Boolean getOnline() {
        return online;
    }

    public void setOnline(Boolean online) {
        this.online = online;
    }



}
