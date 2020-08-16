package com.xandersu.class082_leetcode.chapter_5;

/**
 * @author suxun
 * @date 2020/8/16 15:50
 * @description
 */
public class $5_19_remove_nth_node_from_end_of_list_My {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        int length = 0;
        while (head != null) {
            head = head.next;
            length++;
        }
        int index = length - n;
        if (index < 0) {
            return dummy.next;
        }
        ListNode pre = dummy;
        while (index > 0) {
            pre = pre.next;
            index--;
        }
        if (pre.next != null) {
            pre.next = pre.next.next;
        }
        return dummy.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
