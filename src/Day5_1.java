import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Day5_1 {
    public static long countUniqueNumbers(List<Range> ranges) {
        if (ranges.isEmpty()) return 0;

        // Sort ranges by start
        ranges.sort(Comparator.comparingLong(r -> r.start));

        long total = 0;
        long curStart = ranges.getFirst().start;
        long curEnd   = ranges.getFirst().end;

        for (int i = 1; i < ranges.size(); i++) {
            Range r = ranges.get(i);

            if (r.start > curEnd + 1) {
                // no overlap: close previous interval
                total += (curEnd - curStart + 1);

                // start new interval
                curStart = r.start;
                curEnd = r.end;
            } else {
                // overlap: extend the current interval
                curEnd = Math.max(curEnd, r.end);
            }
        }

        // close last interval
        total += (curEnd - curStart + 1);

        return total;
    }
    public static void  main(String[] args) throws ExecutionException, InterruptedException {
        Set<Long> allRange = new HashSet<>();
        List<Range> ranges = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            //fresh ids
            while ((line = reader.readLine()) != null) {
                if(line.isEmpty()){
                    break;
                }

                var startend = line.split("-");
                    ranges.add(new Range(startend[0], startend[1]));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(countUniqueNumbers(ranges));
    }
}
