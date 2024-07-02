package br.unesp.farma.models;

import java.util.List;

public class Cart {
    List<Item> itemList;

    public Cart(List<Item> itemList){
        this.itemList = itemList;
    }
}
