import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name) {
        this.name = name;
        this.branches =  new ArrayList<Branch>();
    }


    private Branch findBranch(String nameOfBranch) {
        for (int i = 0; i < branches.size(); i++) {
            Branch branch = branches.get(i);
            if (branch.getSubName().equals(nameOfBranch)) {
                return branch;
            }
        }
        return null;
    }



    public boolean addNewBranch(String branchName) {
        if (findBranch(branchName) == null) {
            this.branches.add(new Branch(branchName));
            return true;
        }

        return false;
    }

    public boolean addNewCustomer(String branchName, String customerName, double initialAmount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.newCustomer(customerName, initialAmount);
        }

        return false;
    }

    public boolean addCustomerTransaction(String branchName,String customerName, double amount) {
        Branch branch = findBranch(branchName);
        if (branch != null) {
            return branch.addCustomerTransaction(customerName,amount);
        }

        return false;
    }

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
