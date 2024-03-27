package org.jingtao8a.code_random_notes;
import java.util.*;
public class test3 {
    public static int[] squareOfSortedArray(int[] nums) {
        int[] newNums = nums.clone();
        for (int i = 0; i < nums.length; ++i) {
            if (newNums[i] < 0) {
                newNums[i] = -1 * newNums[i];
            } else {
                break;
            }
        }
        Arrays.sort(newNums);
        for (int i = 0; i < newNums.length; ++i) {
            newNums[i] = newNums[i] * newNums[i];
        }
        return newNums;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {-4,-1,0,3,10};
        int[] newNums = squareOfSortedArray(nums);
        for (int i = 0; i < newNums.length; ++i) {
            System.out.println(newNums[i]);
        }
    }
}
