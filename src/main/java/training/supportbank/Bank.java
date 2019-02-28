package training.supportbank;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Bank {

    private Map<String, Account> accounts;

    public Bank() {
        this.accounts = new HashMap<>();
    }

    public void addTransaction(Transaction transaction) {
        Account fromAccount = getAccountWithNameAndCreateIfItDoesntExist(transaction.getFrom());
        fromAccount.addOutgoingTransaction(transaction);

        Account toAccount = getAccountWithNameAndCreateIfItDoesntExist(transaction.getTo());
        toAccount.addIncomingTransaction(transaction);
    }

    public Collection<Account> getAllAccounts() {
        return this.accounts.values();
    }

    public Account getAccountWithName(String name) {
        return this.accounts.getOrDefault(name, null);
    }

    private Account getAccountWithNameAndCreateIfItDoesntExist(String name) {
        if (this.accounts.containsKey(name)) {
            return this.accounts.get(name);
        } else {
            Account newAccount = new Account(name);
            this.accounts.put(name, newAccount);
            return newAccount;
        }
    }
}
