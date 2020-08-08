package com.xandersu.class082_leetcode.chapter_4;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author suxun
 * @date 2020/8/8 12:35
 * @description
 */
public class $1_349_intersection_of_two_arrays_My2 {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        List<Integer> l = new ArrayList<>();
        for (Integer s1 : set1) {
            if (set2.contains(s1)) {
                l.add(s1);
            }
        }
        int[] res = new int[l.size()];
        for (int i = 0; i < l.size(); i++) {
            res[i] = l.get(i);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
