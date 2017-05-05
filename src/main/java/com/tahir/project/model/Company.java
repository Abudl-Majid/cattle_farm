package com.tahir.project.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tahir on 1/12/2017.
 */
@Entity
@Table(name = "company", catalog = "cattlefarm")
public class Company implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "COMPANY_NAME", unique = true, nullable = false)
    private String companyName;
    public Company(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
