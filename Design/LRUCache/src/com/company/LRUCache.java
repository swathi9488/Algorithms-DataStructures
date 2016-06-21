package com.company;

import javafx.util.Pair;

import java.security.Key;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by swathi on 4/24/16.
 */
public class LRUCache {

    Map<Integer, DoubleLinkNode> cacheMap = new HashMap<>();
    int remainingCapacity;
    DoubleLinkNode head;
    DoubleLinkNode tail;


    public LRUCache(int capacity) {
        this.remainingCapacity = capacity;
        head = new DoubleLinkNode();
        tail = new DoubleLinkNode();
        head.prev = null;
        tail.next = null;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key) {
        DoubleLinkNode nodeValue = cacheMap.get(key);
        if (nodeValue == null) {
            return -1;
        }
        moveToHead(head, nodeValue);
        return nodeValue.value;

    }

    public void set(int key, int value) {
        DoubleLinkNode nodeValue = cacheMap.get(key);
        if (nodeValue != null) {
            nodeValue.value = value;
            moveToHead(head, nodeValue);
        } else {
            if (remainingCapacity == 0) {
                removeLeastRecent();
            } else {
                remainingCapacity--;
            }

            DoubleLinkNode newNode = new DoubleLinkNode();
            newNode.key = key;
            newNode.value = value;
            addNode(head, newNode);
            cacheMap.put(key, newNode);
        }
    }

    private void removeLeastRecent() {
       DoubleLinkNode poppedValue = popTail(tail);
        cacheMap.remove(poppedValue.key);
    }

    public class DoubleLinkNode {
        int key;
        int value;
        DoubleLinkNode prev;
        DoubleLinkNode next;
    }

    // add a node right after head, head is a place holder
    public void addNode(DoubleLinkNode head,
                        DoubleLinkNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(DoubleLinkNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void moveToHead(DoubleLinkNode head,
                           DoubleLinkNode node) {
        removeNode(node);
        addNode(head, node);
    }

    // pop the element before the tail, the tail is a placeholder
    public  DoubleLinkNode popTail(DoubleLinkNode tail) {
        DoubleLinkNode nodeBeforeTail = tail.prev;
        removeNode(nodeBeforeTail);
        return nodeBeforeTail;
    }
}
