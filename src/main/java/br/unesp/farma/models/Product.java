package br.unesp.farma.models;

public class Product {
    int id;
    String name;
    String description;
    float weight;
    int packageUnits;
    boolean restrictSale;

    public Product(int id, String name, String description, float weight, int packageUnits, boolean restrictSale) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.weight = weight;
        this.packageUnits = packageUnits;
        this.restrictSale = restrictSale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getPackageUnits() {
        return packageUnits;
    }

    public void setPackageUnits(int packageUnits) {
        this.packageUnits = packageUnits;
    }

    public boolean isRestrictSale() {
        return restrictSale;
    }

    public void setRestrictSale(boolean restrictSale) {
        this.restrictSale = restrictSale;
    }
}
