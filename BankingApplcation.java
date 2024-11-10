import java.util.HashMap;
import java.util.Scanner;

public class BankingApplication {
    private static HashMap<String, Account> accounts = new HashMap<>();

    // Method to create a new account
    public static void createAccount(String accountNumber, String accountHolderName, double initialBalance) {
        Account newAccount = new Account(accountNumber, accountHolderName, initialBalance);
        accounts.put(accountNumber, newAccount);
        System.out.println("Account created successfully!");
    }

    // Method to find an account by account number
    public static Account findAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    // Main method with basic menu
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n--- Banking Application ---");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account number: ");
                    String accountNumber = scanner.next();
                    System.out.print("Enter account holder name: ");
                    String accountHolderName = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double initialBalance = scanner.nextDouble();
                    createAccount(accountNumber, accountHolderName, initialBalance);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    Account account = findAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    account = findAccount(accountNumber);
                    if (account != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawalAmount = scanner.nextDouble();
                        account.withdraw(withdrawalAmount);
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    accountNumber = scanner.next();
                    account = findAccount(accountNumber);
                    if (account != null) {
                        account.displayAccountInfo();
                    } else {
                        System.out.println("Account not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting the application. Goodbye!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
