package com.xandersu.refertooffer;

/**
 * @author: suxun
 * @date: 2020/4/27 13:42
 * @description: 面试题22. 链表中倒数第k个节点
 */
public class P22GetKthFromEnd {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null) {
            if (k <= 0) {
                slow = slow.next;
            }
            fast = fast.next;
            k--;
        }
        if (k > 0) {
            return null;
        }
        return slow;
    }
}
