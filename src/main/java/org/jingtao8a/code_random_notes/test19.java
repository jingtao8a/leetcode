package org.jingtao8a.code_random_notes;

public class test19 {
    public static void reverseStr(char[] charArray) {
        int left = 0, right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
    }
    //反转字符串
    public static void main(String[] args) {
        char[] charArray = new char[] {'h', 'e', 'l', 'l', 'o'};
        reverseStr(charArray);
        for (char ch : charArray) {
            System.out.print(ch + " ");
        }
    }
}
