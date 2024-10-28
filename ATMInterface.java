package org.example;
import java.util.ArrayList;
import java.util.Scanner;

public class ATMInterface {
    private ATM atm;
    private Scanner scanner;
    public ATMInterface(ATM atm) {
        this.atm = atm;
        this.scanner = new Scanner(System.in);
    }
    public void start() {
        System.out.println("Welcome to the ATM.");
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();
        System.out.print("Enter PIN: ");
        String pin = scanner.nextLine();
        if (!atm.login(userId, pin)) {
            return;
        }
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Transaction History");
            System.out.println("2. Withdraw");
            System.out.println("3. Deposit");
            System.out.println("4. Transfer");
            System.out.println("5. Quit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    showTransHistory();
                    break;
                case "2":
                    withdraw();
                    break;
                case "3":
                    deposit();
                    break;
                case "4":
                    transfer();
                    break;
                case "5":
                    atm.logout();
                    return;
                default:
                    System.out.println("Invalid choice Please try again.");
            }
        }
    }

    private void showTransHistory() {
        ArrayList<Transection> transactions = atm.getCurrentUser().getTransHistory();
        if (transactions.isEmpty()) {
            System.out.println("No transactions are found.");
        } else {
            for (Transection transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    private void withdraw() {
        System.out.print("Please enter amount to withdraw: ");
        System.out.print("₹");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        if (atm.getCurrentUser().withdraw(amount)) {
            System.out.println("Withdrawal successful Amount: ₹" + amount);
        } else {
            System.out.println("Insufficient balance/invalid amount.");
        }
    }
    private void deposit() {
        System.out.print("Plese enter amount to deposit: ₹");
        double amount = scanner.nextDouble();
        scanner.nextLine();  // Consume newline
        if (atm.getCurrentUser().deposit(amount)) {
            System.out.println("Deposit successful. Amount: ₹" + amount);
        } else {
            System.out.println("Insufficient balance/invalid amount.");
        }
    }
    private void transfer() {
        System.out.print("Please enter recipient User ID: ");
        String recipientId = scanner.nextLine();
        System.out.print("Enter amount to transfer:");
        double amount = scanner.nextDouble();
        System.out.println("₹");
        scanner.nextLine();  // Consume newline
        User recipient = atm.bank.getUser(recipientId);
        if (recipient != null && atm.getCurrentUser().transfer(amount, recipient)) {
            System.out.println("Transfer successful. Amount: ₹" + amount);
        } else {
            System.out.println("Transfer failed. Check balance or recipient ID.");
        }
    }
    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addUser(new User("sai101", "1234", 5000));
        bank.addUser(new User("ram507", "5342", 4000));
        ATM atm = new ATM(bank);
        ATMInterface atmInterface = new ATMInterface(atm);
        atmInterface.start();
    }
}
