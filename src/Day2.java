import java.util.ArrayList;
import java.util.List;

public class Day2 {
    public static boolean isminus(char character) {
        return character == '-';
    }

    public static boolean iscomma(char character) {
        return character == ',';
    }

    public static boolean isSussyString(String potentialSus) {
        return potentialSus.substring(0,potentialSus.length()/2).equals(potentialSus.substring(potentialSus.length()/2));
    }

    public static void main(String[] args) {
        String input = """
                288352-412983,743179-799185,7298346751-7298403555,3269-7729,3939364590-3939433455,867092-900135,25259-67386,95107011-95138585,655569300-655755402,9372727140-9372846709,986003-1032361,69689-125217,417160-479391,642-1335,521359-592037,7456656494-7456690478,38956690-39035309,1-18,799312-861633,674384-733730,1684-2834,605744-666915,6534997-6766843,4659420-4693423,6161502941-6161738969,932668-985784,901838-922814,137371-216743,47446188-47487754,117-403,32-77,35299661-35411975,7778-14058,83706740-83939522""";
        List<Long> begins = new ArrayList<>();
        List<Long> ends = new ArrayList<>();
        int pointer = 0;
        long susSum = 0;

        String[] ranges = input.split(",");
        for (String r : ranges) {
            String[] parts = r.split("-");
            begins.add(Long.parseLong(parts[0]));
            ends.add(Long.parseLong(parts[1]));
        }

        int nbOfRanges = begins.size();

        for (int whichRange = 0; whichRange < nbOfRanges; whichRange++) {
            for (long currentNumber = begins.get(whichRange); currentNumber <= ends.get(whichRange); currentNumber++) {
                if (Long.toString(currentNumber).length() % 2 != 0) continue;
                if (isSussyString(Long.toString(currentNumber))) {
//                    System.out.println(currentNumber);
                    susSum += currentNumber;
                }
            }
        }
        System.out.println(susSum);
    }
}
//40055209613