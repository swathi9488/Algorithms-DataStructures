import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] set = {"a", "b", "c"};
        System.out.println(powerSet(set));
        powerSetPrintToConsole(set);
    }

    public static Set<Set<String>> powerSet(String[] set) {
        Set<Set<String>> result = new HashSet<>();
        int setSize = set.length;
        int powerSetSize = (int) Math.pow(2, setSize);
        for (int i = 0; i < powerSetSize; i++) {
            Set<String> tmpResult = new HashSet<>();
            for (int j = 0; j < setSize; j++) {
                if ((i & (1 << j)) != 0) {
                    tmpResult.add(set[j]);
                }
            }
            result.add(tmpResult);
        }
        return result;

    }

    public static void powerSetPrintToConsole(String[] set) {
        int setSize = set.length;
        int powerSetSize = (int) Math.pow(2, setSize);
        for (int i = 0; i < powerSetSize; i++) {
            System.out.print("{");
            for (int j = 0; j < setSize; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(set[j] + "\t");
                }
            }
            System.out.println("}");
        }
    }
}
