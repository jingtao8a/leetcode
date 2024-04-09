package org.jingtao8a.java_guide.ArrayListCode;

import java.util.ArrayList;

public class test1 {
    // ArrayList和Vetor, 线程不安全和线程安全
    // ArrayList可以存储null值，但是不建议
    public static void main(String[] args) {
//        ArrayList<Integer> list = new ArrayList<>(5);
//        list.add(0);
//        list.add(1);
//        for (Integer i :list) {
//            System.out.println(i);
//        }
        // 以无参数构造方法创建ArrayList时，实际上初始化赋值的是一个空数组。当真正对数组进行添加元素操作时，才真正分配容量。即向数组中添加第一个元素时，数组容量扩为10.
        // 直到添加到第11个元素后，ArrayList每次扩容之后容量都会变为原来的1.5倍

        int[] a = new int[10];
        a[0] = 0;
        a[1] = 1;
        a[2] = 2;
        a[3] = 3;
        System.arraycopy(a, 2, a, 3, 3);
        for (int i : a) {
            System.out.println(i);
        }
    }
}
