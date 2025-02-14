package org.jingtao8a.streamapi;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.stream.Collectors;
import java.util.concurrent.*;
import java.util.*;
import java.util.function.Function;
import java.util.function.Consumer;
public class Study1 {
    @Test
    void test1() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);
        list = list.stream().filter((x)-> { return x % 2 == 0; }).collect(Collectors.toList());
        list.stream().forEach(s -> System.out.println(s));
    }

    @Test
    void test2() {
        List<String> list = Arrays.asList("a", "b", "c");
        list.stream().map((s)->{return s.toUpperCase();}).forEach(System.out::println);
    }
}
