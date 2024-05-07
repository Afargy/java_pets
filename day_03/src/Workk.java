package ex03;

public class Program {
    public static void main(String[] args) {
        Workk wr = new Workk();
        wr.runn();
    }
}

class CommonResource {
    Integer x = 0;

    public void incr() {
        ++x;
    }
}

class CountThread implements Runnable {
    CommonResource res;

    CountThread(CommonResource res) {
        this.res = res;
    }

    private void doTask() {
        synchronized (res) {
            System.out.println(Thread.currentThread().getName() + " " + res.x);
            res.incr();
        }
        try {
            Thread.sleep(100);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void run() {
        while (res.x < 20) {
            doTask();
        }
    }
}

public class Workk {
    public void runn() {
        CommonResource res = new CommonResource();
        Thread t1 = new Thread(new CountThread(res));
        Thread t2 = new Thread(new CountThread(res));
        t1.setName("Thread 1");
        t2.setName("Thread 2");

        t1.start();
        t2.start();
    }
}
