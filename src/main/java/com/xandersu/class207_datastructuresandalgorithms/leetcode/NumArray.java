package com.xandersu.class207_datastructuresandalgorithms.leetcode;

import com.xandersu.class207_datastructuresandalgorithms.tree.MySegmentTree;

/**
 * @Author: suxun
 * @Date: 2018/11/4 13:41
 * @Description: 303. range-sum-query-immutable
 */
public class NumArray {
    private MySegmentTree<Integer> segmentTree;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new MySegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null) {
            throw new IllegalArgumentException();
        }
        return segmentTree.query(i, j);
    }
}
