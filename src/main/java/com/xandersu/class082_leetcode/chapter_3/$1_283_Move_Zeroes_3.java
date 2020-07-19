package com.xandersu.class082_leetcode.chapter_3;

import com.xandersu.util.SortUtil;

import java.util.Arrays;

import static com.xandersu.util.SortUtil.swap;

/**
 * @author suxun
 * @date 2020/7/19 14:19
 * @description 原地排序
 */
public class $1_283_Move_Zeroes_3 {

    public static void moveZeroes(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                //优化只有不同的元素才交换，不然就是同一个元素不需要交换
                if (nums[i] != nums[k]) {
                    swap(nums, i, k);
                }
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        System.out.println(Arrays.toString(nums));
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

}
