package com.xandersu.class082_leetcode.chapter_7;

import java.util.List;

/**
 * @author suxun
 * @date 2020/8/30 18:48
 * @description
 */
public class $3_112_path_sum_MY {
    public static boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        return hasPathSum(root, sum, 0);
    }

    public static boolean hasPathSum(TreeNode root, int sum, int temp) {
        temp += root.val;
        if (root.left == null && root.right == null) {
            //到达叶子节点
            if (sum == temp) {
                return true;
            }
        }
        if (root.left != null) {
            if (hasPathSum(root.left, sum, temp)) {
                return true;
            }
        }
        if (root.right != null) {
            if (hasPathSum(root.right, sum, temp)) {
                return true;
            }
        }
        return false;
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
