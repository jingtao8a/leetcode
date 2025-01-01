package org.jingtao8a.code_random_notes;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;


public class Dijkstra {
        int N, M;
        int[][] matrix;
        boolean[] flags;
        int[] minDist;

        void init() {
            try {
                System.setIn(new FileInputStream("D:/leetcode/input3.txt"));
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
            Scanner in = new Scanner(System.in);
            N = in.nextInt();
            M = in.nextInt();
            matrix = new int[N + 1][N + 1];
            for (int i = 0; i <= N; ++i) {
                for (int j = 0; j <= N; ++j) {
                    matrix[i][j] = Integer.MAX_VALUE;
                }
            }
            for (int i = 1; i <= N; ++i) {
                matrix[i][i] = 0;
            }
            for (int i = 0; i < M; ++i) {
                int s = in.nextInt();
                int e = in.nextInt();
                int v = in.nextInt();
                matrix[s][e] = v;
                matrix[e][s] = v;
            }
            flags = new boolean[N + 1];
            minDist = new int[N + 1];
            for (int j = 1; j <= N; ++j) {
                minDist[j] = matrix[1][j];
            }
        }

        private static class Edge implements Comparable<Edge> {
            int p;
            int val;
            Edge(int p, int val) { this.p = p; this.val = val; }
            Edge() {}

            @Override
            public int compareTo(Edge o) {
                return this.val - o.val;
            }
        }

        private void printMinDist() {
            System.out.println("-------------");
            for (int i = 1; i <= N; ++i) {
                System.out.println(minDist[i]);
            }
            System.out.println("-------------");
            System.out.println();
        }

        PriorityQueue<Edge> heap;
        void solve() {
            heap = new PriorityQueue<>();
            for (int i = 1; i <= N; ++i) {
                heap.offer(new Edge(i, minDist[i]));
            }
            while (!heap.isEmpty()) {
                printMinDist();
//                assert(heap.size() > 0);
                Edge e = heap.poll();
//                assert(flags[e.p] == false);
                if (flags[e.p] == true) {
                    continue;
                }
                flags[e.p] = true;
//                System.out.println(e.p);
                for (int i = 1; i <= N; ++i) {
                    if ( flags[i] == false && matrix[e.p][i] != Integer.MAX_VALUE
                            && e.val + matrix[e.p][i] < minDist[i]) {
                        minDist[i] = e.val + matrix[e.p][i];
                        heap.offer(new Edge(i, minDist[i]));
                    }
                }
            }
            System.out.println(minDist[N]);
        }

        public void solve1() {
            for (int i = 1; i <= N; ++i) {
                int p = -1;
                int minD = Integer.MAX_VALUE;
                for (int j = 1; j <= N; ++j) {
                    if (flags[j] == false && minDist[j] < minD) {
                        p = j;
                        minD = minDist[j];
                    }
                }
                assert(minD != Integer.MAX_VALUE);
                flags[p] = true;
                for (int j = 1; j <= N; ++j) {
                    if (flags[j] == false && matrix[p][j] != Integer.MAX_VALUE
                    && minD + matrix[p][j] < minDist[j]) {
                        minDist[j] = minD + matrix[p][j];
                    }
                }
            }
            System.out.println(minDist[N]);
        }

        public static void main(String[] args) {
            Dijkstra m = new Dijkstra();
            m.init();
            m.solve1();
        }
}
