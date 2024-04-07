package org.jingtao8a.java_guide.BigDecimal;

public class test1 {
    public static void main(String[] args) {
        float a = 2.0f - 1.9f;
        float b = 1.8f - 1.7f;
        System.out.println(a);
        System.out.println(b);
        System.out.println(a == b);// false 精度丢失
    }
}
