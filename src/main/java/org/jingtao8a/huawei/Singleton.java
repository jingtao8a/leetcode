package org.jingtao8a.huawei;

public class Singleton {
    private static Singleton INSTANCEV1 = new Singleton();

    public static Singleton getInstanceV1() {
        return INSTANCEV1;
    }

    private static Singleton INSTANCEV2 = null;
    public static Singleton getInstanceV2() {
        if (INSTANCEV2 == null) {
            synchronized (Singleton.class) {
                if (INSTANCEV2 == null) {
                    INSTANCEV2 = new Singleton();
                }
            }
        }
        return INSTANCEV2;
    }
}
