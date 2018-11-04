package com.xandersu.datastructuresandalgorithms.leetcode;

import com.xandersu.datastructuresandalgorithms.tree.MySegmentTree;

/**
 * @Author: suxun
 * @Date: 2018/11/4 14:04
 * @Description: 307 range-sum-query-mutable
 */
public class NumArray_2 {


    private MySegmentTree<Integer> segmentTree;

    public NumArray_2(int[] nums) {
        if (nums.length > 0) {
            Integer[] data = new Integer[nums.length];
            for (int i = 0; i < nums.length; i++) {
                data[i] = nums[i];
            }
            segmentTree = new MySegmentTree<>(data, (a, b) -> a + b);
        }
    }

    public void update(int index, int val) {
        if (segmentTree == null) {
            new IllegalArgumentException();
        }
        segmentTree.set(index, val);
    }

    public int sumRange(int i, int j) {
        if (segmentTree == null) {
            throw new IllegalArgumentException();
        }
        return segmentTree.query(i, j);
    }
}
