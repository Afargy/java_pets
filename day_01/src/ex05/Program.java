package ex05;

public class Program {
    private static Menu.Mode mode = Menu.Mode.STANDART;
    private static Menu menu = new Menu();

    public static void main(String[] args) {
        if (args.length > 0 && args[0].equals("--profile=dev")) {
            System.out.println("dev mode");
            mode = Menu.Mode.DEVELOPER;
        }
        menu.runMenu(mode);
    }
}
