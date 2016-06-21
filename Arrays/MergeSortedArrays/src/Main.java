public class Main {

    public static void main(String[] args) {
        //int[] arr1 = {1, 5, 9, 10, 15, 17};
        //int[] arr2 = {2, 3, 8, 20};

        int[] arr1 = {1, 5, 7, 10};
        int[] arr2 = {2, 3, 8, 9,  15, 17};

        // edge case
        //int[] arr1 = {21, 25, 29, 30, 35, 47};
        //int[] arr2 = {2, 3, 8, 19};

        for (int i = arr2.length - 1; i >= 0; i--) {
            int p1 = arr1.length - 1;
            int element = arr2[i];
            // move the largest element to the end of second array
            if (arr1[p1] > element) {
                arr2[i] = arr1[p1];
                p1--;
                // if the largest element is in the first array then swap it and
                // use insertion sort logic to put the cuurent element in the first array
                while (p1 != -1 && arr1[p1] > element) {
                    arr1[p1+1] = arr1[p1];
                    p1--;
                }
                arr1[p1+1] = element;
            }
        }

        for(int i = 0; i < arr1.length; i++) {
            System.out.print(arr1[i]+ "\t");
        }

        System.out.println("\n-------");
        for(int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+ "\t");
        }
    }
}
