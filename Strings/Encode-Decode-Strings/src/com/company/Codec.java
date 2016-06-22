package com.company;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by swathi on 6/22/16.
 */
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        boolean firstTime = true;
        for (String str : strs) {
            if (firstTime) {
                encodedString.append(str.length()).append(",").append(str);
                firstTime = false;
            } else {
                encodedString.append(",").append(str.length()).append(",").append(str);
            }
        }
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        int length = s.length();
        int i = 0;
        List<String> result = new ArrayList<>();
        while (i < length) {
            int firstCommaIdx = s.indexOf(",", i);
            Integer elementLength = Integer.parseInt(s.substring(i, firstCommaIdx)); // i to the char before ","
            int startIdx = firstCommaIdx + 1;
            int endIdx = startIdx + elementLength;
            String curr = "";
            if (elementLength != 0) {
                curr = s.substring(startIdx, endIdx);
            }
            result.add(curr);
            i = endIdx + 1;
        }

        return result;
    }
}
