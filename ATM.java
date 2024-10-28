package org.example;
class ATM {
    public Bank bank;
    private User currentUser;

    public ATM(Bank bank) {
        this.bank = bank;
        this.currentUser = null;
    }
    public boolean login(String userId, String pin) {
        User user = bank.getUser(userId);
        if (user != null && user.checkPin(pin)) {
            this.currentUser = user;
            System.out.println("Login successful!");
            return true;
        }
        System.out.println("Invalid ID/PIN.");
        return false;
    }
    public void logout() {
        this.currentUser = null;
        System.out.println("Logged out successfully..");
    }

    public User getCurrentUser() {
        return currentUser;
    }
    public User getUser(String userId) {
        return bank.getUser(userId);
    }
}
