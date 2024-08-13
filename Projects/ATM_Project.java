package Projects;

import java.io.*;
import java.time.LocalDateTime;
import java.util.*;

class User implements Serializable {
    private String username;
    private String password;
    private double balance;
    private List<String> transactionHistory;
    private LocalDateTime accountCreationTime;

    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.balance = 0.0;
        this.transactionHistory = new ArrayList<>();
        this.accountCreationTime = LocalDateTime.now();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public LocalDateTime getAccountCreationTime() {
        return accountCreationTime;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void deposit(double amount, Map<String, User> users) {
        balance += amount;
        transactionHistory.add("Deposited: " + amount);
        updateUsersData(users);
    }

    public void withdraw(double amount, Map<String, User> users) {
        if (balance >= amount) {
            balance -= amount;
            transactionHistory.add("Withdrawn: " + amount);
            updateUsersData(users);
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    public void displayTransactionHistory() {
        for (String transaction : transactionHistory) {
            System.out.println(transaction);
        }
    }

    public double calculateInterest(double rate) {
        return balance * (rate / 100);
    }

    public void saveUsersData(Map<String, User> users) {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("userData.txt"))) {
            outputStream.writeObject(users);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static Map<String, User> loadUsersData() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("userData.txt"))) {
            return (Map<String, User>) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return new HashMap<>();
    }

    private void updateUsersData(Map<String, User> users) {
        saveUsersData(users);
    }
}

class ATM {
    private Map<String, User> users;

    public ATM() {
        users = User.loadUsersData();
    }

    public void createAccount(String username, String password) {
        if (!users.containsKey(username)) {
            User newUser = new User(username, password);
            users.put(username, newUser);
            System.out.println("Account created for " + username + " at " + newUser.getAccountCreationTime());
            newUser.saveUsersData(users);
        } else {
            System.out.println("Username already exists.");
        }
    }

    public boolean login(String username, String password) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            return user.getPassword().equals(password);
        }
        return false;
    }

    public void deposit(String username, double amount) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            user.deposit(amount, users);
            System.out.println("Deposited " + amount + " into account. New balance: " + user.getBalance());
        } else {
            System.out.println("User does not exist.");
        }
    }

    public void withdraw(String username, double amount) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            user.withdraw(amount, users);
            System.out.println("Withdrawn " + amount + " from account. New balance: " + user.getBalance());
        } else {
            System.out.println("User does not exist.");
        }
    }

    public double calculateInterest(String username, double rate) {
        if (users.containsKey(username)) {
            User user = users.get(username);
            double interest = user.calculateInterest(rate);
            System.out.println("Interest calculated for " + username + ": " + interest);
            return interest;
        } else {
            System.out.println("User does not exist.");
            return 0.0;
        }
    }

    public Map<String, User> getUsers() {
        return users;
    }
}

public class ATM_Project {
    public static void main(String[] args) {
        ATM atm = new ATM();

        if (atm.login("user2", "pass456")) {
            User currentUser = atm.getUsers().get("user2");
            // currentUser.deposit(100.0, atm.getUsers());
            // currentUser.withdraw(200, atm.getUsers());
            System.out.println(currentUser.getBalance());
            currentUser.displayTransactionHistory();
        } else {
            System.out.println("Invalid credentials");
        }
    }
}
