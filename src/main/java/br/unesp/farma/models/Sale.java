package br.unesp.farma.models;

import java.util.Date;

public class Sale {
    int id;
    Employee employee;
    Client client;
    Date timeStamp;
    Cart cart;
    Payment payment;
    String log;

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
            item.product.setPackageUnits(item.product.getPackageUnits() - item.getAmount());
        }

        if (this.employee != null && this.client != null && this.payment != null) {
            print = log + "Sale " + this.id + " payed with " + this.payment + " closed on " + new Date() + " by " + this.employee.getName() + " for client " + this.client.getName();
        } else {
            print = log + "Sale " + this.id +  " closed on " + new Date();
        }

        System.out.println(print);
    }

    public void cancelSale() {

        if (this.employee != null && this.client != null) {
            log = log + "Sale " + this.id + " cancelled on " + new Date() + " by " + this.employee.getName() + " for client " + this.client.getName();
        } else {
            log = log + "Sale " + this.id +  " closed on " + new Date();
        }

        System.out.println(log);
    }
}
