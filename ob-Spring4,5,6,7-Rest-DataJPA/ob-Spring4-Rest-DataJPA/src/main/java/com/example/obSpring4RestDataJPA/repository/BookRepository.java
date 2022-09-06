package com.example.obSpring4RestDataJPA.repository;

import com.example.obSpring4RestDataJPA.entities.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//Repositorio
@Repository //para que Spring lo lea como repository
public interface BookRepository extends JpaRepository<Book, Long> {
}
