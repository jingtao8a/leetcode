package org.jingtao8a.study;
import java.util.*;

class study6Helper {
    private Map<Integer, Integer> map;
    public int countBalls(int lowLimit, int highLimit) {
        initMap(lowLimit, highLimit);
        Integer[] array = map.values().toArray(new Integer[map.size()]);
         Arrays.sort(array, (Integer left, Integer right)->{
             return right - left;
         });
         for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
             System.out.println(entry.getKey() + " " + entry.getValue());
         }
        return array[0];
    }

    private void initMap(int lowLimit, int highLimit) {
        map = new HashMap<>();
        for (int x = lowLimit; x <= highLimit; ++x) {
            int sum = 0;
            int tmp = x;
            while (tmp != 0) {
                sum += (tmp % 10);
                tmp /= 10;
            }
            Integer count = map.get(sum);
            if (count == null) {
                map.put(sum, 1);
            } else {
                map.put(sum, count + 1);
            }
        }
    }
}

public class study6 {
    public static void main(String[] args) {
        study6Helper helper = new study6Helper();
        System.out.println(helper.countBalls(1, 10));
    }
}
