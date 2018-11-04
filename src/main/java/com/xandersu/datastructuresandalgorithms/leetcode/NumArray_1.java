package com.xandersu.datastructuresandalgorithms.leetcode;

/**
 * @Author: suxun
 * @Date: 2018/11/4 14:04
 * @Description: 307 range-sum-query-mutable
 */
public class NumArray_1 {

    private int[] sum;
    private int[] data;

    public NumArray_1(int[] nums) {
        data = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            data[i] = nums[i];
        }
        sum = new int[nums.length + 1];
        sum[0] = 0;
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
    }

    public void update(int index, int value) {
        data[index] = value;
        for (int i = index + 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + data[i - 1];
        }
    }

    public int sumRange(int i, int j) {
        return sum[j + 1] - sum[i];
    }
}
