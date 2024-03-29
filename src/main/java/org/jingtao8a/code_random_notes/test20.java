package org.jingtao8a.code_random_notes;

public class test20 {
    public static void main(String[] args) {
        String s = "a1b3c32";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); ++i) {
            if (Character.isDigit(s.charAt(i))) {
                sb.append("number");
            } else {
                sb.append(s.charAt(i));
            }
        }
        String res = sb.toString();
        System.out.println(res);
    }
}
