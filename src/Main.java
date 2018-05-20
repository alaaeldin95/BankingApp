public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank("National Australia Bank");

        if(bank.addNewBranch("Adelaide")) {
            System.out.println("Adelaide branch created");
        }

        bank.addNewCustomer("Adelaide", "Tim", 50.05);
        bank.addNewCustomer("Adelaide", "Mike", 175.34);
        bank.addNewCustomer("Adelaide", "Percy", 220.12);

        bank.addNewBranch("Sydney");
        bank.addNewCustomer("Sydney", "Bob", 150.54);

        bank.addCustomerTransaction("Adelaide", "Tim", 44.22);
        bank.addCustomerTransaction("Adelaide", "Tim", 12.44);
        bank.addCustomerTransaction("Adelaide", "Mike", 1.65);

        bank.listCustomers("Adelaide", true);
        bank.listCustomers("Sydney", true);

        bank.addNewBranch("Melbourne");

        if(!bank.addNewCustomer("Melbourne", "Brian", 5.53)) {
            System.out.println("Error Melbourne branch does not exist");
        }

        if(!bank.addNewBranch("Adelaide")) {
            System.out.println("Adelaide branch already exists");
        }

        if(!bank.addCustomerTransaction("Adelaide", "Fergus", 52.33)) {
            System.out.println("Customer does not exist at branch");
        }

        if(!bank.addNewCustomer("Adelaide", "Tim", 12.21)) {
            System.out.println("Customer Tim already exists");
        }
    }
}
