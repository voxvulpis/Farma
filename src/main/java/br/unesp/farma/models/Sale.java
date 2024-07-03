package br.unesp.farma.models;

import br.unesp.farma.utils.DemonstrationUtils;
import br.unesp.farma.repos.Stock;

import java.util.Date;

public class Sale {
    int id;
    Employee employee;
    Client client;
    Date timeStamp;
    Cart cart;
    Payment payment;
    String log;
    Stock stock = DemonstrationUtils.loadStockFromJson();

    public Sale(int id, Employee employee, Client client, Date timeStamp, Cart cart, Payment payment, String log) {
        this.id = id;
        this.employee = employee;
        this.client = client;
        this.timeStamp = timeStamp;
        this.cart = cart;
        this.payment = payment;
        this.log = log;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void closeSale() {
        String print;

        for(Item item : cart.itemList){
            if(item.getAmount() > 0){
                try {
                    stock.sellItem(item.product.id, item.getAmount());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        if (this.employee != null && this.client != null && this.payment != null) {
            print = log + "Sale " + this.id + " payed with " + this.payment + " closed on " + new Date() + " by " + this.employee.getName() + " for client " + this.client.getName();
        } else {
            print = log + "Sale " + this.id +  " closed on " + new Date();
        }

        DemonstrationUtils.saveToJson(stock);

        System.out.println(print + stock.toString());
    }

    public void cancelSale() {

        if (this.employee != null && this.client != null) {
            log = log + "Sale " + this.id + " cancelled on " + new Date() + " by " + this.employee.getName() + " for client " + this.client.getName();
        } else {
            log = log + "Sale " + this.id +  " cancel on " + new Date();
        }

        System.out.println(log);
    }
}
