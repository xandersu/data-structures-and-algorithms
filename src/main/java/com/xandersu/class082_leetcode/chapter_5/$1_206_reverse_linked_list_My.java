package com.xandersu.class082_leetcode.chapter_5;

/**
 * @author suxun
 * @date 2020/8/16 13:21
 * @description
 */
public class $1_206_reverse_linked_list_My {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = pre;
            pre = curr;
            curr = next;
        }
        return pre;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        while (head != null) {
            ListNode next = head.next;

            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public ListNode reverseList3(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode nodeHead = reverseList3(head.next);
        head.next.next = head;
        head.next = null;

        return nodeHead;
    }
}
