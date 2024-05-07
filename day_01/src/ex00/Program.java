package ex00;

import java.util.UUID;

public class Program {
    private static Transaction transaction = null;

    public static void main(String[] args) {
        checkUserClass();
        checkTransactionClass();
    }

    private static void checkUserClass() {
        showUser(new User("John", 500));
        showUser(new User("Mike", 0));
        showUser(new User("Joe", -123));
        System.out.println();
    }

    private static void checkTransactionClass() {
        User john = new User("John");
        User mike = new User("Mike", 100);

        makeTransaction(new Transaction(UUID.randomUUID(), john, mike,
                Transaction.Category.DEBIT, -500));
        makeTransaction(new Transaction(UUID.randomUUID(), john, mike,
                Transaction.Category.CREDIT, 500));
        makeTransaction(new Transaction(UUID.randomUUID(), john, mike,
                Transaction.Category.DEBIT, 500));
        makeTransaction(new Transaction(UUID.randomUUID(), john, mike,
                Transaction.Category.CREDIT, -500));
    }

    private static void makeTransaction(Transaction data) {
        transaction = data;
        showTransactionInfo(transaction);
    }

    private static void showTransactionInfo(Transaction transaction) {
        System.out.println("Transaction info: ");
        System.out.println("UUID is " + transaction.getId() + ". ");
        System.out.println("Category is " + transaction.getCategory() + ". ");
        showUser("Sender is ", transaction.getSender());
        showUser("Recipient is ", transaction.getRecipient());
        System.out.println("Amount is " + transaction.getAmount());
        System.out.println();
    }

    private static void showUser(String header, User user) {
        System.out.print(header);
        showUser(user);
    }

    private static void showUser(User user) {
        System.out.print(user.getName() + ". ");
        System.out.print("ID is " + user.getId() + ". ");
        System.out.println("balance " + user.getBalance() + ".");
    }
}
