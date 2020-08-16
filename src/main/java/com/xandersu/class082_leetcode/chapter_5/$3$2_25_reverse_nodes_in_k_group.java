package com.xandersu.class082_leetcode.chapter_5;

/**
 * @author suxun
 * @date 2020/8/16 15:21
 * @description
 */
public class $3$2_25_reverse_nodes_in_k_group {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode node1 = head;
        while (node1 != null && node1.next != null) {
            ListNode node2 = node1.next;
            ListNode next = node2.next;

            node1.next = next;
            node2.next = node1;
            pre.next = node2;

            pre = node1;
            node1 = pre.next;
        }
        return dummy.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
