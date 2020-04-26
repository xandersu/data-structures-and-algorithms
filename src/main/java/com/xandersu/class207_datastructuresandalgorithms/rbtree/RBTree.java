package com.xandersu.class207_datastructuresandalgorithms.rbtree;

import java.util.ArrayList;

/**
 * @Author: suxun
 * @Date: 2018/11/12 22:07
 * @Description:
 */
public class RBTree<K extends Comparable<K>, V> {

    public static final boolean RED = true;
    public static final boolean BLACK = false;

    private Node root;
    private int size;

    public RBTree() {
        root = null;
        size = 0;
    }

    //对y右旋，返回新根结点X
    //    y                       X
    //   / \                    /  \
    //   x  T4    右旋转        z    y
    //  / \       ------>     / \  / \
    // z  t3                 t1 t2 t3 t4
    /// \
    //t1 t2
    private Node rightRotate(Node node) {
        Node x = node.left;
        node.left = x.right;
        x.right = node;
        x.color = node.color;
        node.color = RED;
        return x;
    }

    //左旋转
    //    node                     x
    //  /     \    左旋转         /   \
    // t1      x   ----->     node   t3
    //       / \              /  \
    //      t2 t3            t1   t2
    private Node leftRotate(Node node) {
        Node x = node.right;
        node.right = x.left;
        x.left = node;

        x.color = node.color;
        node.color = RED;
        return x;
    }

    //颜色翻转
    private void flipColors(Node node) {
        node.color = RED;
        node.left.color = BLACK;
        node.right.color = BLACK;
    }

    public void add(K k, V v) {
        root = add(root, k, v);
        root.color = BLACK;
    }

    //向以node为根的二分搜索树中插入元素（k，v），递归算法
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);//默认插红节点
        }

        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        } else {
            node.value = value;
        }
        if (isRed(node.right) && !isRed(node.left)) {
            node = leftRotate(node);
        }
        if (isRed(node.left) && isRed(node.left.left)) {
            node = rightRotate(node);
        }
        if (isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }
        return node;
    }

    private boolean isRed(Node node) {
        return node != null ? node.color == RED : false;
    }

    public boolean isBST() {
        ArrayList<K> keys = new ArrayList<>();
        inOrder(root, keys);
        for (int i = 1; i < keys.size(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    private void inOrder(Node node, ArrayList<K> keys) {
        if (node == null) {
            inOrder(node.left, keys);
            keys.add(node.key);
            inOrder(node.right, keys);
        }
    }

    public V remove(K key) {
        Node node = getNode(root, key);
        if (node != null) {
            root = remove(root, key);
            return node.value;
        }
        return null;
    }

    //二分搜索树删除任意节点
    private Node remove(Node node, K key) {
        if (node == null) {
            return null;
        }
        Node retNode;
        if (key.compareTo(node.key) < 0) {
            node.left = remove(node.left, key);
            retNode = node;
        } else if (key.compareTo(node.key) > 0) {
            node.right = remove(node.right, key);
            retNode = node;
        } else { //key.compareTo(node.key) = 0
            //待删除节点左子树为空
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                retNode = right;
            }
            //待删除节点右子树为空
            else if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                retNode = left;
            } else {
                //左右节点都不为空
                Node successor = minimun(node.right);
                successor.right = remove(node.right, successor.key);
                successor.left = node.left;
                node.left = node.right = null;
                retNode = successor;
            }
        }
        if (retNode == null) {
            return null;
        }
        return retNode;
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

    public V get(K k) {
        Node node = getNode(root, k);
        return node == null ? null : node.value;
    }

    public void set(K key, V newValue) {
        Node node = getNode(root, key);
        if (node == null) {
            throw new IllegalArgumentException(key + "doesnt exist!");
        }
        node.value = newValue;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    private class Node {
        public K key;
        public V value;
        public Node left, right;
        public boolean color;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            left = null;
            right = null;
            color = RED;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "key=" + key +
                    ", value=" + value +
                    ", color=" + color +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }
}
