import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
class Range {
    public long start;
    public long end;

    public Range(long start, long end) {
        this.start = start;
        this.end = end;
    }

    public Range(String start, String end) {
        this.start = Long.parseLong(start);
        this.end = Long.parseLong(end);
    }

    public boolean isBetween(long number) {
        return start <= number && number <= end;
    }
}

public class Day5 {
    public static void  main(String[] args) {
        List<Range> ranges = new ArrayList<>();
        int howManyFresh = 0;
        List<Long> idsToCheck = new ArrayList<>();

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
            while ((line = reader.readLine()) != null) {
                idsToCheck.add(Long.parseLong(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (var id : idsToCheck) {
            for (Range range : ranges) {
                if (range.isBetween(id)) {
                    howManyFresh++;
                    break;
                }
            }
        }

        System.out.println(howManyFresh);
    }
}
