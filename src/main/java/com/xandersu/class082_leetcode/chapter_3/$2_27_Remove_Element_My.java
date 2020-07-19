package com.xandersu.class082_leetcode.chapter_3;


import java.util.Arrays;

import static com.xandersu.util.SortUtil.swap;

/**
 * @author suxun
 * @date 2020/7/19 14:03
 * @description
 */
public class $2_27_Remove_Element_My {

    public static int removeElement(int[] nums, int val) {
        //[0,k) != val
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                swap(nums, i, k);
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        System.out.println(Arrays.toString(nums));
        int count = removeElement(nums, val);
        System.out.println(count);
        System.out.println(Arrays.toString(nums));
    }
}
