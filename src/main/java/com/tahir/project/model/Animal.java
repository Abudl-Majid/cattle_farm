package com.tahir.project.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

/**
 * Created by Tahir on 1/12/2017.
 */
@Entity
@Table(name = "animal", catalog = "cattlefarm")
public class Animal implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "ANIMAL_NAME")
    private String animalName;

     @Column(name = "ANIMAL_INITIAL_PRICE")
     private
     float animalInitialPrice;

    @Column(name = "BIRTH_DATE")
    private
    Date birthDate;

    @Column(name = "BIRTH_WEIGHT")
    private
    float birthWeight;


    @ManyToOne ( fetch=FetchType.EAGER ) //employ lazy loading, you can put that on @OneToMany too
    @JoinColumn( name="FARM_ID", nullable=false )
    private Farm farm;

    @ManyToOne ( fetch=FetchType.EAGER ) //employ lazy loading, you can put that on @OneToMany too
    @JoinColumn( name="TAG_ID", nullable=false )
    private Tag tag;

    @ManyToOne ( fetch=FetchType.EAGER ) //employ lazy loading, you can put that on @OneToMany too
    @JoinColumn( name="PURCHASE_ID", nullable=false )
    private
    Purchase initialPurchase;


    public Animal(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getAnimalName() {
        return animalName;
    }

    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }

    public float getAnimalInitialPrice() {
        return animalInitialPrice;
    }

    public void setAnimalInitialPrice(float animalInitialPrice) {
        this.animalInitialPrice = animalInitialPrice;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public float getBirthWeight() {
        return birthWeight;
    }

    public void setBirthWeight(float birthWeight) {
        this.birthWeight = birthWeight;
    }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Purchase getInitialPurchase() {
        return initialPurchase;
    }

    public void setInitialPurchase(Purchase initialPurchase) {
        this.initialPurchase = initialPurchase;
    }
}
