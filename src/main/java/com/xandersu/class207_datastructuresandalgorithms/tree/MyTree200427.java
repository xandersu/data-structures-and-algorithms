package com.xandersu.class207_datastructuresandalgorithms.tree;

import lombok.ToString;
import lombok.val;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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

    //2.求二叉树的最小深度
    //111. 二叉树的最小深度
    //很多人写出的代码都不符合 1,2 这个测试用例，是因为没搞清楚题意
    //
    //题目中说明:叶子节点是指没有子节点的节点，这句话的意思是 1 不是叶子节点
    //题目问的是到叶子节点的最短距离，所以所有返回结果为 1 当然不是这个结果
    //另外这道题的关键是搞清楚递归结束条件:
    //1.叶子节点的定义是左孩子和右孩子都为 null 时叫做叶子节点
    //2.当 root 节点左右孩子都为空时，返回 1
    //3.当 root 节点左右孩子有一个为空时，返回不为空的孩子节点的深度
    //4.当 root 节点左右孩子都不为空时，返回左右孩子较小深度的节点值
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int min = Integer.MAX_VALUE;
        //
        if (root.left != null) {
            min = minDepth(root.left);
        }
        if (root.right != null) {
            min = Math.min(minDepth(root.right), min);
        }
        return min + 1;
    }

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if (root.left != null) {
            left = minDepth(root.left);
        }

        if (root.right != null) {
            right = minDepth(root.right);
        }
        return Math.min(left, right) + 1;
    }

    //3,求二叉树中节点的个数
    public static int numOfTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return numOfTreeNode(root.left) + numOfTreeNode(root.right) + 1;
    }

    //4,求二叉树中叶子节点的个数
    public static int numsOfNoChildNode(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return numsOfNoChildNode(root.left) + numsOfNoChildNode(root.right);
    }

    //5.求二叉树中第k层节点的个数
    public static int numsOfkLevelTreeNode(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        k -= 1;
        return numsOfkLevelTreeNode(root.left, k) + numsOfkLevelTreeNode(root.right, k);
    }

    //6.判断二叉树是否是平衡二叉树
    //给定一个二叉树，判断它是否是高度平衡的二叉树。
    //本题中，一棵高度平衡二叉树定义为：
    //一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过1。
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        int leftHeight = getHigh6(root.left);
        int rightHeight = getHigh6(root.right);
        if (Math.abs(leftHeight - rightHeight) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    public static int getHigh6(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHigh6(root.left), getHigh6(root.right)) + 1;
    }

    //7.判断二叉树是否是完全二叉树
    //958. 二叉树的完全性检验
    //给定一个二叉树，确定它是否是一个完全二叉树。
    //若设二叉树的深度为 h，除第 h 层外，其它各层 (1～h-1) 的结点数都达到最大个数，第 h 层所有的结点都连续集中在最左边，这就是完全二叉树。（注：第 h 层可能包含 1~ 2h 个节点。）
    public static boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return true;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.push(root);
        boolean flag = false;
        while (!linkedList.isEmpty()) {
            int curCount = linkedList.size();
            for (int i = 0; i < curCount; i++) {
                TreeNode poll = linkedList.poll();
                if (poll != null) {
                    if (flag) {
                        return false;
                    }
                    linkedList.add(poll.left);
                    linkedList.add(poll.right);
                } else {
                    flag = true;
                }
            }
        }
        return true;
    }

    //8.两个二叉树是否完全相同
    //100. 相同的树
    //如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。
    public static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        } else if (p == null || q == null) {
            return false;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    //9.两个二叉树是否互为镜像
    //101. 对称二叉树
    public static boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        } else if (t1 == null || t2 == null) {
            return false;
        }
        if (t1.val != t2.val) {
            return false;
        }
        return isMirror(t1.left, t2.right) && isMirror(t1.right, t2.left);
    }

    //10.翻转二叉树or镜像二叉树
    //226. 翻转二叉树
    //剑指offer 面试题27. 二叉树的镜像
    TreeNode mirrorTreeNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = mirrorTreeNode(root.left);
        TreeNode right = mirrorTreeNode(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode treeNode = new TreeNode(root.val);
        treeNode.left = invertTree(root.right);
        treeNode.right = invertTree(root.left);

        return treeNode;
    }

    //11.求两个二叉树的最低公共祖先节点
    //236. 二叉树的最近公共祖先
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    //235. 二叉搜索树的最近公共祖先
    public TreeNode lowestCommonAncestor235(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor235(root.right, p, q);
        } else if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor235(root.left, p, q);
        }
        return root;
    }

    //12.二叉树的前序遍历
    //144. 二叉树的前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorderTraversal(root, list);
        return list;
    }

    private void preorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preorderTraversal(root.left, list);
        preorderTraversal(root.right, list);
    }

    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while (!stack.isEmpty()) {
            TreeNode pop = stack.pop();
            list.add(pop.val);

            if (pop.right != null) {
                stack.push(pop.right);
            }
            if (pop.left != null) {
                stack.push(pop.left);
            }
        }
        return list;
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

//        System.out.println(maxDepth(root));

//        System.out.println(minDepth(root));

//        System.out.println(numOfTreeNode(root));

//        System.out.println(numsOfNoChildNode(root));

//        System.out.println(numsOfkLevelTreeNode(root, 4));

//        System.out.println(isBalanced(root));

//        System.out.println(isCompleteTree(root));


    }
}
