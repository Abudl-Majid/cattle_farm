package com.tahir.project.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tahir on 1/12/2017.
 */
@Entity
@Table(name = "stock", catalog = "cattlefarm")
public class Stock implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "QTY_IN_HAND")
    private String qtyInHand;

    @ManyToOne ( fetch=FetchType.EAGER ) //employ lazy loading, you can put that on @OneToMany too
    @JoinColumn( name="PRODUCT_ID", nullable=false )
    private Product product;

    public Stock(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getQtyInHand() {
        return qtyInHand;
    }

    public void setQtyInHand(String qtyInHand) {
        this.qtyInHand = qtyInHand;
    }
}
