import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches =  new ArrayList<Branch>();
    }

    /**Finding branch by it's name
     * @param nameOfBranch
     * @return branch found
     * @return null, if the branch doesn't exist*/
    private Branch findBranch(String nameOfBranch) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if (branch.getSubName().equals(nameOfBranch)) {
                return branch;
            }
        }
        return null;
    }

    /**Adding new branch to the bank passing the name of the branch
     * @param branchName, the name going to be added
     * @return true, if the name of branch is not exist yet in the branch ArrayList
     * @return false, if the name of branch already exist in the arrayList*/
    public boolean addNewBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }

        return false;
    }

    /**Adding new Customer to the arrayList of Customers
     * @param branchName, the name of the branch where we ar going to add the customer
     * @param customerName, name of customer
     * @param initialAmount, the initial amount to add to the new customer
     * @return false if the branch doesn't exist, else
     * @return the branch method that add a new customer to the arrayList of customers (this method is boolean too)*/
    public boolean addNewCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }

        return false;
    }

    /**Adding customer transaction
     * @param branchName,customerName,amount
     * @return false if the branch doesn't exist
     * @return the method that call addCustomerTransaction in branch class*/
    public boolean addCustomerTransaction(String branchName,String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName,amount);
        }

        return false;
    }

    /**Print the list of customers in a particolar branch
     * @param branchName the name of branch
     * @param showTransactions, a boolean to choose to show the transactions of the customer or not
     * @return true if everything gone well,
     * @return false if the branch doesn't exist*/
    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch branch = findBranch(branchName);
        if (branch == null) {
            System.out.println("Branch doesn't exist.");
            return false;
        }

        /*if the branch exist: */
        /*Creo arrayList */
        ArrayList<Customer> branchCustomers = branch.getCustomers();
        for (int i = 0; i < branchCustomers.size(); i++) {
            System.out.println((i+1) + ". " + branchCustomers.get(i).getName());

            if(showTransactions) {
                System.out.println("Transactions");

                ArrayList<Double> transactions = branchCustomers.get(i).getTransactions();
                for(int j=0; j<transactions.size(); j++) {
                    System.out.println("[" + (j+1) + "]  Amount "  + transactions.get(j));
                }
            }
        }

        return true;
    }

}
