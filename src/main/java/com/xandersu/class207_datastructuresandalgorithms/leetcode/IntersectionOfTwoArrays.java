package com.xandersu.class207_datastructuresandalgorithms.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

/**
 * @Author: suxun
 * @Date: 2018/10/21 11:46
 * @Description:
 */
public class IntersectionOfTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        TreeSet<Integer> set = new TreeSet<>();
        for (int num : nums1) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>();
        for (int num : nums2) {
            if (set.contains(num)) {
                list.add(num);
                set.remove(num);
            }
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
