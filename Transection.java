package org.example;

import java.util.Date;
public class Transection {
    private String type;
    private double amount;
    private Date date;
    public Transection(String type, double amount) {
        this.type = type;
        this.amount = amount;
        this.date = new Date();
    }
    public String toString() {
        return date + " - " + type + ": ₹" + amount;
    }
}
