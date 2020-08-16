package com.xandersu.class082_leetcode.chapter_5;

import lombok.ToString;

/**
 * @author suxun
 * @date 2020/8/16 14:34
 * @description 203
 */
public class $2_203_remove_linked_list_elements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }

        }
        return dummyHead.next;
    }


    @ToString
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
