package ex02;

import java.util.Scanner;

public class Program {
    private static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int primeCounter = 0;
        int number = 0;

        while (number != 42) {
            number = scanNumber();
            shutDownIf(number < 2);
            primeCounter += (chekcIsPrime(calculateDigitsSum(number)) ? 1 : 0);
        }
        System.err.println("Count of coffee-request -" + primeCounter);
    }

    private static int scanNumber() {
        int number = 0;

        shutDownIf(!input.hasNextInt());
        number = input.nextInt();
        shutDownIf(!input.nextLine().equals(""));
        return number;
    }

    private static void shutDownIf(boolean condition) {
        if (condition) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
    }

    private static int calculateDigitsSum(int number) {
        int sum = 0;

        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    private static boolean chekcIsPrime(int number) {
        for (int i = 2; i * i <= number; ++i) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
