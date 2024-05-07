package ex05;

import java.util.Scanner;

public class Program {
    private static final int STUDENTS = 10;
    private static final int CLASSES = 10;

    private static final int WEEK_LEN = 7;
    private static final String[] WEEK = { "MO", "TU", "WE", "TH", "FR", "SA",
            "SU" };

    private static final String FIRST_DAY = "TU";
    private static final int MONTH_LEN = 30;
    private static final int HEADER_WIDTH = 1;

    private static Scanner input = new Scanner(System.in);
    private static String token = "";
    private static String[] names = new String[STUDENTS];
    private static String[] weekSchedule = new String[WEEK_LEN];

    private static String[][] table = null;
    private static int width = 0;
    private static int height = 0;

    public static void main(String[] args) {
        parseNames();
        parseSchedule();
        buildTable();
        parseAttendance();
        printTable();
    }

    private static void parseNames() {
        initNames();
        scanNames();
    }

    private static void initNames() {
        for (int i = 0; i < STUDENTS; ++i) {
            names[i] = "";
        }
    }

    private static void scanNames() {
        for (int i = 0; i < STUDENTS; ++i) {
            readToken();
            if (token.equals(".")) {
                break;
            }
            names[i] = token;
        }
    }

    private static String readToken() {
        token = input.next();
        return token;
    }

    private static void parseSchedule() {
        initWeekSchedule();
        scanWeekSchedule();
        arrangeClasses();
    }

    private static void initWeekSchedule() {
        for (int i = 0; i < WEEK_LEN; ++i) {
            weekSchedule[i] = "";
        }
    }

    private static void scanWeekSchedule() {
        for (int i = 0; i < CLASSES; ++i) {
            readToken();
            if (token.equals(".")) {
                break;
            }
            weekSchedule[getDayWeekIndex(input.next())] += token;
        }
    }

    private static int getDayWeekIndex(String day) {
        for (int i = 0; i < WEEK_LEN; ++i) {
            if (day.equals(WEEK[i])) {
                return i;
            }
        }
        return -1;
    }

    private static void arrangeClasses() {
        for (int i = 0; i < WEEK_LEN; ++i) {
            arrangeDay(i);
        }
    }

    private static void arrangeDay(int day) {
        char[] line = weekSchedule[day].toCharArray();
        int len = weekSchedule[day].length();

        line = bubbleSort(line, len);
        weekSchedule[day] = "";
        for (int i = 0; i < len; ++i) {
            weekSchedule[day] += line[i];
        }
    }

    private static char[] bubbleSort(char[] line, int len) {
        char temp = 0;

        for (int i = len - 1; i >= 1; --i) {
            for (int j = 0; j < i; ++j) {
                if (line[j] > line[j + 1]) {
                    temp = line[j];
                    line[j] = line[j + 1];
                    line[j + 1] = temp;
                }
            }
        }
        return line;
    }

    private static void buildTable() {
        countTableHeight();
        countTableWidth();
        table = new String[height][width];
        initTable();
        fillNames();
        fillClases();
    }

    private static void countTableHeight() {
        height = countInsertedNames() + HEADER_WIDTH;
    }

    private static int countInsertedNames() {
        int inserted = 0;
        for (int i = 0; names[i].length() > 0; ++i) {
            ++inserted;
        }
        return inserted;
    }

    private static void countTableWidth() {
        width = (countTotalClasees() * 3) + HEADER_WIDTH;
    }

    private static int countTotalClasees() {
        int total = 0;
        int firstDay = getDayWeekIndex(FIRST_DAY);
        int monthLen = MONTH_LEN + firstDay;

        for (int i = firstDay; i < monthLen; ++i) {
            total += weekSchedule[i % WEEK_LEN].length();
        }
        return total;
    }

    private static void initTable() {
        for (int i = 0; i < height; ++i) {
            for (int j = 0; j < width; ++j) {
                table[i][j] = "";
            }
        }
    }

    private static void fillNames() {

        for (int i = HEADER_WIDTH; i < height; ++i) {
            table[i][0] = names[i - 1];
        }
    }

    private static void fillClases() {
        int firstDay = getDayWeekIndex(FIRST_DAY);
        int monthLen = MONTH_LEN + firstDay;

        for (int i = firstDay, index = HEADER_WIDTH; i < monthLen; ++i) {
            if (weekSchedule[i % WEEK_LEN].length() > 0) {
                index = fillDay(index, i % WEEK_LEN, i - firstDay);
            }
        }
    }

    private static int fillDay(int index, int day, int date) {
        int filled = index;
        int classesInDay = weekSchedule[day].length();

        for (int i = 0; i < classesInDay; ++i) {
            table[0][filled++] += weekSchedule[day].toCharArray()[i];
            table[0][filled++] = WEEK[day];
            table[0][filled++] += (date + 1);
        }
        return filled;
    }

    private static void parseAttendance() {
        int student = 0;
        int date = 0;
        int status = 0;

        readToken();
        while (!token.equals(".")) {
            student = findStudent();
            date = findDate();
            status = scanStatus();
            table[student][date] += status;
            readToken();
        }
    }

    private static int findStudent() {
        int found = 0;
        while (found < height) {
            ++found;
            if (token.equals(table[found][0])) {
                break;
            }
        }
        return found;
    }

    private static int findDate() {
        String time = readToken();
        int found = 0;

        readToken();
        for (int i = HEADER_WIDTH; i < (width / 3) + HEADER_WIDTH; ++i) {
            if ((table[0][i * 3].equals(token))
                    && (table[0][i * 3 - 2].equals(time))) {
                found = i * 3;
                break;
            }
        }
        return found;

    }

    private static int scanStatus() {
        readToken();
        return ((token.equals("HERE")) ? 1 : -1);
    }

    private static void printTable() {
        printHeader();
        printBody();
    }

    private static void printHeader() {
        for (int i = 0; i < width; ++i) {
            if (i == 0) {
                System.err.format("%10s", "");
            } else {
                System.out.format("%4s", table[0][i++] + ":00");
                System.out.format("%3s", table[0][i++]);
                System.out.format("%3s", table[0][i]);
                System.err.print("|");
            }
        }
        System.out.println();
    }

    private static void printBody() {
        for (int i = HEADER_WIDTH; i < height; ++i) {
            for (int j = 0; j < (width / 3); ++j) {
                if (j == 0) {
                    System.out.format("%10s", table[i][j]);
                } else {
                    System.out.format("%10s|", table[i][j * 3]);
                }
            }
            System.out.format("%11s\n", "|");
        }
    }
}
