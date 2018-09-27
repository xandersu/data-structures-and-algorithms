package com.xandersu.datastructuresandalgorithms.tree;

/**
 * @Author: suxun
 * @Date: 2018/9/27 21:59
 * @Description: 二分搜索树
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
        System.out.println(integerBST);
        System.out.println(integerBST.contains(50));
        System.out.println(integerBST.contains(60));
    }
}
