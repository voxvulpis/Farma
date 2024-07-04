package br.unesp.farma.utils;

import br.unesp.farma.models.Cart;
import br.unesp.farma.models.Item;
import br.unesp.farma.models.Product;
import br.unesp.farma.repos.People;
import br.unesp.farma.repos.Stock;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Objects;

/*
*
* This file is utilised to assist the demonstration of the software and emulate the utilities of data persistence
*
*/

public class DemonstrationUtils {
    private static final Type STOCK_TYPE = new TypeToken<Stock>() {}.getType();

    public static void startDemo(){
        Stock stock = new Stock();
        Product product = new Product(1, "Test Name 1", "Test Desc 1", 10.1f, 1.1f, 11, false);
        Product product2 = new Product(2, "Test Name 2", "Test Desc 2", 10.1f, 2.2f, 22, true);

        stock.addToStock(product);
        stock.addToStock(product2);

        try {
            stock.adjustStock(product.getId(), 101);
            stock.adjustStock(product2.getId(), 102);
        } catch (Exception e) {
//            throw new RuntimeException(e);
            System.out.println("Failed to adjust Product Stock in [startDemo]");
        }

        saveToJson(stock);
    }

    public static Stock loadStockFromJson(){
        Gson gson = new Gson();
        Stock stock = new Stock();
        File file = new File("Stock.json");

        if(file.exists()){
            try {
                stock = gson.fromJson(new FileReader(file), STOCK_TYPE);
            } catch (FileNotFoundException e) {
                System.out.println("File not found. Returning: new Stock();");
//                throw new RuntimeException(e);
            }
        }


        return stock;
    }

    public static Cart defaultCart(){
        Stock tempStock = loadStockFromJson();
        Cart cart = new Cart();



        Iterator<Item> iterator = tempStock.getStockList().iterator();
        int i = 0;

        while (iterator.hasNext()){
            Item item = iterator.next();
            cart.modItem(item.getProduct(), 2);
        }

        return cart;
    }

    public static void saveToJson(Stock stock){

        try(Writer writer = new FileWriter("Stock.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(stock, writer);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }


}
