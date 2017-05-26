package com.tahir.project.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by Tahir on 1/12/2017.
 */
@Entity
@Table(name = "animal_price", catalog = "cattlefarm")
public class AnimalPrice implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

     @Column(name = "PRICE")
     private
     float price;

    @Column(name = "VERSION")
    private
    Integer version;

    @ManyToOne ( fetch=FetchType.EAGER ) //employ lazy loading, you can put that on @OneToMany too
    @JoinColumn( name="ANIMAL_ID", nullable=false )
    private
    Animal animal;

    public AnimalPrice(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
