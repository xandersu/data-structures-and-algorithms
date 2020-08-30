package com.xandersu.class082_leetcode.chapter_6;

import java.util.*;

/**
 * @author suxun
 * @date 2020/8/30 15:25
 * @description 347. 前 K 个高频元素
 */
public class $4_347_top_k_frequent_elements {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        //最大堆
        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> o2.getValue() - o1.getValue());
        //最小堆(默认)
//        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(k, (o1, o2) -> o1.getValue() - o2.getValue());
        queue.addAll(map.entrySet());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = queue.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(ints, k)));
    }

}
