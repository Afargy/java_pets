package ex02;

public class Program {
    public static void main(String[] args) {
        try {
            ArgumentsValidator validator = new ArgumentsValidator();
            FileManager manager = null;

            validator.validate(args);
            manager = new FileManager(args[0].split("=")[1]);
            manager.run();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
