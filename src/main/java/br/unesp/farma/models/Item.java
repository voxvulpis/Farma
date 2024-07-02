package br.unesp.farma.models;

public class Item {
    Product product;
    Integer amount;

    public Item(Product product, Integer amount) {
        this.product = product;
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
    @Override
    public String toString() {
        return amount + " x " + product.toString();
    }
}
