package org.jingtao8a.code_random_notes;

import java.util.Stack;

public class test25 {
    public static String removeAdjacentDuplicatesInString(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); ++i) {
            if (!stack.empty() && str.charAt(i) == stack.peek()) {
                stack.pop();
            } else {
                stack.push(str.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            sb.append(stack.pop());
        }
        reverseStr(sb);
        return sb.toString();
    }

    public static void reverseStr(StringBuilder sb) {
        int left = 0, right = sb.length() - 1;
        while (left < right) {
            char ch = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, ch);
            left++;
            right--;
        }
    }


    public static void main(String[] args) {
        System.out.println(removeAdjacentDuplicatesInString("abbaca"));
    }
}
