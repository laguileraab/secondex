package com.avangenio;

import java.util.List;

public class Data {
    private String name;
    private String id;
    private String city;


    public Data() {
    }

    public Data(String id, String name, String city) {
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

    public List<String> getCities() {
        return this.cities;
    }

    public void setCities(List<String> cities) {
        this.cities = cities;
    }
}
