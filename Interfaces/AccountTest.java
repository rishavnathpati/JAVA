package Interfaces;
// Develop an interface with two methods namely, withdraw money and deposit money. Develop a class 
// Account  that  implements  the  interface  with  necessary  private  data  members  such  as  current  account 
// balance  and  account  number.  Develop  another  class  CreditCardAccount  that  implements  the  interface 
// with  necessary  data members  such  as  current  credit  limit  and  the  credit  card  number.  When money is 
// withdrawn from a credit card account; the credit limit is diminished by the amount of money withdrawn 
// and  by  an  additional  0.5%  of  the  amount  of  money  withdrawn  and  when  the  money  is  deposited;  the 
// credit limit is increased by the amount of money deposited. Develop a class containing the main method 
// and  create  an  account  object  and  a  credit  card  account  object  and  demonstrate  the  withdrawal  and 
// deposit method on the objects

// Interface with two methods namely, withdraw money and deposit money
interface AccountInterface {
    public void withdraw(double amount);

    public void deposit(double amount);
}

// Account class that implements the interface with necessary private data
// members such as current account balance and account number
class Account implements AccountInterface {
    private double balance;
    private int accountNumber;

    public Account(double balance, int accountNumber) {
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
    }
}

// CreditCardAccount class that implements the interface with necessary data
// members such as current credit
// limit and the credit card number
class CreditCardAccount implements AccountInterface {
    private double creditLimit;
    private double balance;
    public CreditCardAccount(double balance, int accountNumber, double creditLimit) {
        this.balance = balance;
        this.creditLimit = creditLimit;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    @Override
    public void withdraw(double amount) {
        balance -= amount;
        creditLimit -= amount * 0.005;
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        creditLimit += amount;
    }

    public double getBalance() {
        return balance;
    }
}

public class AccountTest {
    public static void main(String[] args) {
        Account account = new Account(1000, 123456789);
        CreditCardAccount creditCardAccount = new CreditCardAccount(1000, 123456789, 1000);

        System.out.println("Account Balance: " + account.getBalance());
        System.out.println("Credit Card Balance: " + creditCardAccount.getBalance());
        System.out.println("Credit Card Limit: " + creditCardAccount.getCreditLimit());

        account.withdraw(100);
        creditCardAccount.withdraw(100);

        System.out.println("Account Balance: " + account.getBalance());
        System.out.println("Credit Card Balance: " + creditCardAccount.getBalance());
        System.out.println("Credit Card Limit: " + creditCardAccount.getCreditLimit());

        account.deposit(100);
        creditCardAccount.deposit(100);

        System.out.println("Account Balance: " + account.getBalance());
        System.out.println("Credit Card Balance: " + creditCardAccount.getBalance());
        System.out.println("Credit Card Limit: " + creditCardAccount.getCreditLimit());
    }
}


