package com.xandersu.class082_leetcode.chapter_7;

/**
 * @author suxun
 * @date 2020/8/30 18:30
 * @description
 */
public class $1_104_maximum_depth_of_binary_tree {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {

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
