package org.jingtao8a.shopee;


import org.junit.jupiter.api.Test;

import java.util.*;



class Solution {
    /**
     * Note: 类名、方法名、参数名已经指定，请勿修改
     *
     *
     *
     * @param generated_map int整型 二维数组
     * @return int整型
     */
    int n;
    public int apply(int[][] generated_map) {
        // write code here
        n = generated_map.length;
        bfs(generated_map);
        int count = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                if (generated_map[i][j] != 2) {
                    ++count;
                }
            }
        }
        return count;
    }

    class Pair {
        int x;
        int y;
        Pair() {}
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    static int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private void bfs(int[][] generated_map) {
        Deque<Pair> deque = new ArrayDeque<>();
        generated_map[0][0] = 2;
        deque.offer(new Pair(0, 0));
        while (!deque.isEmpty()) {
            Pair tmp = deque.poll();
            for (int[] direct : directions) {
                int new_x = tmp.x + direct[0];
                int new_y = tmp.y + direct[1];
                if (new_x >= 0 && new_x < n && new_y >= 0 && new_y < n) {
                    if (generated_map[new_x][new_y] == 0) {
                        generated_map[new_x][new_y] = 2;
                        deque.offer(new Pair(new_x, new_y));
                    }
                }
            }
        }
    }
}

public class Test2 {
    @Test
    public void test2() {
        int[][] generated_map = {{0,1,1,0},{1,0,0,0},{0,1,0,1},{0,1,1,0}};
        Solution solution = new Solution();
        int res = solution.apply(generated_map);
        System.out.println(res);
    }
}
