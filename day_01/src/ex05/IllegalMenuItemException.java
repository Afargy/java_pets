package ex05;

class IllegalMenuItemException extends IllegalArgumentException {
    public IllegalMenuItemException() {
        super("Not valid item");
    }
}
