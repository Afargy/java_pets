package ex01;

import java.util.Map;
import java.util.Vector;

public class Occurrences {
    Vector<Integer> occurences = null;

    Occurrences(Map<String, Integer> counter) {
        occurences = new Vector<>(counter.values());
    }

    public Integer countNumerator(Occurrences other) {
        Integer result = 0;

        for (Integer i = 0; i < occurences.size(); ++i) {
            result += occurences.get(i) * other.occurences.get(i);
        }

        return result;
    }

    public Double countDenominator(Occurrences other) {
        Double result = 0.0;
        Double a = 0.0;
        Double b = 0.0;

        for (Integer i = 0; i < occurences.size(); ++i) {
            a += occurences.get(i) * occurences.get(i);
            b += other.occurences.get(i) * other.occurences.get(i);
        }

        result = Math.sqrt(a) * Math.sqrt(b);

        return result;
    }

}
