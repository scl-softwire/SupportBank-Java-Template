# Reading transactions

Now that you have the means to represent a transaction as an object in your code, it's a good time to write the code that will read the transactions from the data file.

## Another class

It's good practice in Java to write small classes that have only one or two responsibilities each. Reading a CSV file and producing a list of transactions is a good candidate for a job that belongs in its own class.

Go ahead and create another class - call it anything you like, as long as its name makes sense in the context of what its job is.

## Breaking into methods

The way I see it, this class needs to be able to do two things: it needs to be able to read the lines from the data file, and it needs to be able to turn each line into a `Transaction` object before returning it.

That makes the following method structure promising for this class:

```java
public static List<Transaction> getTransactionsFromFile(String filename) {
    // ...
}

private static Transaction convertLineToTransaction(String line) {
    // ...
}
```

You should fill in the currently-blank implementations of these methods so that they behave as described. Some hints: to read the lines from a file, `Files.readAllLines` will be helpful, and to convert a single line to a transaction you will probably want to make use of `String::split`.

You can check that your code is working by temporarily putting something in your `main` method that calls it, and either having it print out the details of the transactions or setting a breakpoint and examining the transactions in the debugger.

Once you're happy with it, take a look at how we'll want to be [Storing Transactions](storing-transactions.md).