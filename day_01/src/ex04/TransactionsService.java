package ex04;

import java.util.UUID;

public class TransactionsService {
    private UsersList users = new UsersArrayList();
    private TransactionsLinkedList transactions = new TransactionsLinkedList();
    private TransactionsLinkedList unpaired = new TransactionsLinkedList();

    public void addUser(User user) {
        users.addUser(user);
    }

    public Integer getUserBalance(Integer userId) {
        return users.getUserById(userId).getBalance();
    }

    public void makeTransaction(Integer senderId, Integer reciverId,
            Integer amount) throws IllegalTransactionException {
        User sender = users.getUserById(senderId);
        User reciver = users.getUserById(reciverId);
        UUID id = UUID.randomUUID();
        Transaction debit = new Transaction(id, sender, reciver,
                Transaction.Category.DEBIT, amount);
        Transaction credit = new Transaction(id, sender, reciver,
                Transaction.Category.CREDIT, -amount);
        if (users.getUserById(senderId).getBalance() < amount) {
            unpaired.addTransaction(debit);
            throw new IllegalTransactionException("Sender balance not enough");
        }
        transactions.addTransaction(debit);
        transactions.addTransaction(credit);
        sender.setBalance(sender.getBalance() - amount);
        reciver.setBalance(reciver.getBalance() + amount);
    }

    public Transaction[] getUserTransaction(Integer userId) {
        TransactionsLinkedList userTransactions = new TransactionsLinkedList();
        TransactionsLinkedList.Node cur = transactions.getHead();

        for (int i = 0; i < transactions.getSize(); ++i) {
            if (cur.getData().getSender().getId().equals(userId)) {
                userTransactions.addTransaction(cur.getData());
            } else if (cur.getData().getRecipient().getId().equals(userId)) {
                userTransactions.addTransaction(cur.getData());
            }
            cur = cur.getNext();
        }
        return userTransactions.toArray();
    }

    public Transaction[] getUppairedTransactions() {
        return unpaired.toArray();
    }

    public void removeTransaction(Integer userId, UUID transaction) {
        transactions.removeTransaction(transaction);
    }
}
