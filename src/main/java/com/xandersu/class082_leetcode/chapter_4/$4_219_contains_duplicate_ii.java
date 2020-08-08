package com.xandersu.class082_leetcode.chapter_4;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author suxun
 * @date 2020/8/8 16:36
 * @description
 */
public class $4_219_contains_duplicate_ii {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                return true;
            }
            set.add(nums[i]);
            if (set.size() > k + 1) {
                set.remove(nums[i - k]);
            }

        }
        return false;
    }
}
