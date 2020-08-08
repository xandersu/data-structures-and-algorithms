package com.xandersu.class082_leetcode.chapter_4;

import java.util.TreeSet;

/**
 * @author suxun
 * @date 2020/8/8 18:25
 * @description
 */
public class $5_220_contains_duplicate_iii {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        // 这个问题的测试数据在使用int进行加减运算时会溢出
        // 所以使用long long
        TreeSet<Long> record = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            if (record.ceiling((long) nums[i] - (long) t) != null &&
                    record.ceiling((long) nums[i] - (long) t) <= (long) nums[i] + (long) t)
                return true;

            record.add((long) nums[i]);
            if (record.size() == k + 1)
                record.remove((long) nums[i - k]);
        }

        return false;
    }
}
