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
}
