package com.example.obSpring3dataJPA;




import javax.persistence.Entity; //ojo, en breve cambiará javax... por jakarta...
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity //Convertimos la clase coche en una entidad, para que se almacenen los datos con @Entity
public class Coche {

    //Atributos encapsulados (private)
    @Id //Con eso le indicamos que id va a ser la clave primaria que se usa como referencia de cada coche.
    @GeneratedValue(strategy = GenerationType.IDENTITY)//Esto le asigna automáticamente un numero a la id
    private Long id; //ponemos Long en lugar de long para que se cree una clase envoltorio que permita null hasta que lo inicialicemos

    private String model;
    private String manufacturer;
    private Integer year;

    //Constructores. Click dcho->generate->Constructor select none y select all

    public Coche() {
    }

    public Coche(Long id, String model, String manofacturer, Integer year) {
        this.id = id;
        this.model = model;
        this.manufacturer = manofacturer;
        this.year = year;
    }

    //Getter y setter. Click dcho->generate->getter y setter->select all

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    //toString. Para que podamos imprimir una versión en texto de los atributos de la clase en el terminal
    //Click dcho->Generate->toString


    @Override
    public String toString() {
        return "Coche{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", year=" + year +
                '}';
    }
}
