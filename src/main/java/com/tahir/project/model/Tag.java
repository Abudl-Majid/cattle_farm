package com.tahir.project.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by Tahir on 1/12/2017.
 */
@Entity
@Table(name = "tag", catalog = "cattlefarm")
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false)
    private Integer id;

    @Column(name = "TAG_NAME", unique = true, nullable = false)
    private String tagName;


    public Tag(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }
}
