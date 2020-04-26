package com.xandersu.class207_datastructuresandalgorithms.leetcode;

/**
 * @Author: suxun
 * @Date: 2018/9/26 22:00
 * @Description:
 */
public class RemoveLinkedListElements3 {

    public ListNode removeElements(ListNode head, int val) {

        if (head == null) {
            return null;
        }

        ListNode res = removeElements(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
