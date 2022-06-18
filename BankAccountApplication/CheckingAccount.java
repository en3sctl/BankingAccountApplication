package BankAccountApplication;

//Child class
public class CheckingAccount extends Account {

    private static double FEE = 2.5; //default transaction fee

    //default constructor
    public CheckingAccount() {
        super();
    }

    /**
     * Parameter constructor to initialize checkingAccount
     * with a custom number and custom fee
     *
     * @param accountNumber
     * @param fee
     */
    public CheckingAccount(int accountNumber, double fee) {
        super(accountNumber);
        FEE = fee;
    }

    /**
     * Function to deposit funds into the account as long as the amount
     * parameter is > 0
     * <p>
     * Apply transaction fee for the checking account
     *
     * @param amount value to be deposit
     */
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.printf("Amount %.2f deposited%n", amount);
            balance -= FEE;
            System.out.printf("Fee %.2f applied%n", FEE);
            System.out.printf("Current balance is: %.2f%n", balance);
        } else {
            System.out.println("Negative amount cannot deposited!");
        }
    }

    /**
     * Function to withdraw funds from the account as long as
     * 1-Amount to withdraw must be > 0
     * 2-Amount to withdraw must be <= balance
     *
     * @param amount value to be withdraw
     */
    public void withdraw(double amount) {
        if (amount > 0) {
            if ((amount + FEE) <= balance) {
                balance -= amount;
                System.out.printf("Amount of %.2f withdrawn from account%n", amount);
                balance -= FEE;
                System.out.printf("Fee of %.2f applied%n", FEE);
                System.out.printf("Current balance is: %.2f%n", balance);
            }
        } else {
            System.out.println("Negative amount cannot withdraw!");
        }
    }
}
