package edu.school21.numbers;

public class IllegalNumberException extends RuntimeException {
    public IllegalNumberException() {
        super("Wrong number. Number must be positive and bigger than 1");
    }
}
