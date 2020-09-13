package com.xandersu.class082_leetcode.chapter_8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author suxun
 * @date 2020/9/13 16:28
 * @description
 */
public class $2_46_permutations {
    private final List<List<Integer>> res = new ArrayList<>();
    private boolean[] use;

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        use = new boolean[nums.length];
        LinkedList<Integer> p = new LinkedList<Integer>();
        permute(nums, 0, p);
        return res;
    }

    private void permute(int[] nums, int index, LinkedList<Integer> p) {
        if (index == nums.length) {
            res.add((new ArrayList<>(p)));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!use[i]) {
                use[i] = true;
                p.addLast(nums[i]);
                permute(nums, index + 1, p);
                use[i] = false;
                p.removeLast();
            }
        }
    }
}
