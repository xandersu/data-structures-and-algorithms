package com.xandersu.my_test;

import com.alibaba.fastjson.JSON;
import com.xandersu.class207_datastructuresandalgorithms.linked.MyLinkedList;
import lombok.Data;
import lombok.ToString;

/**
 * Created by lenovo on 2019/10/30.
 */
public class MyInterfaceLinkedList<E> extends MyLinkedList<E> {
    public static void main(String[] args) {
        ListNode listNode1 = new ListNode();
        listNode1.val = 0;
        for (int i = 2; i < 50; i += 3) {
            listNode1.add(i);
        }
        ListNode listNode2 = new ListNode();
        listNode2.val = 1;
        for (int i = 3; i < 50; i += 7) {
            listNode2.add(i);
        }

        ListNode listNode3 = new ListNode();
        listNode2.val = 1;
        for (int i = 1; i < 50; i += 9) {
            listNode3.add(i);
        }

        System.out.println(ListNodeToString(listNode1));
        System.out.println(ListNodeToString(listNode2));
        System.out.println(ListNodeToString(listNode3));
//        System.out.println(ListNodeToString(merge2ListNode(listNode1, listNode2)));

        ListNode[] arr = {listNode1, listNode2,listNode3};
        System.out.println(ListNodeToString(mergeKListNode(arr)));
    }


    //12.翻转链表的n到m之间的节点
    public void reverseLinkedListM2N() {

    }

    public void reverseLinkedListM2N(ListNode node, int m, int n) {

    }

    public static ListNode mergeKListNode(ListNode[] arr) {
        return mergeKListNode(arr, 0, arr.length - 1);
    }

    public static ListNode mergeKListNode(ListNode[] arr, int start, int end) {
        if (start >= end) {
            return arr[start];
        }
        int middle = start + (end - start) / 2;
        ListNode listNode1 = mergeKListNode(arr, start, middle);
        ListNode listNode2 = mergeKListNode(arr, middle + 1, end);
        return merge2ListNode(listNode1, listNode2);
    }

    public static ListNode merge2ListNode(ListNode node1, ListNode node2) {
        ListNode dummy = new ListNode();
        dummy.next = node1;
        ListNode prev = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                prev.next = node2;
                node2 = node2.next;
            } else {
                prev.next = node1;
                node1 = node1.next;
            }
            prev = prev.next;
        }
        prev.next = node1 == null ? node2 : node1;
        return dummy.next;
    }

    public static String ListNodeToString(ListNode listNode) {
        StringBuilder sb = new StringBuilder();
        sb.append(listNode.val).append(" -> ");
        ListNode next = listNode.next;
        while (next != null) {
            sb.append(next.val).append(" -> ");
            next = next.next;
        }
        sb.replace(sb.length() - 4, sb.length() - 1, "");
        return sb.toString();
    }

    @Data
    @ToString
    public static class ListNode {
        int val;
        ListNode next;

        public void add(int val) {
            ListNode listNode = new ListNode();
            listNode.val = val;
            if (this.next == null) {
                this.next = listNode;
            } else {
                ListNode next = this.next;
                while (next.next != null) {
                    next = next.next;
                }
                next.next = listNode;
            }
        }
    }

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

        public void preFor() {
            preFor(this);
        }

        public void preFor(TreeNode treeNode) {
            if (treeNode == null) {
                return;
            }
            System.out.println(treeNode.getVal());
            preFor(treeNode.left);
            preFor(treeNode.right);
        }

        public void inOrder() {
            inOrder(this);
        }

        public void inOrder(TreeNode treeNode) {
            if (treeNode == null) {
                return;
            }
            preFor(treeNode.left);
            System.out.println(treeNode.getVal());
            preFor(treeNode.right);
        }

        public void afterOrder() {
            afterOrder(this);
        }

        public void afterOrder(TreeNode treeNode) {
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
