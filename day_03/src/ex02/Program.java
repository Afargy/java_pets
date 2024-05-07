package ex02;

import java.util.Random;

public class Program {
    private static ArgumentsParser arguments = null;
    private static Integer[] array = null;

    public static void main(String[] args) {
        try {
            arguments = new ArgumentsParser(args);
            array = new Random().ints(arguments.getArraySize(), -1000, 1000)
                    .mapToObj(Integer::valueOf).toArray(Integer[]::new);

            getSumByStandartWay();
            getSumByThreads();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void getSumByStandartWay() {
        Integer sum = 0;

        for (int i = 0; i < array.length; ++i) {
            sum += array[i];
        }

        System.out.println("Sum: " + sum);
    }

    private static void getSumByThreads() {
        CommonSum sum = new CommonSum();
        Integer threadsCount = arguments.getThreadsCount();
        Thread t = null;
        Integer step = array.length / threadsCount;
        Integer begin = 0;
        Integer end = 0;

        for (int i = 0; i < threadsCount; ++i) {
            begin = end;

            if (i == (threadsCount - 1)) {
                end = array.length;
            } else {
                end += step;
            }

            t = new Thread(new Summator(sum, array, begin, end));
            t.setName("Thread " + (i + 1));
            t.start();
        }

        while (Thread.activeCount() > 1) {
            try {
                Thread.sleep(10);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        System.out.println("Sum by threads: " + sum.add(0));
    }
}
