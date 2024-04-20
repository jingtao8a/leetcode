package org.jingtao8a.code_random_notes;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class test51 {
    //复原IP地址
    private static List<List<String> > list = new ArrayList<>();
    private static Deque<String> deque = new LinkedList<>();

    private static List<List<String> > partition(String str) {
        list.clear();
        deque.clear();
        dfs(str, 0);
        return list;
    }

    private static void dfs(String str, int startIndex) {
        if (deque.size() < 4 && startIndex >= str.length()) {
            return;
        }
        if (deque.size() == 4) {
            if (startIndex >= str.length()) {
                list.add(new ArrayList<>(deque));
            }
            return;
        }

        if (str.charAt(startIndex) == '0') { //前导0
            deque.offerLast(str.substring(startIndex, startIndex + 1));
            dfs(str, startIndex + 1);
            deque.pollLast();
            return;
        }
        for (int i = startIndex; i < str.length(); ++i) {
            if (isValidField(str, startIndex, i)) {
                String subStr = str.substring(startIndex, i + 1);
                deque.offerLast(subStr);
            } else {
                continue;
            }
            dfs(str, i + 1);
            deque.pollLast();
        }
    }

    private static boolean isValidField(String str, int start, int end) {
        int sum = 0;
        for (int i = start; i <= end; ++i) {
            sum = sum * 10 + str.charAt(i) - '0';
        }
        return sum <= 255;
    }
    public static void printRes(List<List<String> > res) {
        for (List<String> list : res) {
            System.out.print("[ ");
            for (String str : list) {
                System.out.print(str + " ");
            }
            System.out.println(" ]");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        String s = "101023";
        List<List<String> > res = partition(s);
        printRes(res);

        s = "0000";
        res = partition(s);
        printRes(res);

        s = "25525511135";
        res = partition(s);
        printRes(res);

        s = "1111";
        res = partition(s);
        printRes(res);

        s = "010010";
        res = partition(s);
        printRes(res);
    }
}
