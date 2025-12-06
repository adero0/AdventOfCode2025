import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Day6 {
    public static void main(String[] args) {
        String[][] table = null;
        int lines = 0;
        try (BufferedReader r = new BufferedReader(new FileReader("input6.txt"))) {
            while (r.readLine() != null) lines++;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedReader reader = new BufferedReader(new FileReader("input6.txt"))) {
            String line = reader.readLine();
            table = new String[lines][];
            int counter = 0;
            String[] lineSplit;
            do {
                lineSplit = line.trim().replaceAll("\\s+", " ").split(" ");
                table[counter++] = lineSplit;
//                System.out.println(Arrays.toString(lineSplit));
            } while ((line = reader.readLine()) != null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


        long sum = 0;
        long runningSum;
        String symbol;
        for (int col = 0; col < table[0].length; col++) {
            runningSum = Long.parseLong(table[0][col]);
            symbol = table[lines-1][col];
            for (int row = 1; row < lines-1; row++) {
                runningSum = mathMe(runningSum, symbol, table[row][col]);
            }
            sum += runningSum;
        }
        System.out.println(sum);
    }

    public static long mathMe(long runningSum, String symbol, String numberToMathOut) {
        long number = Long.parseLong(numberToMathOut);

        if (symbol.equals("*")) {
            return runningSum * number;
        }
        if (symbol.equals("+")) {
            return runningSum + number;
        }
        throw new UnsupportedOperationException("I don't know symbol: " + symbol);
    }
}

