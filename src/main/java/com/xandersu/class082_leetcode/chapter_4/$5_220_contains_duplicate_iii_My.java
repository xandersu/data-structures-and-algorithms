package com.xandersu.class082_leetcode.chapter_4;

import java.util.TreeSet;

/**
 * @author suxun
 * @date 2020/8/8 18:25
 * @description
 */
public class $5_220_contains_duplicate_iii_My {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            long e = (long) nums[i] - (long) t;
            if (set.ceiling(e) != null && set.ceiling(e) <= (long) nums[i] + (long) t) {
                return true;
            }
            set.add((long) nums[i]);
            if (set.size() > k) {
                set.remove((long) nums[i - k]);
            }
        }
        return false;
    }
}
