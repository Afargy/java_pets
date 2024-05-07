package edu.school21.printer.logic;

public class ArgumentsParser {
    private char white = 0;
    private char black = 0;

    public ArgumentsParser(String[] args) throws IllegalArgumentException {
        final Integer ARGUMETNS_COUNT = 2;

        try {

            if (args.length != ARGUMETNS_COUNT) {
                throw new Exception(
                        "Error: Expected " + ARGUMETNS_COUNT + " arguments");
            }

            this.white = args[0].charAt(0);
            this.black = args[1].charAt(0);

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public char getWhite() {
        return this.white;
    }

    public char getBlack() {
        return this.black;
    }

}
