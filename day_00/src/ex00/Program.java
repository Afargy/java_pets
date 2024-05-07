package ex00;

public class Program {
    private static final int NUMBER = 479598;

    public static void main(String args[]) {
        int sum = 0;

        for (int number = NUMBER; number > 0; number /= 10) {
            sum += number % 10;
        }
        System.out.println(sum);
    }
}
