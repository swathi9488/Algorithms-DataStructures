package com.company;

/**
 * Created by swathi on 5/22/16.
 */
public class HashEntry {
    int key;
    int value;

    public HashEntry(int key, int value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return this.key;
    }

    public int getValue() {
        return this.value;
    }
}
