package com.example.obSpring3dataJPA;
//Esto lo creamos como cualquier interfaz nueva new->Java Class->Select Interface
//como convenio, se usa (nombre de la clase a ala que nos referimos)+Repository

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //Indicamos que es un repositorio y que va a ser un bean que cree un objeto de una clase conforme a CocheRepository.java
public interface CocheRepository extends JpaRepository <Coche,Long>{ //Con esto ya podremos acceder a una base de datos,
    //y hacer lo que sea: crear, guardar, modificar, eliminar
}
