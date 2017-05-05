package com.tahir.project.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tahir on 1/12/2017.
 */
@Entity
@Table(name = "farm", catalog = "cattlefarm")
public class Farm implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "FARM_NAME", unique = true, nullable = false)
    private String farmName;

    @ManyToOne ( fetch=FetchType.EAGER ) //employ lazy loading, you can put that on @OneToMany too
    @JoinColumn( name="COMPANY_ID", nullable=false )
    private Company company;

    public Farm(){

    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
