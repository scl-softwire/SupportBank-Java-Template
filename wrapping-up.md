# Wrapping Up

All of the "plumbing" for your application should now be in place, and it's finally time to do something useful with it.

You already have the code that reads all the transactions from the file and fills the `Bank` with them. The data is now ready for you to act on any commands your user provides.

## Asking for input

First things first, you'll need to write some code that gets input from the user and works out what command they are trying to run.

Try as much as possible to encapsulate this job in a method away from your `main` method, to keep your code clean and uncluttered.

## Acting on input

Once you know what command your user has entered, you'll need to write the code that acts on it. Work out what data you'll need to pull out of the `Bank`, and make sure that it (and the `Account` and `Transaction` classes) have appropriate methods or getters that allow you to have access to that data.

Then it's a matter of pulling the right data out of the `Bank` and displaying it in a nice format to the user. Fill in these method skeletons to do just that:

```java
private static void listAllAccounts(Bank bank) {
    // ...
}

private static void listSingleAccount(Bank bank, String accountName) {

}
```

Run your program a few times with different inputs and check that it works as you expect it to.

## Summary

The process you've followed is an important one that is often a good way to write more complex applications:

 - Start by deciding what data you need to work with and writing models that accurately represent that data.

 - Write the code that will translate the data from some data source into objects that your code understands.

 - Write the code that stores the data in your models.

 - Write the code that uses the data to achieve your application's aims.