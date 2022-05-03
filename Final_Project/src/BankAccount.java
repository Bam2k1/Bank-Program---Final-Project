/**
 * This class performs bank operations
*/
public class BankAccount {
    private int accNumber;
    private double balance;

    public BankAccount(double initialBalance, int accNo) {
        balance = initialBalance;
        accNumber = accNo;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public double withdraw(double amount) {
        balance -= amount;
        return amount;
    }

    public double getBalance() {
        return balance;
    }

    public int getAccNumber() {
        return accNumber;
    }
}