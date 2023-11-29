package ex_1;


public class Account {

    private final int id;
    private final String name;
    private double balance;

    // constructors
    public Account(int id, String name) {
        this.id = id;
        this.name = name;
        this.balance = 0;
    }

    public Account(int id, String name, double balance) {
        this.id = id;
        this.name = name;
        this.balance = balance;
    }

    // Getters
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    // deposit method
    public double deposit(double amount) {
        if(amount > 0) {  // amount must be positive number
            balance += amount;
            return amount;
        } else return -1; // transaction failed
    }

    // withdrawal method
    public double withdrawal(double amount) {
        if(balance >= amount && amount > 0) {  // amount must be positive and smaller than available balance
            balance -= amount;
            return amount;
        } else return -1; // transaction failed
    }
}

