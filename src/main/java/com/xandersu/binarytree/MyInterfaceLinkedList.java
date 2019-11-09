package com.xandersu.binarytree;

import com.alibaba.fastjson.JSON;
import com.xandersu.datastructuresandalgorithms.linked.MyLinkedList;
import lombok.Data;

/**
 * Created by lenovo on 2019/10/30.
 */
public class MyInterfaceLinkedList<E> extends MyLinkedList<E> {


    //12.翻转链表的n到m之间的节点
    public void reverseLinkedListM2N() {

    }

    public void reverseLinkedListM2N(MyLinkedList.Node node, int m, int n) {

    }


    @Data
    public static class ListNode {
        Integer val = null;
        ListNode left = null;
        ListNode right = null;

        public void add(int i) {
            if (val == null || val == i) {
                val = i;
                return;
            }
            add(this, i);
        }

        public void add(ListNode treeNode, int i) {
            if (treeNode.val == i) {
                return;
            }
            if (treeNode.val > i) {
                if (treeNode.left == null) {
                    treeNode.left = new ListNode();
                    treeNode.left.val = i;
                } else {
                    add(treeNode.left, i);
                }
            } else {
                if (treeNode.right == null) {
                    treeNode.right = new ListNode();
                    treeNode.right.val = i;
                } else {
                    add(treeNode.right, i);
                }
            }
        }

        public void preFor() {
            preFor(this);
        }

        public void preFor(ListNode treeNode) {
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

        public void inOrder(ListNode treeNode) {
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

        public void afterOrder(ListNode treeNode) {
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
