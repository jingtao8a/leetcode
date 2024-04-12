package org.jingtao8a.code_random_notes;

import com.sun.xml.internal.ws.api.ha.StickyFeature;

import java.util.ArrayList;

public class test47 {

    private static char[][] matrix = new char[][] {
            {},//0
            {},//1
            {'a', 'b', 'c'},//2
            {'d', 'e', 'f'},//3
            {'g', 'h', 'i'},//4
            {'j', 'k', 'l'},//5
            {'m', 'n', 'o'},//6
            {'p', 'q', 'r', 's'},//7
            {'t', 'u', 'v'},//8
            {'w', 'x', 'y', 'z'},//9
    };
    private static ArrayList<ArrayList<Character> > res = new ArrayList<>();
    private static ArrayList<Character> list = new ArrayList<>();
    public static void dfs(String str, int index) {
        int i = str.charAt(index) - '0';
        for (char ch : matrix[i]) {
            list.add(ch);
            if (index + 1 < str.length()) {
                dfs(str, index + 1);
            } else {
                res.add((ArrayList<Character>)list.clone());
            }
            list.remove(list.size() - 1);
        }
    }
    // 电话号码的字母组合
    public static void main(String[] args) {
        String str = "23";
        dfs(str, 0);
        for (ArrayList<Character> characters : res) {
            for (Character ch : characters) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }
}
