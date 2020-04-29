package com.xandersu.my_test;

import com.alibaba.fastjson.JSON;
import lombok.Data;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by lenovo on 2019/10/29.
 * 求二叉树中第k层节点的个数
 */
public class BTreeNFloorPointNum {

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode();
        treeNode.add(10);
        treeNode.add(20);
        treeNode.add(5);
        treeNode.add(80);
        treeNode.add(0);
        treeNode.add(15);
        treeNode.add(14);
        treeNode.add(-1);
//        System.out.println(treeNode);

        treeNode.preFor();
        System.out.println("=====");
        treeNode.inOrder();
        System.out.println("=====");
        treeNode.afterOrder();

        //5.求二叉树中第k层节点的个数
//        System.out.println("第" + 1 + "层个数=" + getFloorSize(treeNode, 1));
//        System.out.println(getFloorSize(treeNode, 2));
//        System.out.println(getFloorSize(treeNode, 3));
//        System.out.println(getFloorSize(treeNode, 4));
//
//        System.out.println(numsOfkLevelTreeNode(treeNode, 1));
//        System.out.println(numsOfkLevelTreeNode(treeNode, 2));
//        System.out.println(numsOfkLevelTreeNode(treeNode, 3));
//        System.out.println(numsOfkLevelTreeNode(treeNode, 4));
        //1.求二叉树的最大深度
//        System.out.println("二叉树的最大深度=" + maxHeight(treeNode));
//        System.out.println("二叉树的最小深度=" + minHeight(treeNode));
//        System.out.println("求二叉树中节点的个数=" + getNodeSize(treeNode));
//        System.out.println("求二叉树中节点的个数=" + numOfTreeNode(treeNode));
//        System.out.println("求二叉树中叶子节点的个数=" + getleafNodeSize(treeNode));


    }

    //1.求二叉树的最大深度
    public static int maxHeight(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(maxHeight(treeNode.left), maxHeight(treeNode.right)) + 1;
    }

    //2.求二叉树的最小深度????
//    public static int minHeight(TreeNode treeNode) {
//        if (treeNode == null) {
//            return 0;
//        }
//        TreeNode left = treeNode.left;
//        TreeNode right = treeNode.right;
//        if (left == null || right == null) {
//            return 0;
//        }
//        return Math.min(minHeight(left), minHeight(right)) + 1;
//    }

    //3,求二叉树中节点的个数
    private static int getNodeSize(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        return getNodeSize(left) + getNodeSize(right) + 1;
    }

    //4,求二叉树中叶子节点的个数
    private static int getleafNodeSize(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        TreeNode left = treeNode.left;
        TreeNode right = treeNode.right;
        if (left == null && right == null) {
            return 1;
        }
        return getleafNodeSize(left) + getleafNodeSize(right);
    }

    //5.求二叉树中第k层节点的个数
    private static int getFloorSize(TreeNode treeNode, int selectedFloor) {
        if (treeNode == null || selectedFloor <= 0) {
            return 0;
        }
        if (selectedFloor == 1) {
            return 1;
        }
        return getFloorSize(treeNode.left, selectedFloor - 1)
                + getFloorSize(treeNode.right, selectedFloor - 1);
    }

    //6.判断二叉树是否是平衡二叉树

    //从上往下打印出二叉树的每个节点，同层节点从左至右打印。
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        Deque<TreeNode> tempDeque = new LinkedList<>();
        tempDeque.addFirst(root);
        while (!tempDeque.isEmpty()){
            TreeNode treeNode = tempDeque.pollFirst();
            res.add(treeNode.val);
            if (treeNode.left != null) {
                tempDeque.addLast(treeNode.left);
            }
            if (treeNode.right != null) {
                tempDeque.addLast(treeNode.right);
            }
        }
        return res;
    }

    //从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        Print(pRoot,1,res);
        return res;
    }

    private void Print(TreeNode pRoot, int deep, ArrayList<ArrayList<Integer>> res) {
        if (pRoot == null) {
            return;
        }
        if(deep>res.size()){
            ArrayList<Integer> temp = new ArrayList<>();
            temp.add(pRoot.val);
            res.add(temp);
        }else{
            ArrayList<Integer> temp = res.get(deep);
            temp.add(pRoot.val);
        }
        Print(pRoot.left,deep+1,res);
        Print(pRoot.right,deep+1,res);
    }

    //==========================================================================
    static int getMinDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return getMin(root);
    }

    static int getMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        return Math.min(getMin(root.left), getMin(root.right)) + 1;
    }

    //
    static int numOfTreeNode(TreeNode root) {
        if (root == null) {
            return 0;

        }
        int left = numOfTreeNode(root.left);
        int right = numOfTreeNode(root.right);
        return left + right + 1;
    }

    //5.求二叉树中第k层节点的个数
    static int numsOfkLevelTreeNode(TreeNode root, int k) {
        if (root == null || k < 1) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        int numsLeft = numsOfkLevelTreeNode(root.left, k - 1);
        int numsRight = numsOfkLevelTreeNode(root.right, k - 1);
        return numsLeft + numsRight;
    }


//    public static int minDepth(TreeNode root){
//        if(root==null) return 0;
//        if(root.left==null) return minDepth(root.right);//左边为空，取右边的深度
//        if (root.right != null) {
//            int m = minDepth(root.left);
//            int n = minDepth(root.right);
//            return (m<n?m:n) +1;
//        } else {
//            return minDepth(root.left);//右边为空，取左边的深度
//        }
//    }

//    public static int minDepth(TreeNode root) {
//        if(root==null) return 0;
//        int leftminlength=minDepth(root.left);
//        int rightminlength=minDepth(root.right);
//        if(leftminlength==0&&rightminlength>0) {
//            return rightminlength + 1;
//        } else {
//            if (rightminlength == 0 && leftminlength > 0) return leftminlength + 1;
//            else {
//                return (leftminlength < rightminlength) ? leftminlength + 1 : rightminlength + 1;
//            }
//        }
//    }


    @Data
    public static class TreeNode {
        Integer val = null;
        TreeNode left = null;
        TreeNode right = null;

        public void add(int i) {
            if (val == null || val == i) {
                val = i;
                return;
            }
            add(this, i);
        }

        public void add(TreeNode treeNode, int i) {
            if (treeNode.val == i) {
                return;
            }
            if (treeNode.val > i) {
                if (treeNode.left == null) {
                    treeNode.left = new TreeNode();
                    treeNode.left.val = i;
                } else {
                    add(treeNode.left, i);
                }
            } else {
                if (treeNode.right == null) {
                    treeNode.right = new TreeNode();
                    treeNode.right.val = i;
                } else {
                    add(treeNode.right, i);
                }
            }
        }

        public void preFor(){
            preFor(this);
        }
        public void preFor(TreeNode treeNode){
            if (treeNode == null) {
                return;
            }
            System.out.println(treeNode.getVal());
            preFor(treeNode.left);
            preFor(treeNode.right);
        }

        public void inOrder(){
            inOrder(this);
        }
        public void inOrder(TreeNode treeNode){
            if (treeNode == null) {
                return;
            }
            preFor(treeNode.left);
            System.out.println(treeNode.getVal());
            preFor(treeNode.right);
        }

        public void afterOrder(){
            afterOrder(this);
        }
        public void afterOrder(TreeNode treeNode){
            if (treeNode == null) {
                return;
            }
            preFor(treeNode.left);
            preFor(treeNode.right);
            System.out.println(treeNode.getVal());
        }

        @Override
        public String toString() {
            return JSON.toJSONString(this);
        }
    }
}
