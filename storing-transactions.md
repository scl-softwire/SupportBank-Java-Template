# Storing Transactions

At this point, you have the data models required to represent all of the transactions, and the capability to turn your data file into a collection of transactions.

The logical next step would be to fill up the `Account` and `Bank` structures with the transactions that we've read from the file.

## Account

To associate a `Transaction` with an `Account`, the `Account` class will need a method that takes a `Transaction` as a parameter and stores that transaction on the account. Perhaps something like this:

```java
public void addTransaction(Transaction transaction) {
    // ...
}
```

What will this method need to do to the fields of the `Account` in order to represent the fact that the transaction has been added? Write code in the method body that does that.

(NB depending on what fields you gave your `Account` class, this method alone may or may not be the cleanest way of writing your code. Don't treat the suggestions here as if they must be followed.)

## Bank

Once your `Account` class is capable of storing a transaction, you'll need to do the same for the `Bank`. Something like the following method:

```java
public void addTransaction(Transaction transaction) {
    // ...
}
```

Fill in the body of this method so that it looks up the two accounts involved in the transaction, and adds the transaction to both of them. Hint: you might need to do something special in the case that the account doesn't already exist.

## Checking it works

Once you're happy with the code you've written, write something in your `main` method that creates a new `Bank`, reads all of the transactions from the file, and then stores those transactions in the `Bank`. Set a breakpoint and run your program under the debugger to inspect the contents of the bank and check that it's all working as you expect.

When you've checked that you have no nasty surprises, it's time for [Wrapping Up](wrapping-up.md).