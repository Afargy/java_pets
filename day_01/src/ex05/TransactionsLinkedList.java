package ex05;

import java.util.UUID;

public class TransactionsLinkedList implements TransactionsList {
    private Integer size = 0;
    private Node head = null;
    private Node tail = null;

    public class Node {
        private Node next = null;
        private Node prev = null;
        private Transaction data = null;

        public Node(Transaction transaction) {
            data = transaction;
        }

        public void show() {
            System.out.print("prev is " + prev + ". ");
            System.out.println("next is " + next + ".");
            System.out.print("sender is " + data.getSender().getName() + ". ");
            System.out.print(
                    "recipient is " + data.getRecipient().getName() + ". ");
            System.out.print("ID is " + data.getId() + ". ");
            System.out.println("amount is " + data.getAmount() + ".");
        }

        public Transaction getData() {
            return data;
        }

        public Node getNext() {
            return next;
        }
    }

    @Override
    public void addTransaction(Transaction transaction) {
        Node node = new Node(transaction);

        if (size.equals(0)) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.prev = tail;
            tail = node;
        }
        ++size;
    }

    @Override
    public void removeTransaction(UUID id) throws TransactionNotFoundException {
        Node node = findNode(id);

        System.out.print("Transfer To " + node.data.getRecipient().getName());
        System.out.print("(id = " + node.data.getRecipient().getId() + ") ");
        System.out.println(node.data.getAmount() + " removed");
        removeNode(node);
        --size;
    }

    @Override
    public Transaction[] toArray() {
        Transaction[] transactions = new Transaction[size];
        Node curNode = head;

        for (int i = 0; i < size; ++i) {
            transactions[i] = curNode.data;
            curNode = curNode.next;
        }
        return transactions;
    }

    private void removeNode(Node node) {
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev;
        }

        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next;
        }
    }

    private Node findNode(UUID id) throws TransactionNotFoundException {
        Node node = head;

        for (int i = 0; i < size; ++i) {
            if (node.data.getId().equals(id)) {
                break;
            }
            node = node.next;
        }

        if (node == null) {
            throw new TransactionNotFoundException("Transaction not found");
        }

        return node;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public Integer getSize() {
        return size;
    }

    public void show() {
        Node curNode = head;

        for (int i = 0; i < size; ++i) {
            System.out.println("Transaction #" + (i + 1) + ".");
            curNode.show();
            curNode = curNode.next;
        }
    }
}
