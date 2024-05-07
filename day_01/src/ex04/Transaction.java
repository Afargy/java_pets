package ex04;

import java.util.UUID;

public class Transaction {
    enum Category {
        DEBIT, CREDIT
    }

    private UUID id = null;
    private User sender = null;
    private User recipient = null;
    private Category category = null;
    private Integer amount = null;

    public Transaction(UUID id, User sender, User recipient, Category category,
            Integer amount) {
        setId(id);
        setSender(sender);
        setRecipient(recipient);
        setCategory(category);
        setAmount(checkAmount(amount, category));
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getRecipient() {
        return recipient;
    }

    public void setRecipient(User recipient) {
        this.recipient = recipient;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Transaction.Category category) {
        this.category = category;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    private Integer checkAmount(Integer amount, Transaction.Category category) {
        if (((category.equals(Category.DEBIT)) && (amount < 0))) {
            amount = 0;
        } else if (((category.equals(Category.CREDIT)) && (amount > 0))) {
            amount = 0;
        }
        return amount;
    }
}
