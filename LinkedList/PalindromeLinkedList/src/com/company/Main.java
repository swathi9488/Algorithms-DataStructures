package com.company;

import java.util.LinkedList;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkNode n11 = new LinkNode(5);
        LinkNode n12 = new LinkNode(2);
        n11.next  = n12;
        LinkNode n13 = new LinkNode(5);
        n12.next = n13;
        LinkNode n14 = new LinkNode(6);
        n13.next = n14;

        System.out.print(isPalindromIterative(n11));

    }

    public static boolean isPalindromIterative(LinkNode n) {
        LinkNode slow = n;
        LinkNode fast = n;
        Stack<Integer> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow.value);
            slow = slow.next;
            fast = fast.next.next;
        }

        // odd length linked list (so dont compare with stack the middle value)
        if (fast != null) {
            slow = slow.next;
        }

        while (slow != null) {
            int stackVal = stack.pop();
            if (slow.value != stackVal) {
                return false;
            }
            slow = slow.next;
        }

        return true;
    }

    public static boolean isPalindrome(LinkNode n) {
        int length = n.getLength();
        return isPalindromeRecurse(n, length).isPalindrome;
    }

    public static Result isPalindromeRecurse(LinkNode n, int length) {
        if (n == null || length == 0) {
            return new Result(null, true);
        } else if (length == 1) {
            return new Result(n.next, true);

        } else if (length == 2) {
            // no null check required fro n.next coz length == 2 means there exist a next
            return new Result (n.next.next, n.next.value == n.value);

        }

        Result result = isPalindromeRecurse(n.next, length - 2);

        // the null check may not be required
        if (!result.isPalindrome || result.node == null) {
            return result;
        }

        boolean isPalindrome = (result.node.value == n.value);
        return new Result(result.node.next, isPalindrome);

    }

    public static class Result {
        LinkNode node;
        boolean isPalindrome;

        public Result (LinkNode n, boolean isPalin) {
            this.node = n;
            isPalindrome = isPalin;
        }
     }
}
