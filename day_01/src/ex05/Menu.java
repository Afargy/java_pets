package ex05;

import java.util.Scanner;
import java.util.UUID;

public class Menu {
    enum Mode {
        STANDART, DEVELOPER
    }

    private Scanner scanner = new Scanner(System.in);
    private Scanner line = null;
    private Integer menuMin = 1;
    private Integer menuMax = 5;
    private Integer menuItem = 0;
    private Mode mode = Mode.STANDART;
    private TransactionsService transactions = new TransactionsService();

    public void runMenu(Mode mode) throws IllegalArgumentException {
        setMode(mode);
        while (!menuItem.equals(menuMax)) {
            try {
                showMenu();
                scanMenuItem();
                if (menuItem.equals(menuMax)) {
                    break;
                }
                chooseOption();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void setMode(Mode mode) {
        this.mode = mode;
    }

    private void showMenu() {
        System.out.println("1. Add a user");
        System.out.println("2. View user balances");
        System.out.println("3. Perform a transfer");
        System.out.println("4. View all transactions for a specific user");
        if (mode.equals(Mode.DEVELOPER)) {
            System.out.println("5. DEV – remove a transfer by ID");
            System.out.println("6. DEV – check transfer validity");
            System.out.println("7. Finish execution");
            menuMax = 7;
        } else {
            System.out.println("5. Finish execution");
        }
    }

    private Integer scanMenuItem() throws IllegalArgumentException {
        scanNextLine();
        menuItem = scanNumber();

        if ((menuItem < menuMin) || (menuItem > menuMax)) {
            throw new IllegalMenuItemException();
        }
        return menuItem;
    }

    private void scanNextLine() {
        line = new Scanner(scanner.nextLine());
    }

    private Integer scanNumber() throws IllegalArgumentException {
        if (!line.hasNextInt()) {
            throw new IllegalArgumentException();
        }
        return line.nextInt();
    }

    private String scanNext() throws IllegalArgumentException {
        if (!line.hasNext()) {
            throw new IllegalArgumentException();
        }
        return line.next();
    }

    private void chooseOption() {
        switch (menuItem) {
        case 1:
            addUser();
            break;
        case 2:
            viewBalance();
            break;
        case 3:
            makeTransaction();
            break;
        case 4:
            getUserTransactions();
            break;
        case 5:
            removeTransaction();
            break;
        case 6:
            checkValidity();
            break;
        }
    }

    private void addUser() {
        User user = null;

        System.out.println("Enter a user name and a balance");
        scanNextLine();
        user = new User(scanNext(), scanNumber());
        transactions.addUser(user);
        System.out.println("User with id = " + user.getId() + " is added");
    }

    private void viewBalance() {
        System.out.println("Enter a user ID");
        scanNextLine();
        transactions.getUserBalance(scanNumber());
    }

    private void makeTransaction() {
        System.out.println(
                "Enter a sender ID, a recipient ID, and a transfer amount");
        scanNextLine();
        transactions.makeTransaction(scanNumber(), scanNumber(), scanNumber());
        System.out.println("The transfer is completed");
    }

    private void getUserTransactions() {
        Transaction[] userTransactions = null;

        System.out.println("Enter a user ID");
        scanNextLine();
        userTransactions = transactions.getUserTransaction(scanNumber());
        for (Transaction elem : userTransactions) {
            if (elem.getCategory().equals(Transaction.Category.CREDIT)) {
                System.out.print("To " + elem.getRecipient().getName());
                System.out.print("(id = " + elem.getRecipient().getId() + ")");
                System.out.print(elem.getAmount());
                System.out.println("with id = " + elem.getId());
            }
        }
    }

    private void removeTransaction() {
        System.out.println("Enter a user ID and a transfer ID");
        transactions.removeTransaction(scanNumber(),
                UUID.fromString(scanNext()));
    }

    private void checkValidity() {
        Transaction[] invalid = transactions.getUppairedTransactions();

        for (Transaction elem : invalid) {
            System.out.print(elem.getRecipient().getName());
            System.out.print("(id = " + elem.getRecipient().getId() + ") ");
            System.out.print("has an unacknowledged transfer id = ");
            System.out.print(elem.getId());
            System.out.print(" from " + elem.getSender().getName());
            System.out.print("(id = " + elem.getSender().getId() + ")");
            System.out.println(" for " + elem.getAmount());
        }
    }
}
