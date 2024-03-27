package org.jingtao8a.code_random_notes;

public class test5 {
    public static void printSpiralMatrix(int n) {
        int left = 0, right = n - 1, up = 0, down = n - 1;
        int[][] matrix = new int[n][n];
        int index = 1;
        while (left <= right || up <= down) {
            for (int j = left; j <= right; ++j) {
                matrix[up][j] = index++;
            }
            up++;
            for (int i = up; i <= down; ++i) {
                matrix[i][right] = index++;
            }
            right--;
            for (int j = right; j >= left; --j) {
                matrix[down][j] = index++;
            }
            down--;
            for (int i = down; i >= up; --i) {
                matrix[i][left] = index++;
            }
            left++;
        }
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n; ++j) {
                System.out.print(matrix[i][j] + "   ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        printSpiralMatrix(5);
    }
}
