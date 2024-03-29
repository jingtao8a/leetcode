package org.jingtao8a.code_random_notes;

public class test21 {
    public static String reverseWords(String str) {
        StringBuilder sb = removeSpace(str);
        reverseStr(sb, 0, sb.length());
        reverseEachWord(sb);
        return sb.toString();
    }
    public static void reverseEachWord(StringBuilder sb) {
        int start = 0, end = 1;
        while (end < sb.length()) {
            if (sb.charAt(end) == ' ') {
                reverseStr(sb, start, end);
                start = end + 1;
                end = start + 1;
            } else {
                end++;
            }
        }
        reverseStr(sb, start, end);
    }
    //翻转sb的[start, end)的字符串
    public static void reverseStr(StringBuilder sb, int start, int end) {
        int left = start, right = end - 1;
        while (left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, temp);
            left++;
            right--;
        }
    }
    //去除首尾空格，并且保证每个单词之间的空格数为1
    public static StringBuilder removeSpace(String str) {
        StringBuilder sb = new StringBuilder();
        int start = 0, end = str.length() - 1;
        while (str.charAt(start) == ' ') {
            start++;
        }
        while (str.charAt(end) == ' ') {
            end--;
        }
        while (start <= end) {
            char ch = str.charAt(start);
            if (ch == ' ' && sb.charAt(sb.length() - 1) == ' ') {
                //skip
            } else {
                sb.append(ch);
            }
            start++;
        }
        return sb;
    }
    public static void main(String[] args) {
        String str = "   the   sky    is   blue   ";
        str = "  hello world!  ";
        System.out.println(reverseWords(str));
    }
}
