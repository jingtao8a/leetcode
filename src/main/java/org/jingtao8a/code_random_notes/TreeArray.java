package org.jingtao8a.code_random_notes;

import org.junit.jupiter.api.Test;
import sun.reflect.generics.tree.Tree;

import java.util.Arrays;

public class TreeArray {
    private int[] array;// [1, n]
    public void initSize(int n) {
        array = new int[n + 1];
        Arrays.fill(array, 0);
    }

    private int lowerBit(int i) {
        return i & (-i);
    }

    public void update(int i, int delta) {
        while (i < array.length) {
            array[i] += delta;
            i += lowerBit(i);
        }
    }

    public int query(int i) {
        int sum = 0;
        while (i >= 1) {
            sum += array[i];
            i -= lowerBit(i);
        }
        return sum;
    }

    @Test
    public void testTreeArray() {
        TreeArray treeArray = new TreeArray();
        treeArray.initSize(4);
        for (int i = 1; i <= 4; ++i) {
            treeArray.update(i, i);
        }
//        for (int i = 0; i <= 4; ++i) {
//            System.out.println(treeArray.array[i]);
//        }
        System.out.println(treeArray.query(1));
    }
}
