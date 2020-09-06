package com.xandersu.class082_leetcode.chapter_7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suxun
 * @date 2020/9/6 15:02
 * @description
 */
public class $5_437_path_sum_iii {

    public static int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        return findPath(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
    }

    public static int findPath(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        int val = root.val;
        if (val == sum) {
            res += 1;
        }
        return res + findPath(root.left, sum - val) + findPath(root.right, sum - val);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
