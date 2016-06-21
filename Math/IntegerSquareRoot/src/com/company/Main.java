package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println(isSquareRootInteger(4));
    }

    private static boolean isSquareRootInteger(int n) {
        if (n < 0) {
            return false;
        }

        if (n <= 1) {
            return true;
        }

        double sqrt = Math.sqrt(n);
        if (sqrt*sqrt == n) {
            return true;
        }

        return false;

    }
}
