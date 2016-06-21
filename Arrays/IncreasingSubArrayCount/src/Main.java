public class Main {

    // a sorted sunarray of length ‘len’ adds len*(len-1)/2 to result.
    // For example, {10, 20, 30, 40} adds 6 to the result.
    public static void main(String[] args) {
        int[] input = {1, 2, 3, 2, 4, 7, 8, 9, 8, 9, 10};

        int length = 1;
        int result = 0;
        for (int i = 0; i < input.length-1; i++) {
            // keep adding up the lenght of increasing sub array until the next lower number is hit
            if (input[i+1] > input[i]) {
                length++;
            } else {
                // add up the prev subarrays count to the result and reset the length
                result += (length-1)*(length)/2;
                length = 1;
            }
        }

        if (length > 1) {
            result += (length-1)*(length)/2;
        }

        System.out.println("Count of sub arrays:" + result);
    }
}
