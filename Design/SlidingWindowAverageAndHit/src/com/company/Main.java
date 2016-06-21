package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] input = {1,2,3,3,4,5,6,7};

        MovingAverage movingAverage = new MovingAverage(3);

        for (int i = 0; i < input.length; i++) {
            movingAverage.addNum(input[i]);
            System.out.println(movingAverage.getAverage());
            System.out.println(movingAverage.isPresent(3));
        }
    }
}
