package training.supportbank;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String args[]) throws IOException {

        System.out.println("Welcome to SupportBank!");
        System.out.println("=======================");

        Bank supportBank = new Bank();
        loadTransactionsFromFileIntoBank("Transactions2014.csv", supportBank);

        String userCommand = promptUserForInput();
        if (userCommand.equals("List All")) {
            listAllAccounts(supportBank);
        } else {
            String accountName = getAccountNameFromUserInput(userCommand);
            listSpecificAccount(accountName, supportBank);
        }
    }

    private static void loadTransactionsFromFileIntoBank(String filename, Bank bank) throws IOException {
        List<Transaction> transactions = CsvReading.getTransactionsFromFile(filename);
        for (int i = 0; i < transactions.size(); i++) {
            bank.addTransaction(transactions.get(i));
        }
    }

    private static String promptUserForInput() {
        while (true) {
            System.out.println("Please enter a command. Choices are:");
            System.out.println("  List All");
            System.out.println("  List [Account]");
            System.out.print("> ");

            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();

            if (userInput.startsWith("List ")) {
                return userInput;
            } else {
                System.out.println("Invalid input");
            }
        }
    }

    private static String getAccountNameFromUserInput(String userInput) {
        return userInput.substring(5);
    }

    private static void listAllAccounts(Bank bank) {
        Collection<Account> allAccounts = bank.getAllAccounts();
        for (Account account : allAccounts) {
            System.out.println("Name: " + account.getName() + ", Balance: " + account.getBalance());
        }
    }

    private static void listSpecificAccount(String accountName, Bank bank) {
        Account accountWithName = bank.getAccountWithName(accountName);
        if (accountWithName ==  null) {
            System.out.println("Sorry - that account doesn't exist!");
        } else {
            System.out.println("Showing transactions for: " + accountName);
            List<Transaction> allTransactions = accountWithName.getAllTransactions();
            for (int i = 0; i < allTransactions.size(); i++) {
                displayTransaction(allTransactions.get(i));
            }
        }
    }

    private static void displayTransaction(Transaction transaction) {
        System.out.println(
                  "Date: " + transaction.getDate() + ", "
                + transaction.getFrom() + " paid " + transaction.getTo() + " "
                + "£" + transaction.getAmount() + " "
                + "for " + transaction.getNarrative()
        );
    }
}
