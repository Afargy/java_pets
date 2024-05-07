package ex00;

public class Count {
    private Integer count = 0;

    Count(String[] args) throws IllegalArgumentException {
        try {
            if (args.length != 1) {
                throw new Exception("Error: Expected 1 argument");
            }

            if (!args[0].startsWith("--count")) {
                throw new Exception("Error: first part must be --count");
            }

            try {
                Integer value = Integer.parseUnsignedInt(args[0].split("=")[1]);

                if ((value < 10) || (value > 100000)) {
                    throw new Exception();
                }

                this.count = value;

            } catch (Exception e) {
                throw new Exception("Error: count value must be "
                        + "a natural number between 10 and 1000000");
            }

        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Integer getCount() {
        return this.count;
    }

}
