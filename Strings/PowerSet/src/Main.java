public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        String[] set = {"a", "b", "c", "d", "e", "f"};
        int setSize = set.length;
        int powerSetSize = (int) Math.pow(2, setSize);
        for (int i = 0; i < powerSetSize; i++) {
            System.out.print("{");
            for (int j = 0; j < setSize; j++) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(set[j] + "\t");
                }
            }
            System.out.println("}");
        }

    }
}
