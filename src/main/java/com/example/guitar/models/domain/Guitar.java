package com.example.guitar.models.domain;

public class Guitar {

    private String brand;
    private String model;


    public Guitar(String brand, String model) {

        this.brand = brand;
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
