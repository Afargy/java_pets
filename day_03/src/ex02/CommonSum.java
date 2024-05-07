package ex02;

public class CommonSum {
    private Integer sum = 0;

    public synchronized Integer add(Integer value) {
        sum += value;
        return sum;
    }

    public synchronized Integer get() {
        return sum;
    }

}
