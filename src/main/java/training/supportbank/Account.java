package training.supportbank;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Account {

    private String name;
    private List<Transaction> incomingTransactions;
    private List<Transaction> outgoingTransactions;
    private BigDecimal balance;

    public Account(String name) {
        this.name = name;
        this.incomingTransactions = new ArrayList<>();
        this.outgoingTransactions = new ArrayList<>();
        this.balance = BigDecimal.ZERO;
    }

    public String getName() {
        return name;
    }

    public List<Transaction> getIncomingTransactions() {
        return incomingTransactions;
    }

    public List<Transaction> getOutgoingTransactions() {
        return outgoingTransactions;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public List<Transaction> getAllTransactions() {
        List<Transaction> allTransactions = new ArrayList<>();
        allTransactions.addAll(this.incomingTransactions);
        allTransactions.addAll(this.outgoingTransactions);
        return allTransactions;
    }

    public void addIncomingTransaction(Transaction transaction) {
        this.incomingTransactions.add(transaction);
        this.balance = this.balance.add(transaction.getAmount());
    }

    public void addOutgoingTransaction(Transaction transaction) {
        this.outgoingTransactions.add(transaction);
        this.balance = this.balance.subtract(transaction.getAmount());
    }
}
