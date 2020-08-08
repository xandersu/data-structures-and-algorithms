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
public class $1_349_intersection_of_two_arrays_My {

    public static int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null) {
            return nums2;
        }
        if (nums2 == null) {
            return nums1;
        }
        Set<Integer> resultSet = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            int num = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (num == nums2[j]) {
                    resultSet.add(num);
                }
            }
        }
        int[] res = new int[resultSet.size()];
        int index = 0;
        for (int num : resultSet) {
            res[index++] = num;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
