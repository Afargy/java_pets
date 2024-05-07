package ex00;

import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class SignaturesMap {
    private Map<String, String> signatures = new HashMap<String, String>();

    SignaturesMap() throws Exception {
        FileInputStream fin = new FileInputStream("ex00/signatures.txt");
        Scanner scanner = new Scanner(fin);

        while (scanner.hasNextLine()) {
            String[] line = scanner.nextLine().split(",");

            signatures.put(line[1].replaceAll("\\s", ""),
                    line[0].replaceAll("\\s", ""));
        }

        scanner.close();
        fin.close();
    }

    public String findFormat(String file) throws Exception {
        FileInputStream in = new FileInputStream(file);
        String format = null;

        try {
            String hex = "";

            for (int ch = in.read(); ch != -1; ch = in.read()) {
                hex += Integer.toHexString(ch).toUpperCase();
                format = signatures.get(hex);

                if ((format != null) || (hex.length() > 7)) {
                    break;
                }
            }

            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return format;
    }

}
