import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Day7 {
    public static void main(String[] args) {
        Set<Integer> curr = new HashSet<>();
        curr.add(70);

        String line;
        int splits = 0;
        boolean isToSkip = false;

        try (BufferedReader r = new BufferedReader(new FileReader("input7.txt"))) {
            r.readLine();
            while ((line = r.readLine()) != null) {
                Set<Integer> next = new HashSet<>();

                //skip odd lines
                isToSkip = !isToSkip;
                if (isToSkip) {
                    continue;
                }

                System.out.println(line);
                System.out.println(curr);
                for (int currVal : curr) {
                    if (line.charAt(currVal) == '^') {
                        next.add(currVal + 1);
                        next.add(currVal - 1);
                        splits++;
                    } else {
                        next.add(currVal);
                    }
                }

                curr = next;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(splits);
    }
}
