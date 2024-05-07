package ex03;

public class ArgumentsParser {
    private Argument threadsCount = null;

    ArgumentsParser(String[] args) throws IllegalArgumentException {
        final Integer ARGUMETNS_COUNT = 1;

        try {

            if (args.length != ARGUMETNS_COUNT) {
                throw new Exception(
                        "Error: Expected " + ARGUMETNS_COUNT + " arguments");
            }

            threadsCount = new Argument(args[0], "--threadsCount", 1,
                    Runtime.getRuntime().availableProcessors());

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Integer getThreadsCount() {
        return threadsCount.getValue();
    }

}
