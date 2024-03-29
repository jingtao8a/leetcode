package org.jingtao8a.code_random_notes;

import java.util.Stack;

public class test24 {
    public static boolean validBrackets(String str) {
        Stack<Character> s = new Stack<>();
        for (int i = 0; i < str.length(); ++i) {
            char ch = str.charAt(i);
            switch (ch) {
                case ')':
                    if (s.empty() || s.peek() != '(') {
                        return false;
                    }
                    s.pop();
                    break;
                case ']':
                    if (s.empty() || s.peek() != '[') {
                        return false;
                    }
                    s.pop();
                    break;
                case '}':
                    if (s.empty() || s.peek() != '{') {
                        return false;
                    }
                    s.pop();
                    break;
                case '(':
                    s.push('(');
                    break;
                case '[':
                    s.push('[');
                    break;
                case '{':
                    s.push('{');
                    break;
            }
        }
        return s.empty();
    }

    public static void main(String[] args) {
        String str1 = "()";
        String str2 = "()[]{}";
        String str3 = "(]";
        String str4 = "([)]";
        System.out.println(validBrackets(str1));
        System.out.println(validBrackets(str2));
        System.out.println(validBrackets(str3));
        System.out.println(validBrackets(str4));
    }
}
