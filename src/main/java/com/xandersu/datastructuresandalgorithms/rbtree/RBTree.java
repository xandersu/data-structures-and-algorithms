package com.xandersu.datastructuresandalgorithms.rbtree;

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
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;
        //右旋过程
        x.right = y;
        y.left = t3;
        return x;
    }

    //左旋转
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = y.left;
        //右旋过程
        x.left = y;
        x.right = t2;
        return x;
    }

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

    //删除以node为根的二分搜索树中最小节点
    //返回删除节点后的心二分搜索树的根
//    private Node removeMin(Node node) {
//        if (node.left == null) {
//            Node rightNode = node.right;
//            node.right = null;
//            size--;
//            return rightNode;
//        }
//        node.left = removeMin(node.left);
//        return node;
//    }

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
