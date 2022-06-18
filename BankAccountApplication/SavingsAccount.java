package BankAccountApplication;

//Child class
public class SavingsAccount extends Account {
    private double interestRate;

    //default constructor
    public SavingsAccount() {
        super();
    }

    /**
     * Parameter constructor to initialize SavingsAccount
     * with a custom number and interest rate
     *
     * @param accountNumber
     * @param interestRate
     */
    public SavingsAccount(int accountNumber, double interestRate) {
        super(accountNumber);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return this.interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public double calculateInterest() {
        return balance * interestRate;
    }

    public void applyInterest() {
        double interest = calculateInterest();
        System.out.printf("Interest amount %.2f added to balance%n", interest);
        deposit(interest);
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
            if (amount <= balance) {
                balance -= amount;
                System.out.printf("Amount of %.2f withdrawn from account%n", amount);
                System.out.printf("Current balance is: %.2f%n", balance);
            }
        } else {
            System.out.println("Negative amount cannot withdraw!");
        }
    }
}
