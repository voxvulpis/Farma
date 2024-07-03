package br.unesp.farma.models;

import java.util.List;

public class Cart {
    List<Item> itemList;

    public Cart(List<Item> itemList){
        this.itemList = itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList(){
        return itemList;
    }

    public String toString() {
        return "Cart with " + itemList.size() + " items";
    }
}
