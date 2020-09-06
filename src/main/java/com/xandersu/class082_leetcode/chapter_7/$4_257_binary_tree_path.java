package com.xandersu.class082_leetcode.chapter_7;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suxun
 * @date 2020/9/6 15:02
 * @description
 */
public class $4_257_binary_tree_path {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        if (root.left == null && root.right == null) {
            res.add(String.valueOf(root.val));
            return res;
        }
        List<String> leftPaths = binaryTreePaths(root.left);
        for (String leftPath : leftPaths) {
            res.add(root.val + "->" + leftPath);
        }
        List<String> rightPaths = binaryTreePaths(root.right);
        for (String rightPath : rightPaths) {
            res.add(root.val + "->" + rightPath);
        }
        return res;
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
