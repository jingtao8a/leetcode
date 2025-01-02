package org.jingtao8a.study;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.*;

public class study4 {
    private int N, M;
    private int[][] matrix;
    private int[] inDegrees;
    private boolean[] visited;
    private enum Status {
        NO_VISITED,
        VISITING,
        VISITED,
        ;
    }
    private Status[] statusArray;
    public void init() throws FileNotFoundException {
        System.setIn(new FileInputStream("D:/leetcode/input4.txt"));
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        matrix = new int[N + 1][N + 1];
        inDegrees = new int[N + 1];
        visited = new boolean[N + 1];
        statusArray = new Status[N + 1];
        Arrays.fill(statusArray, Status.NO_VISITED);
        for (int i = 1; i <= N; ++i) {
            matrix[i][i] = 1;
        }
        for (int i = 0; i < M; ++i) {
            int u = in.nextInt();
            int v = in.nextInt();
            matrix[u][v] = 1;
            inDegrees[v]++;
        }
    }

    boolean valid = false;
    private void dfs(int u, List<Integer> res) {
        for (int j = 0; j <= N; ++j) {
            if (j == u) {
                continue;
            }
            if (matrix[u][j] == 1 && statusArray[j] == Status.NO_VISITED) {
                statusArray[j] = Status.VISITING;
                dfs(j, res);
            } else if (matrix[u][j] == 1 && statusArray[j] == Status.VISITING) {
                valid = true;
            }
            if (valid) {
                return;
            }
        }
        statusArray[u] = Status.VISITED;
        res.add(u);
    }

    public void solve2() {
        matrix[0][0] = 1;
        for (int i = 1; i <= N; ++i) {
            if (inDegrees[i] == 0) {
                ++inDegrees[i];
                matrix[0][i] = 1;
            }
        }
        List<Integer> res = new ArrayList<>();
        statusArray[0] = Status.VISITING;
        dfs(0, res);
        if (valid) {
            System.out.println("cycle");
        } else {
            Collections.reverse(res);
            for (int i : res) {
                System.out.print(i +" ");
            }
            System.out.println();
        }
    }

    public void solve1() {
        List<Integer> res = new ArrayList<>(N);
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= N; ++i) {
            if (inDegrees[i] == 0) {
                visited[i] = true;
                queue.offer(i);
            }
        }
        while (!queue.isEmpty()) {
            int p = queue.poll();
            res.add(p);
            for (int j = 1; j <= N; ++j) {
                if (visited[j] == false && matrix[p][j] == 1) {
                    inDegrees[j]--;
                    if (inDegrees[j] == 0) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }
        }
        for (int i : res) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public static void main(String[] args) throws FileNotFoundException {
        study4 sol = new study4();
        sol.init();
//        sol.solve1();
        sol.solve2();
    }
}
