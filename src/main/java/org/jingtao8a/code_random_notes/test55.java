package org.jingtao8a.code_random_notes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class test55 {
        int N,M;
        int[][] matrix;
        Map<Integer, Integer> map = new HashMap<>();
        static final int[][] direcList = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public void init() throws FileNotFoundException {
            FileInputStream fileInputStream = new FileInputStream("D:/leetcode/input2.txt");
            System.setIn(fileInputStream);
            Scanner in = new Scanner(System.in);
            N = in.nextInt();
            M = in.nextInt();
            matrix = new int[N][M];
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    matrix[i][j] = in.nextInt();
                }
            }
        }

        public void solve() {
            int index = 2;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (matrix[i][j] == 1) {
                        bfs(i, j, index++);
                    }
                }
            }
            int res = 0;
            for (int i = 0; i < N; ++i) {
                for (int j = 0; j < M; ++j) {
                    if (matrix[i][j] == 0) {
                        int sum = 1;
                        Set<Integer> keys = new HashSet<>();
                        for (int[] direc : direcList) {
                            int x = i + direc[0];
                            int y = j + direc[1];
                            if (x >= 0 && x < N &&
                                    y >= 0 && y < M &&
                                    matrix[x][y] != 0) {
                                keys.add(matrix[x][y]);
                            }
                        }
                        for (int key : keys) {
                            sum += map.get(key);
                        }
                        res = Math.max(res, sum);
                    }
                }
            }
            if (res == 0) {
                for (int i : map.values()) {
                    res = Math.max(i, res);
                }
            }
            System.out.println(res);
        }

        private static class Point {
            int x, y;
            Point() {}
            Point(int x, int y) { this.x = x; this.y = y; }
        }

        private void bfs(int i, int j, int val) {
            int area = 0;
            Deque<Point> queue = new LinkedList<>();
            queue.offerLast(new Point(i, j));
            area++;
            matrix[i][j] = val;

            while (!queue.isEmpty()) {
                Point p = queue.pollFirst();
                int x = p.x;
                int y = p.y;
                for (int[] direc : direcList) {
                    int newX = x + direc[0];
                    int newY = y + direc[1];
                    if (newX >= 0 && newX < N &&
                            newY >= 0 && newY < M &&
                            matrix[newX][newY] == 1) {
                        queue.offerLast(new Point(newX, newY));
                        area++;
                        matrix[newX][newY] = val;
                    }
                }
            }
            map.put(val, area);
        }

        public static void main(String[] args) throws FileNotFoundException {
            test55 solver = new test55();
            solver.init();
            solver.solve();
        }
}
