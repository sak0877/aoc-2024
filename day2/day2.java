import java.io.*;
import java.util.*;

class Main {

    public static int swapDiff(int num1, int num2) {
        System.out.print(num1 + " - " + num2);
        if (num1 < num2) {
            int tmp = num1;
            num1 = num2;
            num2 = tmp;
        }
        System.out.println(" = " + (num1 - num2));
        return num1 - num2;
    }

    public static boolean unsafeDistance(int num1, int num2, int num3) {
        return ((swapDiff(num2, num1) > 3) || (swapDiff(num2, num3) > 3) ||
                (swapDiff(num2, num1) < 1) || (swapDiff(num2, num3) > 3));
    }

    public static int part1(int[][] report) {
        int safeCount = 0;
        boolean levelSafe;
        for (int i = 0; i < report.length; i++) {
            levelSafe = true;
            for (int j = 1; j < report[i].length - 1; j++) {
                if (unsafeDistance(report[i][j-1], report[i][j], report[i][j+1]) ||
                    (report[i][j-1] > report[i][j]) && (report[i][j] < report[i][j+1]) ||
                    (report[i][j-1] < report[i][j]) && (report[i][j] > report[i][j+1]) ||
                    (report[i][j] == report[i][j+1])) {
                    levelSafe = false;
                }
            }
            System.out.println(levelSafe);
            if (levelSafe) {
                safeCount++;
            }
        }
        return safeCount;
    }

    // TODO: Part 2

    public static void main(String[] args) {
        ArrayList<int[]> reportList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("2.in"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(" ");
                int[] row = new int[values.length];
                for (int i = 0; i < values.length; i++) {
                    row[i] = Integer.parseInt(values[i]);
                }
                reportList.add(row);
            }
            reader.close();
        } catch (IOException e) {
            System.err.println(e);
        }

        int[][] report = new int[reportList.size()][];
        for (int i = 0; i < reportList.size(); i++) {
            report[i] = reportList.get(i);
        }

        // Print the report
        for (int[] row : report) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println(part1(report));
    }
}
