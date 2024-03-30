package org.jingtao8a.code_random_notes;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class test27 {
    public static ArrayList<Integer> maximumValueOfSlidingWindow(int[] nums, int k) {
        assert(nums.length >= k);
        MonotonicQueue monotonicQueue = new MonotonicQueue();//递减单调队列
        ArrayList<Integer> resList = new ArrayList<>();
        int front = 0, end = front + k;
        for (int i = front; i < end; ++i) {
            monotonicQueue.push(nums[i]);
        }
        resList.add(monotonicQueue.peek());
        ++front;
        ++end;
        while (end <= nums.length) {
            if (monotonicQueue.peek() == nums[front - 1]) {
                monotonicQueue.pop();
            }
            monotonicQueue.push(nums[end - 1]);
            resList.add(monotonicQueue.peek());

            ++front;
            ++end;
        }
        return resList;
    }
    public static void main(String[] args) {
        int[] nums = new int[] {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        ArrayList<Integer> arrayList = maximumValueOfSlidingWindow(nums, k);
        for (Integer i : arrayList) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
