package br.unesp.farma.models;

import jakarta.validation.constraints.NotNull;

public class Product {
    @NotNull
    private Integer id;
    @NotNull
    private String name;
    private String description;
    @NotNull
    private Float price;
    private Float weight;
    @NotNull
    private Integer packageUnits;
    @NotNull
    private Boolean restrictSale;

    public Product(int id, String name, String description, Float price, Float weight, Integer packageUnits, Boolean restrictSale) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.weight = weight;
        this.packageUnits = packageUnits;
        this.restrictSale = restrictSale;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getWeight() {
        return weight;
    }

    public void setWeight(Float weight) {
        this.weight = weight;
    }

    public Integer getPackageUnits() {
        return packageUnits;
    }

    public void setPackageUnits(Integer packageUnits) {
        this.packageUnits = packageUnits;
    }

    public Boolean getRestrictSale() {
        return restrictSale;
    }

    public void setRestrictSale(Boolean restrictSale) {
        this.restrictSale = restrictSale;
    }

    @Override
    public String toString() {
        return name;
    }
}
