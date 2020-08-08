package com.xandersu.class082_leetcode.chapter_4;


import java.util.HashMap;
import java.util.Map;

/**
 * @author suxun
 * @date 2020/8/8 15:28
 * @description
 */
public class $3_454_4sum_ii {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map1 = getSumCountMap(A, B);
        Map<Integer, Integer> map2 = getSumCountMap(C, D);

        int count = 0;
        for (Map.Entry<Integer, Integer> entry1 : map1.entrySet()) {
            Integer key1 = entry1.getKey();
            Integer value1 = entry1.getValue();
            if (map2.containsKey(-key1)) {
                count += (value1 * map2.get(-key1));
            }
        }
        return count;
    }

    public static Map<Integer, Integer> getSumCountMap(int[] A, int[] B) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : A) {
            for (int b : B) {
                int abSum = a + b;
                map.put(abSum, map.getOrDefault(abSum, 0) + 1);
            }
        }
        return map;
    }
}
