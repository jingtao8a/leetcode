package org.jingtao8a.code_random_notes;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class CustomHeap {
    private ArrayList<Integer> list = new ArrayList<>();
    public CustomHeap() {
        list.add(0);//index 0 no use
        PriorityQueue<Integer> heap = new PriorityQueue<>();
    }

    public void push(Integer num) {
        list.add(num);
        shiftUp(list.size() - 1);
    }

    public Integer pop() {
        if (list.size() == 1) {
            return null;
        }
        int res = list.get(1);
        int lastIndex = list.size() - 1;
        list.set(1, list.get(lastIndex));
        list.remove(lastIndex);
        shiftDown(1);
        return res;
    }
    private void shiftUp(int index) {
        while (true) {
            int parent = index / 2;
            if (parent <= 0) {
                return;
            }
            if (list.get(parent) > list.get(index)) {
                swap(parent, index);
                index = index / 2;
            } else {
                return;
            }
        }
    }

    private void shiftDown(int index) {
        while (true) {
            int minSonIndex = index * 2;
            if (minSonIndex > list.size() - 1) {
                return;
            }
            if (minSonIndex + 1 <= list.size() - 1) {
                minSonIndex = list.get(minSonIndex) < list.get(minSonIndex + 1) ? minSonIndex : minSonIndex + 1;
            }
            if (list.get(index) > list.get(minSonIndex)) {
                swap(index, minSonIndex);
                index = minSonIndex;
            } else {
                return;
            }
        }
    }
    private void swap(int i, int j) {
        int tmp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, tmp);
    }

    public static void main(String[] args) {
        CustomHeap heap = new CustomHeap();
        int[] num = new int[]{23, 432, 24, 89, 239, 98};
        for (int i : num) {
            heap.push(i);
        }
        while (true) {
            Integer i = heap.pop();
            if (i == null) {
                break;
            }
            System.out.print(i + " ");
        }
    }
}
