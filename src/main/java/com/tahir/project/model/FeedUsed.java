package com.tahir.project.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Tahir on 1/12/2017.
 */
@Entity
@Table(name = "feed_used", catalog = "cattlefarm")
public class FeedUsed implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

     @Column(name = "QUANTITY")
     private
     float quantity;

    @ManyToOne ( fetch=FetchType.EAGER ) //employ lazy loading, you can put that on @OneToMany too
    @JoinColumn( name="ANIMAL_ID", nullable=false )
    private
    Animal animal;

    public FeedUsed(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }
}
