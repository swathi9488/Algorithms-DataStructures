import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World!");
        Stack<Integer> stack = new Stack<>();
        String input = "))))))())";
        stack.push(-1);
        int size = input.length();
        int validSubLength = 0;

        for (int i = 0; i < size; i++) {
            char current = input.charAt(i);
            if (current == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (!stack.isEmpty()) {
                    validSubLength = Math.max(validSubLength, i - stack.peek());
                } else {
                    stack.push(i);
                }
            }
        }

        System.out.println(validSubLength);
    }
}
