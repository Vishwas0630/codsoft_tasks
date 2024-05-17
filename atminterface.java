import java.util.Scanner;

// BankAccount class represents the user's bank account
class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public boolean withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            return true;
        } else {
            return false;
        }
    }
}

// ATM class represents the ATM machine
public class ATM {
    private BankAccount account;
    private Scanner scanner;

    public ATM(BankAccount account) {
        this.account = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display the ATM menu
    public void displayMenu() {
        System.out.println("Welcome to the ATM!");
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
    }

    // Method to handle user options
    public void handleOption(int option) {
        switch (option) {
            case 1:
                withdraw();
                break;
            case 2:
                deposit();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM!");
                break;
            default:
                System.out.println("Invalid option!");
        }
    }

    // Method to handle withdrawal
    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Insufficient funds!");
        }
    }

    // Method to handle deposit
    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful!");
    }

    // Method to display account balance
    private void checkBalance() {
        System.out.println("Current balance: " + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000); // Initial balance is 1000
        ATM atm = new ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        int option;
        do {
            atm.displayMenu();
            System.out.print("Choose an option: ");
            option = scanner.nextInt();
            atm.handleOption(option);
        } while (option != 4);

        scanner.close();
    }
}
