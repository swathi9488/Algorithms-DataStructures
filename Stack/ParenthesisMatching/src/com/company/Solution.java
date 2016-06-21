package com.company;

import java.util.Stack;

/**
 * Created by swathi on 5/20/16.
 */
public class Solution {

    public boolean isValidExpression(String expression) {
        Stack<Character> stack = new Stack<>();
        char[] exp = expression.toCharArray();
        for (int i = 0; i < exp.length; i++) {
            if (endingParanthesis(exp[i])) {
                if (stack.isEmpty() || !matching(stack.peek(), exp[i])) {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (startingParanthesis(exp[i])){
                stack.push(exp[i]);
            }
        }

        return stack.isEmpty();
    }


    private boolean endingParanthesis(char c) {
        return (c == ')' || c == '}' || c == ']');
    }

    private boolean startingParanthesis(char c) {
        return (c == '(' || c == '{' || c == '[');
    }

    private boolean matching(char start, char end) {
        List<String> dna = new ArrayList<>();
        Collec
        switch(start) {
            case '(':
                return (end == ')');
            case '{':
                return (end == '}');
            case '[':
                return (end == ']');
            default:
                return false;
        }
    }

}
