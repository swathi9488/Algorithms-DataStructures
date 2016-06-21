package com.company;

/**
 * Created by swathi on 4/24/16.
 */
public class DoubleLinkNode {
    int key;
    int value;
    DoubleLinkNode prev;
    DoubleLinkNode next;

    // add a node right after head, head is a place holder
    public static void addNode(DoubleLinkNode head,
                        DoubleLinkNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    public static void removeNode(DoubleLinkNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public static void moveToHead(DoubleLinkNode head,
                           DoubleLinkNode node) {
        removeNode(node);
        addNode(head, node);
    }

    // pop the element before the tail, the tail is a placeholder
    public static DoubleLinkNode popTail(DoubleLinkNode tail) {
        DoubleLinkNode nodeBeforeTail = tail.prev;
        removeNode(nodeBeforeTail);
        return nodeBeforeTail;
    }
}
