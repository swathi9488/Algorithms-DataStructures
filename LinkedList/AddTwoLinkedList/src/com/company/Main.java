package com.company;

public class Main {

    public static void main(String[] args) {
        LinkNode n11 = new LinkNode(5);
        LinkNode n12 = new LinkNode(2);
        n11.next  = n12;
        LinkNode n13 = new LinkNode(9);
        n12.next = n13;
        LinkNode n14 = new LinkNode(9);
        n13.next = n14;

        LinkNode n21 = new LinkNode(7);
        LinkNode n22 = new LinkNode(8);
        n21.next  = n22;

        LinkNode result = getSum(null, n11, 0);
        System.out.println(result);


        LinkNode n110 = new LinkNode(9);
        LinkNode n120 = new LinkNode(9);
        n110.next  = n120;
        LinkNode n130 = new LinkNode(2);
        n120.next = n130;
        LinkNode n140 = new LinkNode(5);
        n130.next = n140;

        LinkNode n210 = new LinkNode(8);
        LinkNode n220 = new LinkNode(7);
        n210.next  = n220;

        LinkNode reverse = getSumInReverse(n110, n210);
        System.out.println(reverse);

    }

    public static LinkNode getSum(LinkNode n1, LinkNode n2, int carry) {
        if (n1 == null && n2 == null && carry == 0) {
            return null;
        }

        int sum = carry;
        if (n1 != null) {
            sum += n1.value;
            n1 = n1.next;
        }

        if (n2 != null) {
            sum += n2.value;
            n2 = n2.next;
        }

        if (sum < 10) {
            carry = 0;
        } else {
            sum = sum%10;
            carry = 1;
        }

        LinkNode result = new LinkNode(sum);
        result.next = getSum(n1, n2, carry);

        return result;
    }

    public static LinkNode getSumInReverse(LinkNode n1, LinkNode n2) {
        int n1Length = getLength(n1);
        int n2Length = getLength(n2);

        if (n1Length != n2Length) {
            if (n1Length > n2Length) {
                n2 = padZeros(n2, n1Length - n2Length);
            } else {
                n1 = padZeros(n1, n2Length - n1Length);
            }
        }

        return getSumReverse(n1, n2, 0);
    }

    private static LinkNode padZeros(LinkNode n1, int numZeros) {
        LinkNode head = null;
        LinkNode prev = null;
        while (numZeros != 0) {
            LinkNode zero = new LinkNode(0);
            if (prev != null) {
                prev.next = zero;
            } else {
                head = zero;
            }
            prev = zero;
            numZeros--;
        }

        prev.next = n1;
        return head;
    }

    public static int getLength(LinkNode n1) {
        int length = 0;
        while(n1 != null) {
            n1 = n1.next;
            length++;
        }
        return length;
    }

    public static LinkNode getSumReverse(LinkNode n1, LinkNode n2, int i) {
        if (n1 == null && n2 == null) {
            return null;
        }

        LinkNode prev = getSumReverse(n1.next, n2.next, i+1);

        int carry = 0;
        if (prev != null) {
            carry = prev.carry;
        }

        int sum = carry + n1.value + n2.value;

        if (sum < 10) {
            carry = 0;
        } else {
            carry = 1;
            sum = sum%10;
        }

        LinkNode result = new LinkNode(sum, carry);
        result.next = prev;

        // this says that its the final return of recurrsion and
        // check if there was a carry from the previous recurrsion
        if (i == 0 && result.carry == 1) {
            LinkNode finalCarry = new LinkNode(1, 0);
            finalCarry.next = result;
            return finalCarry;
        }

        return result;
    }
}
