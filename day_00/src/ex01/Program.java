package ex01;

import java.util.Scanner;

public class Program {
    private static int number = 0;
    private static int comparasionCounter = 0;

    public static void main(String[] args) {
        scanNumber();
        shutDownIf(number < 2);
        showResult(chekcIsPrime());
    }

    private static void scanNumber() {
        Scanner input = new Scanner(System.in);

        shutDownIf(!input.hasNextInt());
        number = input.nextInt();
        shutDownIf(!input.nextLine().equals(""));
        input.close();
    }

    private static void shutDownIf(boolean condition) {
        if (condition) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
    }

    private static boolean chekcIsPrime() {
        ++comparasionCounter;
        for (int i = 2; i * i <= number; ++i) {
            if (number % i == 0) {
                return false;
            }
            ++comparasionCounter;
        }
        return true;
    }

    private static void showResult(boolean result) {
        System.err.println(result + " " + comparasionCounter);
    }
}
