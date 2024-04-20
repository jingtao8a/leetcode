package org.jingtao8a.code_random_notes;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test50 {
    //分割回文子串
    private static List<List<String> > lists = new ArrayList<>();
    private static Deque<String> deque = new LinkedList<>();
    public static List<List<String> > partition(String s) {
        dfs(s, 0);
        return lists;
    }
    public static void dfs(String s, int startIndex) {
        if (startIndex >= s.length()) {
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = startIndex; i < s.length(); ++i) {
            if (isPalindrome(s, startIndex, i)) {
                String str = s.substring(startIndex, i + 1);
                deque.offerLast(str);
            } else {
                continue;
            }
            dfs(s, i + 1);
            deque.pollLast();
        }
    }

    public static boolean isPalindrome(String s, int startIndex, int end) {
        for (int i = startIndex, j = end; i < j; ++i, --j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "aab";
        List<List<String> > res = partition(str);
        for (List<String> list : res) {
            System.out.print("[ ");
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println(" ]");
        }
    }
}
