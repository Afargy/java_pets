package ex03;

import java.util.Scanner;

public class Program {
    private static final int MAX_WEEK = 18;
    private static final int GRADES_IN_LINE = 5;
    private static final int GRADE_MAX_VALUE = 9;
    private static final int GRADE_MIN_VALUE = 1;
    private static int week = 0;
    private static String minGrades = "";

    public static void main(String[] args) {
        readInput();
        printGraph();
    }

    private static void readInput() {
        Scanner input = new Scanner(System.in);

        for (String line = ""; week < MAX_WEEK; ++week) {
            line = input.nextLine();
            if (line.equals("42")) {
                break;
            }
            shutDownIf(!line.equals("Week " + (week + 1)));
            minGrades += returnMinGradeInLine(input.nextLine()) + " ";
        }
        input.close();
    }

    private static void shutDownIf(boolean condition) {
        if (condition) {
            System.err.println("IllegalArgument");
            System.exit(-1);
        }
    }

    private static int returnMinGradeInLine(String line) {
        Scanner input = new Scanner(line);
        int minGrade = GRADE_MAX_VALUE + 1;

        for (int i = 0, grade = 0; i < GRADES_IN_LINE; ++i) {
            shutDownIf(!input.hasNextInt());
            grade = input.nextInt();
            shutDownIf(grade < GRADE_MIN_VALUE || grade > GRADE_MAX_VALUE);
            minGrade = (minGrade < grade ? minGrade : grade);
        }
        shutDownIf(input.hasNextLine());
        input.close();
        return minGrade;
    }

    private static void printGraph() {
        Scanner input = new Scanner(minGrades);

        for (int i = 0; i < week; ++i) {
            for (int j = 0, temp = input.nextInt(); j < temp; ++j) {
                System.err.print("=");
            }
            System.err.println(">");
        }
        input.close();
    }
}
