import java.util.ArrayList;

public class Customer {

    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        addTransactions(initialAmount);
    }

    public void addTransactions(double amount) {
        transactions.add(amount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    public static Customer addCustomer (String name, double initialAmount) {
        return new Customer(name, initialAmount);
    }
}
