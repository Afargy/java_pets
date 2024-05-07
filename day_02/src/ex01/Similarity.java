package ex01;

public class Similarity {
    private UniqueWords words = null;

    public Double count(String[] files) {
        Occurrences file1 = null;
        Occurrences file2 = null;

        words = new UniqueWords(files);
        file1 = words.countOccurrences(files[0]);
        file2 = words.countOccurrences(files[1]);

        return file1.countNumerator(file2) / file1.countDenominator(file2);
    }

    public void writeOutDicitionary(String path) {
        words.writeOutDictionary(path);
    }

}
