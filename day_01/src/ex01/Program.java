package ex01;

public class Program {
    public static void main(String[] args) {
        User u1 = new User("B");
        User u2 = new User("B");
        User u3 = new User("B");
        User u4 = new User("B");
        User u5 = new User("B");

        System.out.println(u1.getId());
        System.out.println(u2.getId());
        System.out.println(u3.getId());
        System.out.println(u4.getId());
        System.out.println(u5.getId());
    }
}
