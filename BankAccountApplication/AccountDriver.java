package BankAccountApplication;

import java.util.Scanner;

public class AccountDriver {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Account[] accounts = new Account[10];
        int numAccounts = 0;

        int choice;
        do {
            choice = menu(scan);
            System.out.println();

            if (choice == 1) {
                accounts[numAccounts++] = createAccount(scan);
            } else if (choice == 2) {
                depositApply(accounts, numAccounts, scan);
            } else if (choice == 3) {
                withdrawApply(accounts, numAccounts, scan);
            } else if (choice == 4) {
                interestApply(accounts, numAccounts, scan);
            } else {
                System.out.println("GOODBYE!");
            }
            System.out.println();
        } while (choice != 5);
    }

    public static int accountMenu(Scanner scan) {
        System.out.println("Select Account Type: ");
        System.out.println("1. Checking Account");
        System.out.println("2. Savings Account");

        int choice;
        do {
            System.out.print("Enter An Option: ");
            choice = scan.nextInt();
        } while (choice < 1 || choice > 2);
        return choice;
    }

    /**
     * Function to create new account
     *
     * @param scan
     * @return
     */
    public static Account createAccount(Scanner scan) {
        int choice = accountMenu(scan);
        Account account = null;
        int accountNumber;
        System.out.println("Enter Your Account Number: ");
        accountNumber = scan.nextInt();

        if (choice == 1) {
            System.out.println("Enter Transaction Fee: ");
            double fee = scan.nextDouble();
            account = new CheckingAccount(accountNumber, fee);
        } else {
            System.out.println("Please Enter The Interest Rate: ");
            double interestRate = scan.nextDouble();
            account = new SavingsAccount(accountNumber, interestRate);
        }
        return account;
    }

    public static int searchAccount(Account accounts[], int count, int accountNumber) {
        for (int i = 0; i < count; i++) {
            if (accounts[i].getAccountNumber() == accountNumber)
                return i;
        }
        return -1;
    }

    public static void depositApply(Account account[], int count, Scanner scan) {
        System.out.println("Please Enter Account Number: ");
        int accountNumber = scan.nextInt();

        int index = searchAccount(account, count, accountNumber);

        if (index > 0) {
            System.out.println("Please enter deposit amount: ");
            double amount = scan.nextDouble();
            account[index].deposit(amount);
        } else {
            System.out.println("No account exists with this account number!!!");
        }
    }

    public static void withdrawApply(Account account[], int count, Scanner scan) {
        System.out.println("Please Enter Account Number: ");
        int accountNumber = scan.nextInt();

        int index = searchAccount(account, count, accountNumber);

        if (index > 0) {
            System.out.println("Please enter withdraw amount: ");
            double amount = scan.nextDouble();
            account[index].withdraw(amount);
        } else {
            System.out.println("No account exists with this account number!!!");
        }
    }

    public static void interestApply(Account account[], int count, Scanner scan) {
        System.out.println("Please Enter Account Number: ");
        int accountNumber = scan.nextInt();

        int index = searchAccount(account, count, accountNumber);

        if (index > 0) {

            //Must be instanced of savings account
            if (account[index] instanceof SavingsAccount) {
                ((SavingsAccount) account[index]).applyInterest();
            }
        } else {
            System.out.println("No account exists with this account number!!!");
        }
    }

    /**
     * Menu for the bank app
     *
     * @param scan
     * @return
     */
    public static int menu(Scanner scan) {
        System.out.println("WELCOME TO THE OUR BANK MENU");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Apply Interest");
        System.out.println("5. Exit From The System");

        int choice;
        do {
            System.out.println("Enter An Option: ");
            choice = scan.nextInt();
        } while (choice < 1 || choice > 5);
        return choice;
    }
}
