public class Main {

    public static void main(String[] args) {
        String input = "GEEKSFORGEEK";
        int rowNum = 4;
        String[] output = new String[rowNum];

        for (int i = 0; i < rowNum; i++) {
            output[i] = "";
        }

        int count = 0;
        boolean down = true;
        for (int i = 0; i < input.length(); i++) {
            output[count] += input.charAt(i);
            // Keep going down until you hit the last row, then keep going up until you hit 0
            // Keep toggling
            if (down) {
                if (count != rowNum - 1) {
                    count++;
                } else {
                    down = false;
                    count--;
                }
            } else {
                if (count != 0) {
                    count--;
                } else {
                    down = true;
                    count++;
                }
            }
        }
        String outputString = "";
        for (int i = 0; i < rowNum; i++) {
            outputString += output[i];
        }

        System.out.println(outputString);
    }
}
