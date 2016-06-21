package com.company;

/**
 * Created by swathi on 5/22/16.
 */
public class HashTable {
    HashEntry[] table;
    static int TABLE_SIZE = 5;

    public HashTable() {
        table = new HashEntry[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = null;
        }
    }

    public boolean put(int key, int value) {
        int hash = key%TABLE_SIZE;
        int loopCount = 0;

        // go around once and if you still dont find a free space come out of the loop
        while (loopCount != TABLE_SIZE && table[hash] != null) {
            hash = (hash+1)%TABLE_SIZE;
            loopCount++;
        }

        if (table[hash] == null) {
            table[hash] = new HashEntry(key, value);
            return true;
        }

        return false;

    }

    public Integer get(int key) {
        int hash = getKeyIndex(key);
        if (hash != -1) {
            return table[hash].getValue();
        }

        return null;
    }

    public boolean remove(int key) {
        int hash = getKeyIndex(key);
        if (hash != -1) {
            table[hash] = null;
            return true;
        }

        // indicates that the element was not present in the table
        return false;
    }

    private int getKeyIndex(int key) {
        int hash = key%TABLE_SIZE;
        int loopCount = 0;

        // go around once and if you still dont find a free space come out of the loop
        // table[hash] == null check is for when something gets removed in the interim
        // loopCount != TABLE_SIZE this has to be first and the other condition in () to avoid infinite loop
        while (loopCount != TABLE_SIZE && (table[hash] == null  || table[hash].getKey() != key)) {
            hash = (hash+1)%TABLE_SIZE;
            loopCount++;
        }

        if (table[hash] != null && table[hash].getKey() == key) {
            return hash;
        }

        return -1;
    }

}
