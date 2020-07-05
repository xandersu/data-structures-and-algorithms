package com.xandersu.class071_algorithms.chapter5_bst;

import lombok.Data;
import lombok.ToString;

/**
 * @author suxun
 * @date 2020/7/5 18:29
 * @description
 */
@Data
@ToString
public class BinarySearchTree<K extends Comparable<K>, V> {

    @Data
    @ToString
    public class Node {
        private Node left;
        private Node right;

        private K k;
        private V v;

        public Node() {
        }

        public Node(K k, V v) {
            this.k = k;
            this.v = v;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int count;

    public BinarySearchTree() {
        this.root = null;
        count = 0;
    }

    /**
     * 插入——递归自己解法
     */
    public void insert_my(K k, V v) {
        Node node = new Node(k, v);
        if (root == null) {
            root = node;
        } else {
            insert_my(root, node);
        }
        count++;
    }

    private void insert_my(Node node, Node insertNode) {
        if (node.k.compareTo(insertNode.k) > 0) {
            if (node.left == null) {
                node.left = insertNode;
            } else {
                insert_my(node.left, insertNode);
            }
        } else {
            if (node.right == null) {
                node.right = insertNode;
            } else {
                insert_my(node.right, insertNode);
            }
        }
    }

    /**
     * 插入——递归讲师解法
     */
    public void insert(K k, V v) {
        root = insert(root, k, v);
        count++;
    }

    private Node insert(Node node, K k, V v) {
        if (node == null) {
            return new Node(k, v);
        }
        if (node.k.compareTo(k) == 0) {
            node.v = v;
        } else if (node.k.compareTo(k) > 0) {
            node.left = insert(node.left, k, v);
        } else {
            node.right = insert(node.right, k, v);
        }
        return node;
    }

    /**
     * 插入——循环解法
     */
    public void insert_loop(K k, V v) {
        Node node = new Node(k, v);
        if (root == null) {
            this.root = node;
            return;
        }
        Node temp = this.root;
        while (true) {
            if (temp.k.compareTo(k) == 0) {
                temp.v = v;
                break;
            } else if (temp.k.compareTo(k) > 0) {
                if (temp.left == null) {
                    temp.left = node;
                    break;
                } else {
                    temp = temp.left;
                }
            } else {
                if (temp.right == null) {
                    temp.right = node;
                    break;
                } else {
                    temp = temp.right;
                }
            }
        }
    }

    public V search(K k) {
        return search(root, k);
    }

    private V search(Node node, K k) {
        if (node == null) {
            return null;
        }
        if (node.k.compareTo(k) == 0) {
            return node.v;
        } else if (node.k.compareTo(k) > 0) {
            return search(node.left, k);
        } else {
            return search(node.right, k);
        }
    }

    public boolean contains(K k) {
        return contains(root, k);
    }

    private boolean contains(Node node, K k) {
        if (node == null) {
            return false;
        }
        if (node.k.compareTo(k) == 0) {
            return true;
        } else if (node.k.compareTo(k) > 0) {
            return contains(node.left, k);
        } else {
            return contains(node.right, k);
        }
    }


    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }


    public static void main(String[] args) {
        BinarySearchTree<Integer, Integer> bst = new BinarySearchTree<>();
//        for (int i = 0; i < 10; i++) {
//            bst.insert_loop(i, i);
//        }
//        System.out.println(bst.toString());
//
//        System.out.println("search 1= " + bst.search(-1));
//        System.out.println("search 1= " + bst.search(0));
//        System.out.println("search 1= " + bst.search(5));
//        System.out.println("search 1= " + bst.search(10));

        int N = 1000000;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for(int i = 0 ; i < N ; i ++)
            arr[i] = i;

        // 打乱数组顺序
        for(int i = 0 ; i < N ; i ++){
            int pos = (int) (Math.random() * (i+1));
            Integer t = arr[pos];
            arr[pos] = arr[i];
            arr[i] = t;
        }
        // 由于我们实现的二分搜索树不是平衡二叉树，
        // 所以如果按照顺序插入一组数据，我们的二分搜索树会退化成为一个链表
        // 平衡二叉树的实现，我们在这个课程中没有涉及，
        // 有兴趣的同学可以查看资料自学诸如红黑树的实现
        // 以后有机会，我会在别的课程里向大家介绍平衡二叉树的实现的：）


        // 我们测试用的的二分搜索树的键类型为Integer，值类型为String
        // 键值的对应关系为每个整型对应代表这个整型的字符串

        for(int i = 0 ; i < N ; i ++){
            bst.insert(arr[i], arr[i]);
        }

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for(int i = 0 ; i < 2*N ; i ++){
            Integer res = bst.search(i);
            if( i < N )
                assert res.equals(i);
            else
                assert res == null;
        }

    }

}
