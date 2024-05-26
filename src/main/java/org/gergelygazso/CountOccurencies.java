package org.gergelygazso;

import java.util.HashMap;
import java.util.Map;

public class CountOccurencies {

    private static int countOccurencies(int[] arr, int num) {

        Map<Integer, Integer> map = new HashMap<>();
        for (int element : arr){
            map.put(element, map.getOrDefault(element, 0) +1);
        }
        return map.getOrDefault(num, 0);

    }

    public static void main(String[] args) {

        int[] arr = {2, 7, 11, 5,2,2,5,2};
        int num = 112;

        System.out.println(countOccurencies(arr, num));

    }
}
