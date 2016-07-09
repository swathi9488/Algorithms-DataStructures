package com.company;

import java.util.*;

/**
 * Created by swathi on 6/28/16.
 */
public class Solution {
    public Set<Integer> getIntersection(List<Integer> list1, List<Integer> list2) {
        int i = 0; int j = 0;
        Set<Integer> result = new HashSet<>();
        while (i != list1.size() && j != list2.size())  {
            Integer curr1 = list1.get(i);
            Integer curr2 = list2.get(j);
            if (curr1 == curr2) {
                result.add(curr1);
                i++; j++;
            } else if (curr1 < curr2) {
                i++;
            } else {
                j++;
            }
        }

        return result;
    }

    public Set<Integer> getUnion(List<Integer> list1, List<Integer> list2) {
        int i = 0; int j = 0;
        Set<Integer> result = new HashSet<>();
        while (i != list1.size() && j != list2.size()) {
            Integer curr1 = list1.get(i);
            Integer curr2 = list2.get(j);
            if (curr1 == curr2) {
                result.add(curr1);
                i++;
                j++;
            } else if (curr1 < curr2) {
                result.add(curr1);
                i++;
            } else {
                result.add(curr2);
                j++;
            }
        }

        if (list1 == null) {
            for (int k = j; k < list2.size(); k++) {
                result.add(list2.get(k));
            }
        }

        if (list2 == null) {
            for (int k = j; k < list1.size(); k++) {
                result.add(list1.get(k));
            }
        }

        return result;
    }
}
