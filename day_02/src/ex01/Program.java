package ex01;

public class Program {
    public static void main(String[] args) {
        Similarity similarity = new Similarity();
        ArgumentValidator validator = new ArgumentValidator();

        try {
            validator.validate(args);
            System.out.format("%.2f", similarity.count(args));
            similarity.writeOutDicitionary("ex01/dictionary.txt");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
