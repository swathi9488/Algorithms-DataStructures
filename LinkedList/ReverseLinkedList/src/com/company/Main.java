package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);

        head.next = two;
        two.next = three;
    }

    public ListNode reverseList(ListNode current) {
        if (current == null) {
            return null;
        }

        ListNode reversedListHead = reverseList(current.next);
        if (reversedListHead == null) {
            return current;
        }

        ListNode nextEle = current.next;
        nextEle.next = current;
        current.next = null;
        return reversedListHead;
    }
}
