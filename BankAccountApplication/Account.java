package BankAccountApplication;

public abstract class Account {
    private int accountNumber;
    protected double balance;

    public Account() {
    }

    public Account(int accountNumber) {
        this.accountNumber = accountNumber;
        balance = 0;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccountNumber() {
        return this.accountNumber;
    }

    /**
     * Function to deposit funds into the account as long as the amount
     * parameter is > 0
     * <p>
     * Apply transaction fee for the checking account
     *
     * @param amount value to be deposit
     */

    public abstract void deposit(double amount);

    /**
     * Function to withdraw funds from the account as long as
     * 1-Amount to withdraw must be > 0
     * 2-Amount to withdraw must be <= balance
     *
     * @param amount value to be withdraw
     */
    public abstract void withdraw(double amount);
}
