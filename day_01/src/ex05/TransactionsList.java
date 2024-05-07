package ex05;

import java.util.UUID;

public interface TransactionsList {
    public void addTransaction(Transaction transaction);

    public void removeTransaction(UUID id) throws TransactionNotFoundException;

    public Transaction[] toArray();
}
