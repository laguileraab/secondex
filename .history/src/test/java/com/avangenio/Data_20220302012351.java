package com.avangenio;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

public class Data {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Integer id_data;
    @Column(name = "NAME")
    private String name;
    @Column(name = "id")
    private String id;
    @Column(name = "city")
    private String city;

    public Data() {
    }

    public Data(String name, String city, String id) {
        this.name = name;
        this.id = id;
        this.city = city;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
