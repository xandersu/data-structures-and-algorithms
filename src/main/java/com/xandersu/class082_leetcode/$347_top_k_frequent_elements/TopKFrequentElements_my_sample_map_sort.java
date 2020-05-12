package com.xandersu.class082_leetcode.$347_top_k_frequent_elements;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author su
 * @date 2020/5/1222:25
 * @description 最简单的思路：扫描一遍统计频率的；排序找到前K个出现的频率最高的元素。O(nlogn)
 * 优先队列
 */
public class TopKFrequentElements_my_sample_map_sort {

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer count = map.getOrDefault(num, 0);
            count++;
            map.put(num, count);
        }
        List<Map.Entry<Integer, Integer>> list = map.entrySet().stream()
                .sorted((entry1, entry2) -> entry2.getValue() - entry1.getValue())
                .collect(Collectors.toList());

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = list.get(i).getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = {1, 1, 1, 2, 2, 3};
        System.out.println(Arrays.toString(topKFrequent(ints, 2)));

    }

}
