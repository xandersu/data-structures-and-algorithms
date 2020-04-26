package com.xandersu.class207_datastructuresandalgorithms.leetcode;

/**
 * @Author: suxun
 * @Date: 2018/9/26 22:00
 * @Description:
 */
public class RemoveLinkedListElements2 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
