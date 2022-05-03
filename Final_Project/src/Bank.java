import java.util.*;
/**
 * Bank class
 * @author bmoha
 * Represents a Bank
 * You can make transactions 
 */
public class Bank {
    private static double amount;
    private static ArrayList<BankAccount> bankAccountList = new ArrayList<>();
    private static BankAccount selectedBankAccount;
    private static boolean flag = false;

    public static void main(String[] args) {
    	// Scanner to take input from the user
        Scanner scan = new Scanner(System.in);
        // Bank menu starts from here
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to the Bank of America!");
        System.out.println("Enter the option for the operation you need:");
        System.out.println("------------------------------------------------------");
        System.out.println("| Current available options:                         |");
        System.out.println("| new_account - to make a new account                |");
        System.out.println("| select_account - to select which account to access |");
        System.out.println("| delete_account - to delete and existing Account    |");
        System.out.println("| deposit - to make a deposit to your account        |");
        System.out.println("| withdraw - to make a withdrawal from your account  |");
        System.out.println("| balance - to check your current balance            |");
        System.out.println("| exit - to quit                                     |");
        System.out.println("------------------------------------------------------");
        BankAccount bankAccount = null;
        while (true) {
            System.out.print("> "); // indicator for user input
            String choice = input.next();
            // Options
            switch (choice) {
                case "new_account":
                    // User creates a new account
                    int accNo = 0;
                    int bal = 0;
                    // Taking input from user for account number
                    System.out.println("Enter bank account number : ");
                    accNo = input.nextInt();
                    // Taking input from user for initial balance
                    System.out.println("Enter initial balance: ");
                    bal = input.nextInt();
                    System.out.println("Current bank account: " + accNo + " " + "Balance " + bal);
                    bankAccount = new BankAccount(bal, accNo);
                    bankAccountList.add(bankAccount);
                    break; // Continues loop
                case "select_account":
                    // User can select their account
                    System.out.println("Enter bank account number for further operations : ");
                    int selectedAcc = scan.nextInt();
                    System.out.println("Selected bank account : " + selectedAcc);
                    for (Object object : bankAccountList) {
                        selectedBankAccount = (BankAccount) object;
                        if (selectedBankAccount.getAccNumber() == selectedAcc) {
                            flag = true;
                            break;
                        } else { // Ends loop
                            flag = false;
                        }
                    }
                    if (!flag) {
                        System.out.println("Bank account doesn't exists.");
                    }
                    if (bankAccountList.size() == 0) {
                        System.out.println("Zero bank account exists.");
                    }
                    break;
                case "delete_account":
                    // User can close their account
                    System.out.println("Enter bank account number for further operations : ");
                    int selectedAcc1 = scan.nextInt();
                    System.out.println("Selected bank account : " + selectedAcc1);
                    Iterator<BankAccount> iterator = bankAccountList.iterator();
                    while (iterator.hasNext()) {
                        selectedBankAccount = (BankAccount) iterator.next();
                        if (selectedBankAccount.getAccNumber() == selectedAcc1) {
                            iterator.remove();
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        System.out.println("That bank account doesn't exists.");
                    }
                    System.out.println("The bank account " + selectedAcc1 + " is now closed.");
                    break;
                case "deposit":
                    // User can deposit an amount of their choosing to their account
                    System.out.println("Enter amount to deposit :  ");
                    amount = scan.nextDouble();
                    if (amount <= 0) {
                        System.out.println("You must deposit an amount greater than 0.");
                    } else {
                        if (flag) {
                            selectedBankAccount.deposit(amount);
                            System.out.println("You have deposited " + amount + ". "
                            		+ "Your new total balance : "
                                + (selectedBankAccount.getBalance()));
                        } else {
                            System.out.println("Please select account number.");
                        }
                    }
                    break;
                case "withdraw":
                    // Withdraws an amount determined by the user from their account
                	// Taking input from user for the amount of money to be withdrawn
                    System.out.println("Enter amount to be withdrawn: ");
                    amount = scan.nextDouble();
                    if (amount > bankAccount.getBalance() && amount <= 0) {
                        System.out.println("You can't withdraw that amount!");
                    } else if (amount <= selectedBankAccount.getBalance()) {
                        if (flag) {
                            selectedBankAccount.withdraw(amount);
                            System.out.println("You have withdrawn : " + amount 
                            	+ " with your new Balance of : "
                                + selectedBankAccount.getBalance());
                        } else {
                            System.out.println("Please select bank account number.");
                        }
                    }
                    break;
                case "balance":
                    // checks the balance in selected account
                    if (flag) {
                        System.out.println("Your current bank account balance : "
                            + selectedBankAccount.getBalance());
                    } else {
                        System.out.println("Please select bank account number.");
                    }
                    break;
                case "exit":
                	// default quits the program
                    System.out.println("Thank You. Visit Again!");
                    flag = false;
                    input.close();
                    scan.close();
                    System.exit(0);
                    break;
                default:
                    // default quits the program
                    System.out.println("Thank You. Visit Again!");
                    flag = false;
                    input.close();
                    scan.close();
                    System.exit(0);
                    break;
            }
        } // end of menu loop
    }// end of main
} // end of class