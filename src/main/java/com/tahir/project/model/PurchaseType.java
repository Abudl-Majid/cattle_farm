package com.tahir.project.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tahir on 1/12/2017.
 */
@Entity
@Table(name = "purchase_type", catalog = "cattlefarm")
public class PurchaseType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "PURCHASE_TYPE")
    private String purchaseType;

    public PurchaseType(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType;
    }
}
