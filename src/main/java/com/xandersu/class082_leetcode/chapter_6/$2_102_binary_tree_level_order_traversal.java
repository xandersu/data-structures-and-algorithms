package com.xandersu.class082_leetcode.chapter_6;

import lombok.ToString;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author suxun
 * @date 2020/8/16 17:37
 * @description
 */
public class $2_102_binary_tree_level_order_traversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<TreeNode> list = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode poll = queue.poll();
                if (poll != null) {
                    list.add(poll);
                }
            }
            res.add(list.stream().map(item -> item.val).collect(Collectors.toList()));
            for (TreeNode treeNode : list) {
                if (treeNode.left != null) {
                    queue.offer(treeNode.left);

                }
                if (treeNode.right != null) {
                    queue.offer(treeNode.right);
                }
            }
        }
        Collections.reverse(res);
        return res;
    }

    @ToString
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

}
