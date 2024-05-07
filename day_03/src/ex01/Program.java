package ex01;

public class Program {
    public static void main(String[] args) {
        try {
            Integer times = new Count(args).getCount();
            Object monitor = new Object();
            Thread hen = new Thread(new Thing("Hen", times, monitor));
            Thread egg = new Thread(new Thing("Egg", times, monitor));

            hen.start();
            egg.start();

            hen.join();
            egg.join();

            for (Integer i = 0; i < times; ++i) {
                System.out.println("Human");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
