package ex02;

public class Argument {
    private Integer value = 0;

    Argument(String arg, String argPrefix, Integer min, Integer max)
            throws IllegalArgumentException {
        try {
            Integer tempValue = null;

            if (!arg.startsWith(argPrefix)) {
                throw new Exception("Error: wrong argument. "
                        + "Argument must start with " + argPrefix);
            }

            tempValue = Integer.parseUnsignedInt(arg.split("=")[1]);

            if ((tempValue < min) || (tempValue > max)) {
                throw new Exception("Error: " + argPrefix + " value must be "
                        + "a natural number between " + min + " and " + max);
            }

            this.value = tempValue;

        } catch (IndexOutOfBoundsException e) {
            throw new IllegalArgumentException("Wrong arument format."
                    + " Must be [--argumentPrefix]=[Value]");
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public Integer getValue() {
        return this.value;
    }

}
