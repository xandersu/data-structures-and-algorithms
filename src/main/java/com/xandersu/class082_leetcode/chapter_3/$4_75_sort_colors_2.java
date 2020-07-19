package com.xandersu.class082_leetcode.chapter_3;


import java.util.Arrays;

import static com.xandersu.util.SortUtil.swap;

/**
 * @author suxun
 * @date 2020/7/19 14:03
 * @description 只扫描一次
 * 三路快排的思路
 */
public class $4_75_sort_colors_2 {

    public static void sortColors(int[] nums) {
        //[0,zero]=0
        int zero = -1;
        //[two ,nums.length - 1] = 2
        int two = nums.length;
        int i = 0;
        //[zero,i-1] =1  ;  [i,two-1]待排序
        while (i < two) {
            if (nums[i] == 0) {
                zero++;
                swap(nums, i, zero);
                i++;
            } else if (nums[i] == 2) {
                two--;
                swap(nums, i, two);
            } else {
                i++;
            }
        }

    }


    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
