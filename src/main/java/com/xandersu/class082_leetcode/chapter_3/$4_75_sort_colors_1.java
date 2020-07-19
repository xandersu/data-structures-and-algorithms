package com.xandersu.class082_leetcode.chapter_3;


import java.util.Arrays;

import static com.xandersu.util.SortUtil.swap;

/**
 * @author suxun
 * @date 2020/7/19 14:03
 * @description 计数排序，适合元素个数有限的排序
 */
public class $4_75_sort_colors_1 {

    public static void sortColors(int[] nums) {
        int[] count = new int[3];
        for (int i = 0; i < nums.length; i++) {
            count[nums[i]]++;
        }

        int index = 0;
        for (int i = 0; i < count[0]; i++) {
            nums[index++] = 0;
        }
        for (int i = 0; i < count[1]; i++) {
            nums[index++] = 1;
        }
        for (int i = 0; i < count[2]; i++) {
            nums[index++] = 2;
        }
    }


    public static void main(String[] args) {
        int[] nums = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
