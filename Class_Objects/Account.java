// Create a class called Account to represent a bank account held by a customer (account holder). 
// An account is characterized by the private fields – an account number (type String), the account balance
// (type double) and the name of the account holder (type String).
// The Account class should have a constructor that initializes the instance fields.
// Provide a set and a get method for each instance field. 
// In addition, provide the deposit and withdrawal method and a method named computeInterest that calculates the interest earned by an account if the interest rate is 6% per annum. 
// Test the class using the main method showing the invocation of deposit, withdrawal and computeInterest methods

import java.util.Scanner;

public class Account {
    private String accountNumber;
    private double accountBalance;
    private String accountHolderName;

    public Account(String accountNumber, double accountBalance, String accountHolderName) {
        this.accountNumber = accountNumber;
        this.accountBalance = accountBalance;
        this.accountHolderName = accountHolderName;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public void deposit(double amount) {
        this.accountBalance += amount;
    }

    public void withdrawal(double amount) {
        this.accountBalance -= amount;
    }

    public double computeInterest() {
        return this.accountBalance * 0.06;
    }

    public static void main(String args[]) {
        System.out.print("\033[H\033[2J");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter account number: ");
        String accountNumber = sc.nextLine();

        System.out.println("Enter account balance: ");
        double accountBalance = sc.nextDouble();
        sc.nextLine();

        System.out.println("Enter account holder name: ");
        String accountHolderName = sc.nextLine();

        Account account = new Account(accountNumber, accountBalance, accountHolderName);

        System.out.println("\nAccount number: " + account.getAccountNumber());
        System.out.println("Account balance: " + account.getAccountBalance());
        System.out.println("Account holder name: " + account.getAccountHolderName());

        System.out.println("\nEnter amount to deposit: ");
        double amount = sc.nextDouble();
        account.deposit(amount);

        System.out.println("Account balance after deposit: " + account.getAccountBalance());
        System.out.println("\nEnter amount to withdrawal: ");
        amount = sc.nextDouble();
        account.withdrawal(amount);

        System.out.println("Account balance after withdrawal: " + account.getAccountBalance());
        System.out.println("\nInterest earned: " + account.computeInterest());

        sc.close();
    }
}