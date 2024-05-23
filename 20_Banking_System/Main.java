import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

// BankingAccount Interface
interface BankingAccount {
    void deposit(double amount);
    void withdraw(double amount);
    void transfer(BankingAccount toAccount, double amount);
    void addTransaction(String transaction);
    void printTransactions();
    String getAccountNumber();  // Add this method
    double getBalance();  // Add this method
}

// AbstractBankAccount Abstract Class
abstract class AbstractBankAccount implements BankingAccount {
    protected String accountNumber;
    protected double balance;
    protected List<String> transactions;

    public AbstractBankAccount(String accountNumber, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.balance = initialDeposit;
        this.transactions = new ArrayList<>();
        addTransaction("Initial deposit: $" + initialDeposit);
    }

    @Override
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit: $" + amount);
    }

    @Override
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            addTransaction("Withdrawal: $" + amount);
        } else {
            addTransaction("Failed withdrawal attempt: $" + amount);
        }
    }

    @Override
    public void transfer(BankingAccount toAccount, double amount) {
        if (balance >= amount) {
            this.withdraw(amount);
            toAccount.deposit(amount);
            addTransaction("Transfer to Account " + toAccount.getAccountNumber() + ": $" + amount);
        } else {
            addTransaction("Failed transfer attempt: $" + amount);
        }
    }

    @Override
    public void addTransaction(String transaction) {
        transactions.add(transaction);
    }

    @Override
    public void printTransactions() {
        System.out.println("Transaction History for Account " + accountNumber + ":");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }

    @Override
    public String getAccountNumber() {
        return accountNumber;
    }

    @Override
    public double getBalance() {
        return balance;
    }
}

// SavingsAccount Class
class SavingsAccount extends AbstractBankAccount {
    public SavingsAccount(String accountNumber, double initialDeposit) {
        super(accountNumber, initialDeposit);
    }
}

// CheckingAccount Class
class CheckingAccount extends AbstractBankAccount {
    public CheckingAccount(String accountNumber, double initialDeposit) {
        super(accountNumber, initialDeposit);
    }
}

// Bank Class
class Bank {
    private Map<String, BankingAccount> accounts;

    public Bank() {
        accounts = new HashMap<>();
    }

    public void createAccount(String accountType, String accountNumber, double initialDeposit) {
        BankingAccount account;
        if (accountType.equalsIgnoreCase("Savings")) {
            account = new SavingsAccount(accountNumber, initialDeposit);
        } else if (accountType.equalsIgnoreCase("Checking")) {
            account = new CheckingAccount(accountNumber, initialDeposit);
        } else {
            System.out.println("Invalid account type.");
            return;
        }
        accounts.put(accountNumber, account);
        System.out.println("Account created successfully!");
    }

    public void deposit(String accountNumber, double amount) {
        BankingAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.deposit(amount);
            System.out.println("Deposit successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void withdraw(String accountNumber, double amount) {
        BankingAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.withdraw(amount);
            System.out.println("Withdrawal successful. New balance: $" + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    public void transfer(String fromAccountNumber, String toAccountNumber, double amount) {
        BankingAccount fromAccount = accounts.get(fromAccountNumber);
        BankingAccount toAccount = accounts.get(toAccountNumber);
        if (fromAccount != null && toAccount != null) {
            fromAccount.transfer(toAccount, amount);
            System.out.println("Transfer successful.");
        } else {
            System.out.println("One or both accounts not found.");
        }
    }

    public void viewTransactions(String accountNumber) {
        BankingAccount account = accounts.get(accountNumber);
        if (account != null) {
            account.printTransactions();
        } else {
            System.out.println("Account not found.");
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bank bank = new Bank();
        String accountNumber, accountType;
        double amount;

        while (true) {
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Transfer Funds");
            System.out.println("5. View Transactions");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    System.out.print("Enter account type (Savings/Checking): ");
                    accountType = scanner.nextLine();
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter initial deposit amount: ");
                    amount = Double.parseDouble(scanner.nextLine());
                    bank.createAccount(accountType, accountNumber, amount);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter deposit amount: ");
                    amount = Double.parseDouble(scanner.nextLine());
                    bank.deposit(accountNumber, amount);
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    System.out.print("Enter withdrawal amount: ");
                    amount = Double.parseDouble(scanner.nextLine());
                    bank.withdraw(accountNumber, amount);
                    break;

                case 4:
                    System.out.print("Enter from account number: ");
                    String fromAccountNumber = scanner.nextLine();
                    System.out.print("Enter to account number: ");
                    String toAccountNumber = scanner.nextLine();
                    System.out.print("Enter transfer amount: ");
                    amount = Double.parseDouble(scanner.nextLine());
                    bank.transfer(fromAccountNumber, toAccountNumber, amount);
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.nextLine();
                    bank.viewTransactions(accountNumber);
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
