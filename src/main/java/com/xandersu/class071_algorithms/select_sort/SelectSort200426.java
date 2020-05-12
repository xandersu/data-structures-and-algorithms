package com.xandersu.class071_algorithms.select_sort;

import com.xandersu.class071_algorithms.SortUtil;

import java.util.Arrays;

/**
 * @author: suxun
 * @date: 2020/4/26 16:31
 * @description:
 */
public class SelectSort200426 {

    public static void selectSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            int smallPoint = i;
            int benchmarkNum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                int compareNum = nums[j];
                if (benchmarkNum > compareNum) {
                    benchmarkNum = compareNum;
                    smallPoint = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[smallPoint];
            nums[smallPoint] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = SortUtil.generatePrintArr(10, 100);
        System.out.println(Arrays.toString(nums));
        selectSort(nums);
        System.out.println(Arrays.toString(nums));
    }

}
