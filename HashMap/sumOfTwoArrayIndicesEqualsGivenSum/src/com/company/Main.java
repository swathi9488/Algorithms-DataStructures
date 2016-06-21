package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;


public class Main {

    public static void main(String[] args) throws IOException {
        File inputFile = new File(args[0]);
        PrintWriter out = new PrintWriter(new FileWriter("output.txt"));

        BufferedReader br = new BufferedReader(new FileReader(inputFile));

        int totalTestCases = Integer.parseInt(br.readLine());
        for (int i = 1; i <= totalTestCases; i++) {
            int sum = Integer.parseInt(br.readLine());
            int arrSize = Integer.parseInt(br.readLine());
            int[] inputArr = new int[arrSize];
            String[] inputElements = (br.readLine()).split(" ");
            for (int j = 0; j < arrSize; j++) {
                inputArr[j] = Integer.parseInt(inputElements[j]);
            }
            buyStoreItems(inputArr, arrSize, sum, i, out);
        }

        br.close();
        out.close();

    }

    public static void buyStoreItems (int[] storeItemPrices, int itemCount,
                                      int totalCredit, int caseNumber, PrintWriter out) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        for (int i = 0; i < itemCount; i++) {
            Integer value = sumMap.get(totalCredit - storeItemPrices[i]);
            if (value != null) {
                out.println(String.format("Case #%d: %d %d", caseNumber, value+1, i+1));
                break;
            } else {
                sumMap.put(storeItemPrices[i], i);
            }
        }
    }
}
