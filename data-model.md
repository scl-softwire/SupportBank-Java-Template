# Designing a data model

When writing an application that deals with any sort of data, it is nearly always a good idea to design your data model (i.e. the classes that will hold your data) before even starting to write any code.

## Transactions?

In the case of SupportBank, there is an obvious need for one model class in particular. Our program will deal with monetary transactions, so it will almost certainly need a way to represent a transaction in code:

```java
public class Transaction {

    // Field definitions...

    public Transaction( /* ... */ ) {
        // Initialise the fields in the constructor
    }

    // Getters...
}
```

Have a look at the transactions in the data file. Can you add fields to this `Transaction` class to accurately represent that information? What types should they have?

Once you've decided which fields you'll have, define a constructor in order to be able to create instances of `Transaction`. You can get IntelliJ to do this automatically for you - Alt + Insert on Windows, or Cmd + N on macOS.

Remember also to define appropriate getters for the private fields of your class. You can do this using the same shortcut as for generating a constructor.

## Accounts?

One of the requirements of SupportBank is to be able to list all the transactions involving a specific person, and to calculate individual balances.

To do this, it will definitely be useful to be able to group all the transactions made by a single individual into one place. By way of analogy with real-life banks, I've called that structure an `Account`.

```java
public class Account {

    // Field definitions...

    public Account( /* ... */ ) {
        // Initialise the fields in the constructor
    }

    // Getters...

}
```

What data would be useful to have on the `Account` class? There's no easy answer this time, because we don't have a handy data file with a list of accounts in it like we did for transactions. Instead, you should base your design on what functionality we need.

Our application needs to be able to list all of the transactions associated with a particular person, and also to show their total balance. What fields will you use to achieve this?

## Multiple accounts?

It's no good having an account for each person if there's no easy way of accessing them. There's one more model class that would be useful - something that stores each person's account under their name. A bit like a real life bank, so we'll call it `Bank`:

```java
public class Bank {

    // Field definitions...

    public Bank( /* ... */ ) {
        // Initialise the fields in the constructor
    }

}
```

What field for `Bank` would allow us to store an account for each person, and look those accounts up by name?

## Next up

Once you're happy with the shape of your data, start working through [Reading Transactions](reading-transactions.md).