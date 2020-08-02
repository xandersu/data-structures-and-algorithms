package com.xandersu.class082_leetcode.chapter_3;

import com.xandersu.util.SortUtil;

import java.util.Arrays;

/**
 * @author suxun
 * @date 2020/8/2 14:30
 * @description
 */
public class $1_283_Move_Zeroes_My_2 {
    public void moveZeroes(int[] nums) {
        int k = 0;//可以换的位置
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                SortUtil.swap(nums, i, k);
                k++;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 12};
        $1_283_Move_Zeroes_My_2 t = new $1_283_Move_Zeroes_My_2();
        t.moveZeroes(arr);
        System.out.println(Arrays.toString(arr));
    }
}
