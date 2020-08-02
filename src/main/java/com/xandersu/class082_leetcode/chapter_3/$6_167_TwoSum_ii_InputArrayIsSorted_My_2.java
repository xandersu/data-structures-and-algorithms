package com.xandersu.class082_leetcode.chapter_3;

import java.util.Arrays;

/**
 * @author suxun
 * @date 2020/8/2 15:20
 * @description 二分搜索
 */
public class $6_167_TwoSum_ii_InputArrayIsSorted_My_2 {

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int t = target - numbers[i];
            int l = i + 1;
            int r = numbers.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                if (t == numbers[mid]) {
                    return new int[]{(i + 1), (mid + 1)};
                }
                if (t < numbers[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        System.out.println(Arrays.toString(twoSum(nums, 9)));
    }
}
