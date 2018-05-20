import java.util.ArrayList;

public class Branch {
    private String subName;
    private ArrayList<Customer> customers;

    public Branch(String subName) {
        this.subName = subName;
        this.customers = new ArrayList<Customer>();
    }

    public String getSubName() {
        return subName;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }

    /** Finding customer in branch by his name
     * @param customerName the of customer we are going to find
     * @return i, the position of the customer
     * @return -1, if the customer doesn't exist*/
    private int findCustomer (String customerName) {
        for (int i = 0; i<customers.size(); i++) {
            Customer customer = this.customers.get(i);
            if (customer.getName().equals(customerName)) {
                return i;
            }
        }
        return -1;
    }

    /** Adding new customer in the arrayList of customer
     * @param customerNAme
     * @param initialAmount, the initial amount when we add the new customer
     * @return false, if the customer name already exit in the arrayList of customer
     * @return true after adding the new customer to the arrayList*/
    public boolean newCustomer (String customerNAme, double initialAmount) {
        int pos = findCustomer(customerNAme);
        if (pos >= 0) {
            System.out.println("Customer already exist.");
            return false;
        }

        /*if the customer doesn't exist: */
        this.customers.add(Customer.addCustomer(customerNAme, initialAmount));
        return true;
    }

    /**add a transaction to a customer that already exist
     * @param customerNAme,
     * @param amount
     * @return false if the customer doesn't exist
     * @return true after adding the amount to the customer.*/
    public boolean addCustomerTransaction (String customerNAme, double amount) {

        /*i have to control if this customer already exist:*/
        int pos = findCustomer(customerNAme);
        if (pos < 0) {
            System.out.println("Customer doesn't exist.");
            return false;
        }

        /*if exist, add the amount:*/
        Customer customer = this.customers.get(pos);
        customer.addTransactions(amount);
        return true;
    }
}
