package ex03;

import java.util.UUID;

public class Program {
    private static TransactionsLinkedList list = new TransactionsLinkedList();

    public static void main(String[] args) {
        addTransactions(3);
        list.show();
        System.out.println("\nRemove first");
        list.removeTransaction(list.getHead().getData().getId());
        list.show();
        try {
            list.removeTransaction(UUID.randomUUID());
        } catch (Exception e) {
            System.out.println("Try delete invalid ID: " + e.getMessage());
        }
        toArray();
    }

    private static void addTransactions(Integer usersNumber) {
        for (int i = 0; i < usersNumber; ++i) {
            User sender = new User("sender_" + (i + 1), 500);
            User reciver = new User("reciver_" + (i + 1), 500);
            Transaction.Category type = Transaction.Category.CREDIT;
            Integer amount = 100;

            list.addTransaction(new Transaction(UUID.randomUUID(), sender,
                    reciver, type, amount));
        }
    }

    private static void toArray() {
        Transaction[] array = null;

        array = list.toArray();
        for (int i = 0; i < list.getSize(); ++i) {
            System.out.println("Elem #" + (i + 1) + ".");
            System.out.print(
                    "sender is " + array[i].getSender().getName() + ". ");
            System.out.print(
                    "recipient is " + array[i].getRecipient().getName() + ". ");
            System.out.print("ID is " + array[i].getId() + ". ");
            System.out.println("amount is " + array[i].getAmount() + ".");
        }
    }
}
