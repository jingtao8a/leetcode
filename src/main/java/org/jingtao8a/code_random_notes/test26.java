package org.jingtao8a.code_random_notes;

import java.util.Stack;

public class test26 {
    public static int computeReversePolishExpression(String[] strings) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        Integer num1, num2;
        for (int i = 0; i < strings.length; ++i) {
            String str = strings[i];
            if (str.equals("+")) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 + num2);
            } else if (str.equals("-")) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 - num2);
            } else if (str.equals("*")) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 * num2);
            } else if (str.equals("/")) {
                num2 = stack.pop();
                num1 = stack.pop();
                stack.push(num1 / num2);
            } else {
                stack.push(Integer.valueOf(str));
            }
        }
        return stack.pop();
    }
    public static void main(String[] args) {
        String[] strs = new String[] {"4", "13", "5", "/", "+"};
        System.out.println(computeReversePolishExpression(strs));
    }
}
