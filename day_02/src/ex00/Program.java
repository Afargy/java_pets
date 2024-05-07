package ex00;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        try {
            ResultWriter result = new ResultWriter();
            SignaturesMap signatures = new SignaturesMap();
            Scanner input = new Scanner(System.in);
            String file = null;

            while (file != "42") {
                try {
                    file = input.nextLine();
                    result.write(signatures.findFormat(file));
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            }

            input.close();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
