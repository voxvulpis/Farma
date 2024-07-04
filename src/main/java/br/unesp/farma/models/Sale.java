package br.unesp.farma.models;

import br.unesp.farma.utils.DemonstrationUtils;
import br.unesp.farma.repos.Stock;

import jakarta.validation.constraints.NotNull;

import java.util.Date;

public class Sale {
    @NotNull
    private Integer id;
    @NotNull
    private Employee employee;
    private Client client;
    private Date timeStamp;
    @NotNull
    private Cart cart;
    @NotNull
    private Payment payment;
    private String log;

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

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public void closeSale() {
        String print;
        Stock stock = DemonstrationUtils.loadStockFromJson();

        for(Item item : cart.itemList){
            if(item.getAmount() > 0){
                try {
                    stock.sellItem(item.getProduct().getId(), item.getAmount());
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }

        print = log + "Sale " + this.id + " payed with " + this.payment + " closed on " + new Date() + " by " + this.employee.getName() + " for client " + this.client.getName();

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
