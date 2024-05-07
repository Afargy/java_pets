package ex04;

import java.util.Scanner;

public class Program {
    private static final int DIFFERENT_CHARS_RANGE = 65536;
    private static final int TOP_MATHCES_RANGE = 10;
    private static final int PATTERN_CHAR = '#';
    private static final int WHITE_SPACE_CHAR = ' ';

    private static final int GRAPH_HEIGHT = 10;
    private static final int GRAPH_WIDTH = TOP_MATHCES_RANGE;
    private static final int MATHCH_LINE_HEIGHT = 1;
    private static final int CHAR_LINE_HEIGHT = 1;
    private static final int FULL_GRAPH_HEIGHT = GRAPH_HEIGHT
            + MATHCH_LINE_HEIGHT + CHAR_LINE_HEIGHT;

    private static int[] matches = new int[DIFFERENT_CHARS_RANGE];
    private static int[] topChars = new int[GRAPH_WIDTH];
    private static int[] graphLines = new int[GRAPH_WIDTH];
    private static int[] whiteSpaces = new int[GRAPH_WIDTH];

    public static void main(String[] args) {
        countMatchesFromInput();
        findTops();
        countGraphLines();
        countWhiteSpaces();
        printGraph();
    }

    private static void countMatchesFromInput() {
        Scanner input = new Scanner(System.in);

        for (char elem : input.nextLine().toCharArray()) {
            ++matches[elem];
        }
        input.close();
    }

    private static void findTops() {
        for (int i = 0; i < DIFFERENT_CHARS_RANGE; ++i) {
            for (int j = 0; j < TOP_MATHCES_RANGE; ++j) {
                if (topChars[j] == -1 || matches[topChars[j]] < matches[i]) {
                    moveRight(j);
                    topChars[j] = i;
                    break;
                }
            }
        }
    }

    private static void moveRight(int insertPosition) {
        for (int i = GRAPH_WIDTH - 1; i > 0 + insertPosition; --i) {
            topChars[i] = topChars[i - 1];
        }
    }

    private static void countGraphLines() {
        double scaleFactor = countScaleFactor();

        for (int i = 0; i < GRAPH_WIDTH; ++i) {
            int scaled = (int) (matches[topChars[i]] / scaleFactor);

            if (scaled > GRAPH_HEIGHT) {
                scaled = GRAPH_HEIGHT;
            }
            graphLines[i] = scaled;
        }
    }

    private static double countScaleFactor() {
        double scaleFactor = 1;
        double maxMatch = matches[topChars[0]];

        while (maxMatch > GRAPH_HEIGHT) {
            maxMatch /= GRAPH_HEIGHT;
            scaleFactor = maxMatch;
        }
        return scaleFactor;
    }

    private static void countWhiteSpaces() {
        for (int i = 0; i < GRAPH_WIDTH; ++i) {
            if (matches[topChars[i]] == 0) {
                whiteSpaces[i] = FULL_GRAPH_HEIGHT;
            } else {
                whiteSpaces[i] = GRAPH_HEIGHT - graphLines[i];
            }
        }
    }

    private static void printGraph() {
        for (int i = 0; i < FULL_GRAPH_HEIGHT; ++i) {
            for (int j = 0; j < GRAPH_WIDTH; ++j) {
                if (i < whiteSpaces[j]) {
                    System.out.format("%3c", WHITE_SPACE_CHAR);
                } else if (i == whiteSpaces[j]) {
                    System.out.format("%3d", matches[topChars[j]]);
                } else if (i < graphLines[j] + whiteSpaces[j] + 1) {
                    System.out.format("%3c", PATTERN_CHAR);
                } else if (i == graphLines[j] + whiteSpaces[j] + 1) {
                    System.out.format("%3c", topChars[j]);
                }
            }
            System.out.println();
        }
    }
}
