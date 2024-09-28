package edu.school21.numbers;

public class NumberWorker {
    public boolean isPrime(int number) {
        boolean result = true;

        if (number < 2) {
            throw new IllegalNumberException();
        }

        for (int i = 2; i <= Math.sqrt(number); ++i) {
            if (number % i == 0) {
                result = false;
                break;
            }
        }

        return result;
    }

    public int digitsSum(int number) {
        int sum = 0;

        while (number > 0) {
            sum += (number % 10);
            number /= 10;
        }

        return sum;
    }
}
