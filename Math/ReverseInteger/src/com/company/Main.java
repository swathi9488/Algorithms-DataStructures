package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int rev = reverse(1534236469);

    }

    public static int reverse(int x) {
        boolean negative = false;
        if (x < 0) {
            x = -x;
            negative = true;
        }
        int reversed = 0;
        while(x != 0) {
            int prevReversed = reversed;
            reversed = x%10 + 10*reversed;

            if (prevReversed reversed) {
                return 0;
            }

            x = x/10;
        }

        if (negative) {
            return -reversed;
        }

        return reversed;
    }
}
