package ex02;

public class ArgumentsValidator {

    public void validate(String[] args) throws Exception {
        validateNumber(args);
        validateFormat(args[0]);
    }

    private void validateNumber(String[] args) throws IllegalArgumentException {
        if (args.length != 1) {
            throw new IllegalArgumentException("One argument expected");
        }
    }

    private void validateFormat(String arg) throws IllegalArgumentException {
        String[] args = arg.split("=");

        if ((args.length != 2) && (args[0] != "--current-folder")) {
            throw new IllegalArgumentException("Invalid format");
        }
    }

}
