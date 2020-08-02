package com.xandersu.class082_leetcode.chapter_3;

/**
 * @author suxun
 * @date 2020/8/2 17:25
 * @description
 */
public class $7_209_minimum_size_subarray_sum_1 {
    public static int minSubArrayLen(int s, int[] nums) {
        //窗口是[l,r]
        int l = 0;
        int r = -1;

        int minLength = nums.length + 1;
        int sum = 0;
        while (l < nums.length) {
            if (r + 1 < nums.length && sum < s) {
                r++;
                sum += nums[r];
            } else {
                sum -= nums[l];
                l++;
            }
            if (sum >= s) {
                minLength = Math.min(minLength, r - l + 1);
            }
        }
        if (minLength == nums.length + 1) {
            return 0;
        }
        return minLength;
    }

    public static void main(String[] args) {
        int[] nums = {8, 7, 1, 1, 1, 1};
        System.out.println(minSubArrayLen(7, nums));
    }
}
