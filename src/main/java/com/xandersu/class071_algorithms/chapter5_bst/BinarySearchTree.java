package com.xandersu.class071_algorithms.chapter5_bst;

import lombok.Data;
import lombok.ToString;

import java.util.Arrays;
import java.util.LinkedList;

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

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder() {
        inOrder(root);
    }

    private void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.println(root);
        inOrder(root.right);
    }

    public void postOrder() {
        postOrder(root);
    }

    private void postOrder(Node root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.println(root);
    }

    //广度优先遍历
    public void levelOrder() {
        if (root == null) {
            return;
        }
        LinkedList<Node> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            Node poll = queue.poll();
            System.out.println(poll);
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
    }

    private Node minimum() {
        return minimum(root);
    }

    public Node minimum(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node;
        while (temp.left != null) {
            temp = temp.left;
        }
        return temp;
    }

    public Node maximun() {
        return maximun(root);
    }

    public Node maximun(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node;
        while (temp.right != null) {
            temp = temp.right;
        }
        return temp;
    }

    //怎么能找到这个节点的上个节点，这里提供的思路，吧处理完成后的节点返回回去，由上层处理。
    //删掉以node为根的二分搜索树中的最小节点，
    //返回删掉节点后新的二分搜索树的根
    public Node removeMin(Node node) {
        if (node.left == null) {
            count--;
            return node.right;
        }
        node.left = removeMin(node.left);
        return node;
    }

    public Node removeMax(Node node) {
        if (node.right == null) {
            count--;
            return node.left;
        }
        node.right = removeMax(node.right);
        return node;
    }

    public Node remove(K k) {
        if (root == null) {
            return null;
        }
        return remove(root, k);
    }

    //删掉以node为根的二叉树中键为k的节点
    //返回删除后的二叉树的根
    private Node remove(Node node, K k) {
        if (node == null) {
            return null;
        }
        if (node.k.compareTo(k) == 0) {
            if (node.left == null) {
                count--;
                return node.right;
            } else if (node.right == null) {
                count--;
                return node.left;
            } else {

            }
            Node minimum = minimum(node.right);
            minimum.left = removeMin(node.right);
            minimum.right = node.right;
            return minimum;
        } else if (node.k.compareTo(k) > 0) {
            node.left = remove(node.left, k);
            return node;
        } else {
            node.right = remove(node.right, k);
            return node;
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

        int N = 10;

        // 创建一个数组，包含[0...N)的所有元素
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = i;
        }

        // 打乱数组顺序
        for (int i = 0; i < N; i++) {
            int pos = (int) (Math.random() * (i + 1));
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
        arr = new Integer[]{13342, 523, 7456, 134, 6785, 45, 1237, 452, 73445, 123};
        for (int i = 0; i < N; i++) {
            bst.insert(arr[i], arr[i]);
        }

        System.out.println(Arrays.toString(arr));
        System.out.println(bst.minimum());
        System.out.println(bst.maximun());
        bst.remove(6785);
        System.out.println(bst);

        System.out.println("===============");
//        System.out.println(bst.removeMin(bst.root));
//        System.out.println(bst.minimum());
//        System.out.println(bst.removeMax(bst.root));
//        System.out.println(bst.maximun());

        // 对[0...2*N)的所有整型测试在二分搜索树中查找
        // 若i在[0...N)之间，则能查找到整型所对应的字符串
        // 若i在[N...2*N)之间，则结果为null
        for (int i = 0; i < 2 * N; i++) {
            Integer res = bst.search(i);
            if (i < N)
                assert res.equals(i);
            else
                assert res == null;
        }

    }

}
