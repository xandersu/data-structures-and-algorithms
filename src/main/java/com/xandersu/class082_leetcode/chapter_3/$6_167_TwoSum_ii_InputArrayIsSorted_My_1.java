package com.xandersu.class082_leetcode.chapter_3;

import java.util.Arrays;

/**
 * @author suxun
 * @date 2020/8/2 15:20
 * @description 暴力破解 O(n^2)
 */
public class $6_167_TwoSum_ii_InputArrayIsSorted_My_1 {

    public static int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    return new int[]{(i + 1), (j + 1)};
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
