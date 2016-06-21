import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        // Takes care of duplicates
        int[] input = {30, 30, 30, 30, 30, 30};
        Hashtable<Integer, String> sumHash = new Hashtable<>();
        int i;
        for (i = 0; i < input.length; i++) {
            int j;
            // For duplicates, store the index of the array instead fo the value;
            for (j = i+1; j < input.length; j++) {
                int sum = input[i] + input[j];
                String currValue;
                if (i < j) {
                    currValue = i + "," + j;
                } else {
                    currValue = j + "," + i;
                }
                String mapValue = sumHash.get(sum);
                if (sumHash.get(sum) != null && !mapValue.equals(currValue)) {
                    String[] valueArr = mapValue.split(",");
                    int a = Integer.parseInt(valueArr[0]);
                    int b = Integer.parseInt(valueArr[1]);

                    // This check is required to make sure that there are four separate indices that form the pair
                    // For the case: {30, 30, 30, 7, 1, 9}: without this check the result will be 30+30=30+30 => incorrect
                    if (a != i && a != j && b != i && b != j) {
                        System.out.println(input[Integer.parseInt(valueArr[0])] + "+" + input[Integer.parseInt(valueArr[1])]
                                + " = " + input[i] + "+" + input[j]);
                        break;
                    }
                } else {
                    sumHash.put(sum, currValue);
                }
            }

            if (j != input.length) {
                break;
            }
        }

        if (i == input.length) {
            System.out.print("No Pairs found");
        }
    }
}
