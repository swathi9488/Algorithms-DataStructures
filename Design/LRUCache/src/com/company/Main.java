package com.company;

public class Main {

    public static void main(String[] args) {
	    // write your code here
        LRUCache myCache =  new LRUCache(5);
        myCache.set(5, 5);
        myCache.set(6, 6);
        myCache.set(4, 4);
        myCache.set(3, 3);
        myCache.set(2, 2);
        myCache.get(2);
        myCache.get(2);
        myCache.get(5);
        myCache.get(6);
        myCache.get(3);
        myCache.set(1,1);
        System.out.println(myCache.get(4));
        System.out.println(myCache.get(1));

    }
}
