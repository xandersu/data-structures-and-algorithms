package com.xandersu.class207_datastructuresandalgorithms.tree;

import lombok.ToString;

/**
 * @author: suxun
 * @date: 2020/4/27 11:34
 * @description: 一篇文章搞定面试中的二叉树题目(java实现)
 * https://www.jianshu.com/p/0190985635eb
 */
public class MyTree200427 {

    @ToString
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //1.求二叉树的最大深度
    //104. 二叉树的最大深度
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode l1 = new TreeNode(9);
        TreeNode r1 = new TreeNode(20);
        TreeNode r1l2 = new TreeNode(15);
        TreeNode r1r2 = new TreeNode(7);

        root.left = l1;
        root.right = r1;
        root.right.left = r1l2;
        root.right.right = r1r2;
        System.out.println(root);

        System.out.println(maxDepth(root));

    }
}
