package org.jingtao8a.test;

import org.junit.jupiter.api.Test;

public class test6 {
    @Test
    public void T1() {
        Parent obj = new Son();
        obj.testMethod();
        Son.testMethod(null);
    }
}

interface Parent {
    default void testMethod() {
        System.out.println("Parent.testMethod");
    }
}

class Son implements Parent {
    @Override
    public void testMethod() {
        System.out.println("Son.testMethod");
    }

    public static void testMethod(Object obj) {
        System.out.println("obj Son.testMethod");
    }

    public static void testMethod(String str) {
        System.out.println("str Son.testMethod");
    }
}
