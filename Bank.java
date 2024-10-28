package org.example;
import java.util.HashMap;
class Bank {
    private HashMap<String, User> users;
    public Bank() {
        users = new HashMap<>();
    }
    public void addUser(User user) {
        users.put(user.getUserId(), user);
    }
    public User getUser(String userId) {
        return users.get(userId);
    }
}
