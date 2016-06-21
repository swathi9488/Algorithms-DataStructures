package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        HashTable hashTable = new HashTable();
        hashTable.put(0, 0);
        hashTable.put(1, 1);
        hashTable.put(2, 2);
        hashTable.put(3, 3);
        hashTable.put(4, 4);
        hashTable.put(5, 5);
        System.out.println(hashTable.get(5));
        hashTable.remove(3);
        hashTable.put(5, 5);
        hashTable.remove(0);
        hashTable.remove(2);
        System.out.println(hashTable.get(5));
        System.out.println(hashTable.get(0));
        System.out.println(hashTable.get(2));
        System.out.println(hashTable.get(1));
    }
}
