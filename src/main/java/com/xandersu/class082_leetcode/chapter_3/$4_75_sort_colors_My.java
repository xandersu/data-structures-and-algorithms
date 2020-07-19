package com.xandersu.class082_leetcode.chapter_3;


import java.util.Arrays;

import static com.xandersu.util.SortUtil.swap;

/**
 * @author suxun
 * @date 2020/7/19 14:03
 * @description
 */
public class $4_75_sort_colors_My {

    public static void sortColors(int[] nums) {
        quickSort(nums, 0, nums.length - 1);


    }

    private static void quickSort(int[] nums, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition(nums, l, r);
        quickSort(nums, 0, p - 1);
        quickSort(nums, p + 1, r);

    }

    private static int partition(int[] nums, int l, int r) {
        int p = nums[l];
        //[l,j)<p
        int j = l;
        //[i,r]待排序

        for (int i = l + 1; i <= r; i++) {
            if (nums[i] < p) {
                j++;
                swap(nums, j, i);
            }
        }
        swap(nums, j, l);
        return j;
    }


    public static void main(String[] args) {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(Arrays.toString(nums));
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
