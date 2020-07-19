package com.xandersu.class082_leetcode.chapter_3;

import com.xandersu.util.SortUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author suxun
 * @date 2020/7/19 14:19
 * @description 原地排序
 */
public class $1_283_Move_Zeroes_2 {

    public static void moveZeroes(int[] nums) {
        //可以替换为非0的位置
        //[0..k)发的元素都是非0元素
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                SortUtil.swap(nums, i, k);
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
