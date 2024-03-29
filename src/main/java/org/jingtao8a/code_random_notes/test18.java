package org.jingtao8a.code_random_notes;

import java.util.ArrayList;
import java.util.Arrays;

public class test18 {
    public static ArrayList<ArrayList<Integer> > sumOfFourNum(int[] num) {
        Arrays.sort(num);
        ArrayList<ArrayList<Integer> > list = new ArrayList<>();
        if (num.length < 4) {
            return list;
        }
        for (int i = 0; i < num.length - 3; ++i) {
            if (i > 0 && num[i] == num[i - 1]) { //去重
                continue;
            }
            for (int j = i + 1; j < num.length - 2; ++j) {
                if (num[j] == num[j - 1]) { //去重
                    continue;
                }
                int left = j + 1, right = num.length - 1;
                while (left < right) {
                    int sum = num[i] + num[j] + num[left] + num[right];
                    if (sum == 0) {
                       ArrayList<Integer> item = new ArrayList<>();
                       item.add(num[i]);
                       item.add(num[j]);
                       item.add(num[left]);
                       item.add(num[right]);
                       list.add(item);
                       while (left < right && num[right] == num[right - 1]) { //去重
                           right--;
                       }
                       while (left < right && num[left] == num[left + 1]) { //去重
                           left++;
                       }
                       right--;
                       left++;
                    } else if (sum < 0) {
                        left++;
                    } else if (sum > 0) {
                        right--;
                    }
                }
            }
        }
        return list;
    }
    // 四数之和
    public static void main(String[] args) {
         int[] num = new int[] {1, 0, -1, 0, -2, 2};
         ArrayList<ArrayList<Integer> > list = sumOfFourNum(num);
         for (ArrayList<Integer> item : list) {
             for (Integer i : item) {
                 System.out.print(i + " ");
             }
             System.out.println();
         }
    }
}
