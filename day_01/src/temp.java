// package ex05;

// import java.util.Scanner;

// public class Menu {
// enum Mode {
// STANDART, DEVELOPER
// }

// private Scanner scanner = new Scanner(System.in);
// private Scanner line = null;
// private Integer menuMin = 1;
// private Integer menuMax = 5;
// private Integer menuItem = 0;
// private Mode mode = Mode.STANDART;

// public void menu(Mode mode) throws IllegalArgumentException {
// setMode(mode);

// while (!menuItem.equals(menuMax)) {
// try {
// showMenu();
// scanMenuItem();
// if (menuItem.equals(menuMax)) {
// break;
// }
// chooseOption(menuItem);
// } catch (Exception e) {
// System.out.println(e.getMessage());
// }
// }
// }

// private void setMode(Mode mode) {
// this.mode = mode;
// }

// private void showMenu() {
// System.out.println("1. Add a user");
// System.out.println("2. View user balances");
// System.out.println("3. Perform a transfer");
// System.out.println("4. View all transactions for a specific user");
// if (mode.equals(Mode.DEVELOPER)) {
// System.out.println("5. DEV – remove a transfer by ID");
// System.out.println("6. DEV – check transfer validity");
// System.out.println("7. Finish execution");
// menuMax = 7;
// } else {
// System.out.println("5. Finish execution");
// }
// }

// public void chooseOption(Integer item) {
// switch (menuItem) {
// case 1:
// System.out.println("add user");
// break;
// case 2:
// System.out.println("view balances");
// break;
// case 3:
// System.out.println("Perform transfer");
// break;
// case 4:
// System.out.println("View all transactions");
// break;
// case 5:
// System.out.println("DEV - remove a transfer");
// break;
// case 6:
// System.out.println("DEV - check validity");
// break;
// }
// }

// public Integer scanMenuItem() throws IllegalArgumentException {
// scanner.nextInt();

// if ((menuItem < menuMin) || (menuItem > menuMax)) {
// throw new IllegalMenuItemException();
// }
// return menuItem;
// }

// public void addUserOption() {
// String name = null;
// Integer balance = null;

// System.out.println("Enter a user name and a balance");
// name = scanner.next();
// balance = scanner.nextInt();
// System.out.println(name + " " + balance);
// }

// private void scanNextLine() {
// line = new Scanner(scanner.nextLine());
// }

// private Integer scanNumber() throws IllegalArgumentException {
// if (!line.hasNextInt()) {
// throw new IllegalMenuItemException();
// }
// return line.nextInt();
// }

// private String scanNext() throws IllegalAccessException {
// if (!line.hasNext()) {
// throw new IllegalMenuItemException();
// }
// return line.next();
// }
// }
