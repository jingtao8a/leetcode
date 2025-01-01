package org.jingtao8a.code_random_notes;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    boolean[][] columns;
    boolean[][] rows;
    boolean[][] grids;
    Deque<Integer> solution;
    int n;
    Boolean flag;
    public void solveSudoku(char[][] board) {
        flag = false;
        columns = new boolean[9][9];
        rows = new boolean[9][9];
        grids = new boolean[9][9];
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                grids[i][j] = false;
                columns[i][j] = false;
                rows[i][j] = false;
            }
        }
        int count = 0;
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    setFlag(i, j, num, true);
                    count++;
                }
            }
        }
        n = 9 * 9 - count;
        solution = new ArrayDeque();
        backTracking(board, 0, 0);
        for (int i = 0; i < 9; ++i) {
            for (int j = 0; j < 9; ++j) {
                if (board[i][j] == '.') {
                    board[i][j] = (char)((int)solution.pollFirst() + '0');
                }
            }
        }
    }

    private void setFlag(int i, int j, int num, boolean flag) {
        grids[(i / 3) * 3 + j / 3][num - 1] = flag;
        columns[j][num - 1] = flag;
        rows[i][num - 1] = flag;
    }

    private boolean isValid(int i, int j, int num) {
        return !grids[(i / 3) * 3 + j / 3][num - 1] && !columns[j][num - 1] && !rows[i][num - 1];
    }

    private void backTracking(char[][] board, int iStart, int jStart) {
        if (solution.size() == n) {
            flag = true;
            return;
        }
        int i = iStart;
        int j = jStart;
        while (i < 9) {
            if (board[i][j] == '.') {
                break;
            }
            j++;
            if (j >= 9) {
                ++i;
                j = 0;
            }
        }
        for (int num = 1; num <= 9; ++num) {
            if (isValid(i, j, num)) {
                setFlag(i, j, num, true);
                solution.offerLast(num);
                if (j + 1 < 9) {
                    backTracking(board, i, j + 1);
                } else {
                    backTracking(board, i + 1, 0);
                }
                if (flag) {
                    return;
                }
                setFlag(i, j, num, false);
                solution.pollLast();
            }
        }
    }
}
public class SoduKo {
    @Test
    public void test() {
        char[][] board = new char[9][9];
        initBoard(board);
//        printBoard(board);
        Solution solution = new Solution();
        solution.solveSudoku(board);
        printBoard(board);
    }
    private void initBoard(char[][] board) {
        String[][] preBoard = {
                {"5", "3", ".", ".", "7", ".", ".", ".", "."},
                {"6", ".", ".", "1", "9", "5", ".", ".", "."},
                {".", "9", "8", ".", ".", ".", ".", "6", "."},
                {"8", ".", ".", ".", "6", ".", ".", ".", "3"},
                {"4", ".", ".", "8", ".", "3", ".", ".", "1"},
                {"7", ".", ".", ".", "2", ".", ".", ".", "6"},
                {".", "6", ".", ".", ".", ".", "2", "8", "."},
                {".", ".", ".", "4", "1", "9", ".", ".", "5"},
                {".", ".", ".", ".", "8", ".", ".", "7", "9"}
        };
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                board[i][j] = preBoard[i][j].charAt(0);
            }
        }
    }
    private void printBoard(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
