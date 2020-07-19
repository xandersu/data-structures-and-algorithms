package com.xandersu.class082_leetcode.chapter_3;

import com.xandersu.util.SortUtil;

import java.util.Arrays;

/**
 * @author suxun
 * @date 2020/7/19 14:03
 * @description
 */
public class $1_283_Move_Zeroes_My {

    public static void moveZeroes(int[] nums) {
        int i = 0;
        int zeroCount = 0;
        while (i < nums.length - zeroCount) {
            if (nums[i] == 0) {
                for (int j = i; j < nums.length - zeroCount - 1; j++) {
                    SortUtil.swap(nums, j, j + 1);
                }
                zeroCount++;
            } else {
                i++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
