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
}
