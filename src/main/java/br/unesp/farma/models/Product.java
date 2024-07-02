package br.unesp.farma.models;

public class Product {
    Integer id;
    String name;
    String description;
    Float weight;
    Integer packageUnits;
    Boolean restrictSale;

    public Product(Integer id, String name, String description, Float weight, Integer packageUnits, Boolean restrictSale) {
        this.id = id;
        this.name = name;
        this.description = description;
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
}
