package ex00;

public class Program {
    public static void main(String[] args) {
        try {
            Integer times = new Count(args).getCount();
            Thread hen = new Thread(new Thing("Hen", times));
            Thread egg = new Thread(new Thing("Egg", times));

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
