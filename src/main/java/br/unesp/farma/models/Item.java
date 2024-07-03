package br.unesp.farma.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class Item {
    @NotNull
    private Product product;
    @NotNull
    private Integer amount;

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
