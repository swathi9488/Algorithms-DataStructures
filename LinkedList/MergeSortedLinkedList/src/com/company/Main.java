package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        LinkNode head1 = new LinkNode(1);
        LinkNode two1 = new LinkNode(3);
        LinkNode three1 = new LinkNode(5);
        head1.next = two1;
        two1.next = three1;

        LinkNode head2 = new LinkNode(2);
        LinkNode two2 = new LinkNode(4);
        head2.next = two2;

        //LinkNode result = mergeList(head1, head2);
        //System.out.print(true);

        LinkNode resultRev = mergeListReverse(head1, head2);
        System.out.print(true);

        //LinkNode resultIterative = mergeListIterative(head1, head2);
        //System.out.print(true);

    }

    static LinkNode mergeList (LinkNode head1, LinkNode head2) {
        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        if (head1.val <= head2.val) {
            head1.next = mergeList(head1.next, head2);
            return head1;
        } else {
            head2.next = mergeList(head1, head2.next);
            return head2;
        }
    }

    static LinkNode mergeListReverse (LinkNode head1, LinkNode head2) {
        LinkNode prev = null;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                LinkNode temp = head1.next;
                head1.next = prev;
                prev = head1;
                head1 = temp;
            } else {
                LinkNode temp = head2.next;
                head2.next = prev;
                prev = head2;
                head2 = temp;
            }
        }

        while (head1 != null) {
            LinkNode temp = head1.next;
            head1.next = prev;
            prev = head1;
            head1 = temp;
        }

        while (head2 != null) {
            LinkNode temp = head2.next;
            head2.next = prev;
            prev = head2;
            head2 = temp;
        }

        return prev;
    }

    static LinkNode mergeListIterative(LinkNode head1, LinkNode head2) {
        LinkNode prev = null;
        LinkNode resHead = null;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                if (prev != null) {
                    prev.next = head1;
                } else {
                   resHead = head1;
                }
                prev = head1;
                head1 = head1.next;
            } else {
                if (prev != null) {
                    prev.next = head2;
                } else {
                    resHead = head2;
                }
                prev = head2;
                head2 = head2.next;
            }
        }

        while (head1 != null) {
            prev.next = head1;
            prev = head1;
            head1 = head1.next;
        }

        while (head2 != null) {
            prev.next = head2;
            prev = head2;
            head2 = head2.next;
        }

        return resHead;
    }
}
