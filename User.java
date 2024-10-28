package org.example;

import java.util.ArrayList;

class User{
    private String userId;
    private String pin;
    private double balance;
    private ArrayList<Transection> transHistory;
    public User(String userId, String pin, double initialBalance) {
        this.userId = userId;
        this.pin = pin;
        this.balance = initialBalance;
        this.transHistory = new ArrayList<>();
    }
    public boolean checkPin(String enteredPin) {
        return this.pin.equals(enteredPin);
    }
    public double getBalance() {
        return balance;
    }
    public void addTransaction(String type, double amount) {
        Transection transaction = new Transection(type, amount);
        transHistory.add(transaction);
    }
    public ArrayList<Transection> getTransHistory() {
        return transHistory;
    }
    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            addTransaction("Deposit", amount);
            return true;
        }
        return false;
    }
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            addTransaction("Withdraw", amount);
            return true;
        }
        return false;
    }
    public boolean transfer(double amount,User recipient) {
        if (amount > 0 && amount <= balance) {
            this.withdraw(amount);
            recipient.deposit(amount);
            addTransaction("Transfer to " + recipient.userId, amount);
            recipient.addTransaction("Transfer from " + this.userId, amount);
            return true;
        }
        return false;
    }
    public String getUserId() {
        return userId;
    }
}
