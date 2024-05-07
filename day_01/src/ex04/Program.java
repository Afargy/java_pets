package ex04;

public class Program {
    private static TransactionsService transactions = new TransactionsService();

    public static void main(String[] args) {
        addUsers();
        getBalance();
        makeTransaction();
        getBalance();
        makeInvalidTransaction();
        getUserTransaction(1);
        getUppairedTransactions();
        removeTransaction();
        getUserTransaction(1);
    }

    private static void addUsers() {
        transactions.addUser(new User("John", 500));
        transactions.addUser(new User("Mike", 600));
        transactions.addUser(new User("Joe", 700));
    }

    private static void getBalance() {
        System.out.println(transactions.getUserBalance(1));
        System.out.println(transactions.getUserBalance(2));
        System.out.println(transactions.getUserBalance(3));
    }

    private static void makeTransaction() {
        transactions.makeTransaction(1, 2, 100);
        transactions.makeTransaction(1, 3, 200);
    }

    private static void makeInvalidTransaction() {
        try {
            transactions.makeTransaction(1, 2, 1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getUserTransaction(Integer userId) {
        Transaction[] userTransaction = transactions.getUserTransaction(userId);

        for (Transaction elem : userTransaction) {
            showTransaction(elem);
        }
    }

    private static void getUppairedTransactions() {
        System.out.println("UNPAIRED:");
        for (Transaction elem : transactions.getUppairedTransactions()) {
            showTransaction(elem);
        }
    }

    private static void showTransaction(Transaction transaction) {
        System.out.print("Transaction ID is ");
        System.out.println(transaction.getId());
        System.out.print("Sender is ");
        System.out.println(transaction.getSender().getName());
        System.out.print("Recipient is ");
        System.out.println(transaction.getRecipient().getName());
        System.out.print("Category is ");
        System.out.println(transaction.getCategory());
        System.out.print("Amount is ");
        System.out.println(transaction.getAmount());
    }

    private static void removeTransaction() {
        Transaction[] transaction = transactions.getUserTransaction(1);

        System.out.println("Remove:");
        transactions.removeTransaction(1, transaction[0].getId());
    }
}
