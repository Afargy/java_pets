package ex02;

public class ArgumentsParser {
    private Argument arraySize = null;;
    private Argument threadsCount = null;

    ArgumentsParser(String[] args) throws IllegalArgumentException {
        final Integer ARGUMETNS_COUNT = 2;

        try {

            if (args.length != ARGUMETNS_COUNT) {
                throw new Exception("Error: Expected 2 arguments");
            }

            arraySize = new Argument(args[0], "--arraySize", 1, 2_000_000);
            threadsCount = new Argument(args[1], "--threadsCount", 1,
                    Runtime.getRuntime().availableProcessors());

            if (arraySize.getValue() / threadsCount.getValue() == 0) {
                throw new Exception("Too many threads["
                        + threadsCount.getValue() + "] for this array."
                        + " Array length is " + arraySize.getValue());
            }

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Integer getArraySize() {
        return arraySize.getValue();
    }

    public Integer getThreadsCount() {
        return threadsCount.getValue();
    }

}
