package br.unesp.farma.models;

import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Cart {
    @NotNull
    List<Item> itemList;

    public Cart(){
        this.itemList = new ArrayList<>();
    }

    public Cart(List<Item> itemList){
        this.itemList = itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public List<Item> getItemList(){
        return itemList;
    }

    public void modItem(Product product, Integer amount){
        Iterator<Item> iterator = itemList.iterator();
        Item item;
        int i = 0;

        while (iterator.hasNext()){
            item = iterator.next();

            if(Objects.equals(item.getProduct().getId(), product.getId())){
                itemList.remove(i);

                if(amount > 0){
                    itemList.add(i, new Item(product, amount));
                    return;
                }
            }


            i++;
        }

        itemList.add(new Item(product, amount));
    }

    public String toString() {
        return "Cart with " + itemList.size() + " items";
    }
}
