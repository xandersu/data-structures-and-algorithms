package com.xandersu.class082_leetcode.chapter_3;


import java.util.Arrays;

import static com.xandersu.util.SortUtil.swap;

/**
 * @author suxun
 * @date 2020/7/19 14:03
 * @description
 */
public class $3_26_remove_duplicates_from_sorted_array_My {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        //替换的位置
        //[0,k)不重复
        int k = 1;
        int pre = nums[0];

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != pre) {
                swap(nums, i, k);
                pre = nums[k];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int val = 2;
        System.out.println(Arrays.toString(nums));
        int count = removeDuplicates(nums);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }
}
