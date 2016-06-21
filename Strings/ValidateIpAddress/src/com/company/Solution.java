package com.company;

/**
 * Created by swathi on 5/15/16.
 */
public class Solution {
    public boolean isIPValid (String ipAddress) {
        String[] ipElements = ipAddress.split("\\.");
        if (ipElements.length != 4) {
            return false;
        }

        for (int i = 0; i < ipElements.length; i++) {
            if (getIntFromStr(ipElements[i]) == -1) {
                return false;
            }
        }

        return true;
    }

    private int getIntFromStr(String s) {
        char[] sArr = s.toCharArray();
        int result = 0;
        int prevResult = -1;
        for (int i = 0; i < sArr.length; i++) {
            if (sArr[i] >= 48 && sArr[i] <= 57) {
                int c = sArr[i] - 48;
                result = result*10 + c;
                // prevResult == 0 to avoid 000, 01, 02, 09
                if (prevResult == 0 || result > 255) {
                    return -1;
                }

                prevResult = result;
            } else {
                return -1;
            }
        }

        return result;
    }
}

