package com.company;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkNode l1 = new LinkNode(1);
        LinkNode l2 = new LinkNode(2);
        LinkNode l3 = new LinkNode(3);
        LinkNode l4 = new LinkNode(4);
        LinkNode l5 = new LinkNode(5);
        LinkNode l6 = new LinkNode(6);
        LinkNode l7 = new LinkNode(7);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;
        l6.next = l7;
        l7.next = l6;
        detectCycleAndRemove(l1);

        LinkNode curr = l1;
        while (curr != null) {
            System.out.print(curr.val + "-->");
            curr = curr.next;
        }
    }

    public static void detectCycleAndRemove(LinkNode head) {
        LinkNode slow = head;
        // this has to be head.next (if not) it will falsely detect a cycle first time
        LinkNode fast = head.next;
        while (fast != null && fast.next != null) {
            if (slow == fast) {
                break;
            }

            slow = slow.next;
            fast = fast.next.next;
        }

        if (slow == fast) {
            slow = head;
            // check for fast.next as we started from fast.next initially
            while (slow != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
            System.out.println("Cycle Node was at node:" + slow.val);
            fast.next = null;
        }
    }
}
