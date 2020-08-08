package com.xandersu.class082_leetcode.chapter_4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @author suxun
 * @date 2020/8/8 13:22
 * @description
 */
public class $2_350_intersection_of_two_arrays_ii {

    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n1 : nums1) {
            map.put(n1, map.getOrDefault(n1, 0) + 1);
        }
        List<Integer> l = new ArrayList<>();
        for (int n2 : nums2) {
            if (map.getOrDefault(n2, 0) > 0) {
                l.add(n2);
                map.put(n2, map.get(n2) - 1);
            }
        }
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;
    }

}
