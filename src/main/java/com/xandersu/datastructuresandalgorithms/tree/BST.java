package com.xandersu.datastructuresandalgorithms.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Author: suxun
 * @Date: 2018/9/27 21:59
 * @Description: 二分搜索树
 * 二分搜索树
 * 遍历就是把所有节点都访问一遍
 * 访问的原因与业务有关
 * 在线性结构下，遍历是容易的，树并不难
 * 前序遍历：（访问节点在访问子树前面），最常用，最自然
 * 对于遍历操作，两颗子树都要顾及
 * 中序遍历：左子树，根结点，右子树
 * ----------------------------
 * 二分搜索树遍历的非递归实现比递归复杂的多
 * 中序和后序遍历的非递归实现更复杂
 * 中序和后序遍历的非递归实现，实际应用不广
 * 都是深度优先
 * ==================================
 * 层序遍历，广度优先
 * 更快的找到问题的解
 * 常用语算法设计中-最短路径
 * 图中的深度优先和广度优先遍历
 * ==================================
 * 二分搜索树顺序性：
 * 最大值，最小值；前驱，后继；floor，ceil；rank：排名第几，加size，select：排名第几的是谁，加size；
 * 维护depth（深度）；支持重复元素的二分搜索树，加count；
 */
public class BST<E extends Comparable<E>> {

    private class Node {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "e=" + e +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    private void add(Node node, E e) {
        if (e.equals(node.e)) {
            return;
        } else if (node.left == null && node.e.compareTo(e) > 0) {
            node.left = new Node(e);
            size++;
            return;
        } else if (node.right == null && node.e.compareTo(e) < 0) {
            node.right = new Node(e);
            size++;
            return;
        }
        if (node.e.compareTo(e) > 0) {
            add(node.left, e);
        } else {
            add(node.right, e);
        }
    }

    public void add2(E e) {
        root = add2(root, e);
    }

    private Node add2(Node node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (node.e.compareTo(e) > 0) {
            node.left = add2(node.left, e);
        } else {
            node.right = add2(node.right, e);
        }
        return node;
    }

    public boolean contains(E e) {
        return contains(root, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }
        if (node.e.equals(e)) {
            return true;
        } else if (node.e.compareTo(e) > 0) {
            return contains(node.left, e);
        } else {
            return contains(node.right, e);
        }
    }

    //二分搜索树的前序遍历
    public void preOrder() {
        preOrder(root);
    }

    //前序遍历以node为根的二分搜索树，递归算法
    private void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.e);
        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrderNR() {
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
    }

    //中序遍历
    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.println(node.e);
        inOrder(node.right);
    }

    //后序遍历(内存释放)
    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.e);
    }

    //广度优先遍历
    public void levelOrder() {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            Node cur = q.remove();
            System.out.println(cur.e);
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
    }

    public E minimun() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        return minimun(root).e;
    }

    private Node minimun(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimun(node.left);
    }

    public E maxmun() {
        if (size == 0) {
            throw new IllegalArgumentException("BST is Empty");
        }
        return maxmun(root).e;
    }

    private Node maxmun(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxmun(node.right);
    }

    public E removeMin(){
        E ret = minimun();
        root = removeMin(root);
        return ret;
    }

    //删除以node为根的二分搜索树中最小节点
    //返回删除节点后的心二分搜索树的根
    private Node removeMin(Node node) {
        if(node.left == null){
            Node rightNode = node.right;
            node.right = null;
            size--;
            return rightNode;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public E removeMax(){
        E ret = maxmun();
        root = removeMax(root);
        return ret;
    }

    //删除以node为根的二分搜索树中最小节点
    //返回删除节点后的心二分搜索树的根
    private Node removeMax(Node node) {
        if(node.right == null){
            Node leftNode = node.left;
            node.left = null;
            size--;
            return leftNode;
        }
        node.right = removeMax (node.right);
        return node;
    }

    public void remove(E e){
       root = remove(root,e);
    }

    //二分搜索树删除任意节点
    private Node remove(Node node, E e) {
        if(node ==null){
            return null;
        }
        if(e.compareTo(node.e)<0){
            node.left = remove(node.left,e);
            return node;
        }else if(e.compareTo(node.e)>0){
            node.right = remove(node.right,e);
            return node;
        }else{
            if(node.left==null){
              Node right = node.right;
              node.right = null;
              size--;
              return right;
            }
            if(node.right==null){
                Node left = node.left;
                node.left = null;
                size--;
                return left;
            }

            Node successor = minimun(node.right);
            successor.right = removeMin(node.right);
            successor.left = node.left;
            node.left = node.right = null;
            return successor;
        }
    }


    @Override
    public String toString() {
        return "BST{" +
                "root=" + root +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        BST<Integer> integerBST = new BST<>();
        integerBST.add2(100);
        integerBST.add2(80);
        integerBST.add2(110);
        integerBST.add2(120);
        integerBST.add2(130);
        integerBST.add2(60);
        integerBST.add2(90);
        integerBST.add2(105);
        //          100
        //    80            110
        //  60   90    105      120
        //                          130
        System.out.println(integerBST);
//        System.out.println(integerBST.contains(50));
//        System.out.println(integerBST.contains(60));
//        integerBST.preOrder();
//        System.out.println("====");
//        integerBST.inOrder();
//        System.out.println("====");
//        integerBST.postOrder();
//        System.out.println("====");
//        integerBST.preOrderNR();
//        System.out.println("====");
//        integerBST.levelOrder();
//        integerBST.removeMax();
//        System.out.println(integerBST);
//        integerBST.removeMin();
//        System.out.println(integerBST);
//        for (int i = 0; i < 8; i++) {
//            System.out.println(integerBST.removeMin());
//        }
//        for (int i = 0; i < 8; i++) {
//            System.out.println(integerBST.removeMax());
//        }
        integerBST.remove(60);
        System.out.println(integerBST);
        for (int i = 0; i < 8; i++) {
            System.out.println(integerBST.removeMin());
        }
    }
}
