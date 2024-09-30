package org.jingtao8a.api;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class ArraysKind {
    @Test
    public void test1() {
        Map<String, String> map = new HashMap<>();
        map.put("a","A");
        map.put("b","B");
        String v = map.computeIfAbsent("b",k->"v");  // 输出 B
        System.out.println(v);
        String v1 = map.computeIfAbsent("c",k->"v"); // 输出 v
        System.out.println(v1);
    }
}
