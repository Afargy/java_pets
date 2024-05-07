package ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class UniqueWords {
    private final String SEPARATORS = "[.,;:\\s]+";
    private Map<String, Integer> words = new TreeMap<String, Integer>();

    UniqueWords(String[] files) {
        for (String file : files) {
            try (BufferedReader in = new BufferedReader(new FileReader(file))) {
                String line = null;

                while ((line = in.readLine()) != null) {
                    for (String word : line.split(SEPARATORS)) {
                        words.put(word, 0);
                    }
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Occurrences countOccurrences(String file) {
        Map<String, Integer> counter = new TreeMap<String, Integer>(words);

        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line = null;

            while ((line = in.readLine()) != null) {
                for (String word : line.split(SEPARATORS)) {
                    counter.put(word, (counter.get(word) + 1));
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return new Occurrences(counter);
    }

    public void writeOutDictionary(String path) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (String key : words.keySet()) {
                writer.write(key + "\n");
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

}
