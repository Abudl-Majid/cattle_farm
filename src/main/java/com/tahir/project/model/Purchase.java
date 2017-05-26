package com.tahir.project.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;

/**
 * Created by Tahir on 1/12/2017.
 */
@Entity
@Table(name = "purchase", catalog = "cattlefarm")
public class Purchase implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "PURCHASE_DATE", unique = true, nullable = false)
    private Date purchaseDate;

    public Purchase(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Date getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(Date purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
}
