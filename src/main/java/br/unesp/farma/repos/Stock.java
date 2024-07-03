package br.unesp.farma.repos;

import br.unesp.farma.models.Item;
import br.unesp.farma.models.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class Stock {
    private List<Item> stockList;

    public Stock() {
        stockList = new ArrayList<>();
    }

    public List<Item> getStockList() {
        return stockList;
    }

    public void setStockList(List<Item> stockList) {
        this.stockList = stockList;
    }

//    public int findItemByProduct(Item item){
////        return stockList.stream().filter(newItem -> )
//    }

    public void adjustStock(Integer id, Integer amount) throws Exception{
        Iterator<Item> iterator = stockList.iterator();
        int i = 0;

        while (iterator.hasNext()){
            Item item = iterator.next();
            if(Objects.equals(item.getProduct().getId(), id)){
                item.setAmount(amount);
                if(item.getAmount() < 0) item.setAmount(0);
                stockList.remove(i);
                stockList.add(i, item);
                return;
            }
            i++;
        }


        throw new Exception("There is no Item with this Id");
    }

    public void sellItem(Integer id, Integer amount) throws Exception{
        Iterator<Item> iterator = stockList.iterator();
        int i = 0;

        while (iterator.hasNext()){
            Item item = iterator.next();
            if(Objects.equals(item.getProduct().getId(), id)){
                item.setAmount(item.getAmount() - amount);
                if(item.getAmount() < 0) item.setAmount(0);
                stockList.remove(i);
                stockList.add(i, item);
                return;
            }
            i++;
        }


        throw new Exception("There is no Item with this Id");
    }

    public void addToStock(Product product){
        stockList.add(new Item(product, 0));
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        Iterator<Item> iterator = stockList.iterator();

        stringBuilder.append("\n");

        while (iterator.hasNext()){
            Item item = iterator.next();
            stringBuilder.append("\t");
            stringBuilder.append(item.getProduct().getId());
            stringBuilder.append("\t");
            stringBuilder.append(item.getProduct().getName());
            stringBuilder.append("\t");
            stringBuilder.append(item.getProduct().getDescription());
            stringBuilder.append("\t");
            stringBuilder.append(item.getProduct().getWeight());
            stringBuilder.append("\t");
            stringBuilder.append(item.getProduct().getPackageUnits());
            stringBuilder.append("\t");
            stringBuilder.append(item.getProduct().getRestrictSale());
            stringBuilder.append("\t");
            stringBuilder.append(item.getAmount());
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
