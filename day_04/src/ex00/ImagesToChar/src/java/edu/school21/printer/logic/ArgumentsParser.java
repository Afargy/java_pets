package edu.school21.printer.logic;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ArgumentsParser {
    private char white = 0;
    private char black = 0;
    private Path path = null;

    public ArgumentsParser(String[] args) throws IllegalArgumentException {
        final Integer ARGUMETNS_COUNT = 3;

        try {

            if (args.length != ARGUMETNS_COUNT) {
                throw new Exception(
                        "Error: Expected " + ARGUMETNS_COUNT + " arguments");
            }

            this.white = args[0].charAt(0);
            this.black = args[1].charAt(0);
            this.path = Paths.get(args[2]);

            if (!this.path.isAbsolute()) {
                throw new Exception("Error: Expected absolute path");
            }

            if (!this.path.toFile().exists()) {
                throw new Exception("Error: File doesn't exist");
            }

            if (!this.path.toString().endsWith(".bmp")) {
                throw new Exception("Error: Wrong extention. .bmp expected");
            }

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

    public Path getPath() {
        return this.path;
    }

}
