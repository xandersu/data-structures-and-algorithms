package com.xandersu.class082_leetcode.chapter_7;

/**
 * @author suxun
 * @date 2020/8/30 18:37
 * @description 226. 翻转二叉树
 */
public class $2_226_invert_binary_tree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        invertTree(root.left);
        invertTree(root.right);

        return root;
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
