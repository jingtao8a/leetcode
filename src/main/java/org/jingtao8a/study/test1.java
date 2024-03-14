package org.jingtao8a.study;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static com.sun.org.apache.xml.internal.security.keys.keyresolver.KeyResolver.iterator;

public class test1 {
    public void testHashMap() {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(1, 4);
        hashMap.put(2, 5);
        hashMap.put(3, 6);
        Set<Map.Entry<Integer, Integer>> entrySet = hashMap.entrySet();
    }
    public static void main(String[] args) {

    }
}
