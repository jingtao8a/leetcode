package org.jingtao8a.code_random_notes;

import java.util.*;

public class test28 {
    public static ArrayList<Integer> topKHighFrequencyElements(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; ++i) {
            hashMap.put(nums[i], hashMap.getOrDefault(nums[i], 0) + 1);
        }
        Comparator<int[]> comp = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        };

        PriorityQueue<int[]> priorityQueue  = new PriorityQueue<>(comp);
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            priorityQueue.offer(new int[]{entry.getKey(), entry.getValue()});
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 1; i <= k; ++i) {
            if (priorityQueue.isEmpty()) {
                break;
            }
            int[] tmp = priorityQueue.poll();
            arrayList.add(tmp[0]);
        }
        return arrayList;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {1,1,1,2,2,3};
        int k = 2;
        ArrayList<Integer> list = topKHighFrequencyElements(nums, k);
        for (Integer i : list) {
            System.out.println(i);
        }
    }
}
