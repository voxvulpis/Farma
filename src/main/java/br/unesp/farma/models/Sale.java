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
}
