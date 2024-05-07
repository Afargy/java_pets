package ex02;

public class Summator implements Runnable {
    private CommonSum sum = null;
    private Integer[] array = null;
    private Integer begin = null;
    private Integer end = null;

    Summator(CommonSum sum, Integer[] array, Integer begin, Integer end) {
        this.sum = sum;
        this.array = array;
        this.begin = begin;
        this.end = end;
    }

    @Override
    public void run() {
        Integer tempSum = 0;

        for (Integer i = begin; i < end; ++i) {
            tempSum += array[i];
        }

        sum.add(tempSum);

        System.out.println(Thread.currentThread().getName() + " from " + begin
                + " to " + (end - 1) + " sum is " + tempSum);
    }

}
