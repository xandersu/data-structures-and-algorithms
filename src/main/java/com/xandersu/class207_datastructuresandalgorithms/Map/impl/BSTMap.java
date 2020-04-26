package com.xandersu.class207_datastructuresandalgorithms.Map.impl;

import com.xandersu.class207_datastructuresandalgorithms.Map.MyMap;

/**
 * @Author: suxun
 * @Date: 2018/10/16 21:51
 * @Description:
 */
public class BSTMap<K extends Comparable<K>, V> implements MyMap<K, V> {

    private Node root;
    private int size;

    public BSTMap() {

    }

    @Override
    public void add(K k, V v) {
        root = add(root, k, v);
    }

    //向以node为根的二分搜索树中插入元素（k，v），递归算法
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        return node;
    }

    @Override
    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root,key);
            return node.value;
        }
        return null;
    }

    //二分搜索树删除任意节点
    private Node remove(Node node, K key) {
        if(node ==null){
            return null;
        }
        if(key.compareTo(node.key)<0){
            node.left = remove(node.left,key);
            return node;
        }else if(key.compareTo(node.key)>0){
            node.right = remove(node.right,key);
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

    private Node minimun(Node node) {
        if (node.left == null) {
            return node;
        }
        return minimun(node.left);
    }

    private Node maxmun(Node node) {
        if (node.right == null) {
            return node;
        }
        return maxmun(node.right);
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

    @Override
    public boolean contains(K k) {
        return getNode(root, k) != null;
    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return node;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

    @Override
    public V get(K k) {
        Node node = getNode(root, k);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesnt exist!");
        }
        node.value = newValue;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public K key;
        public V value;
        public Node left, right;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
