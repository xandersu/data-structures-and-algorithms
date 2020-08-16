package com.xandersu.class082_leetcode.chapter_5;

import lombok.Data;
import lombok.ToString;

/**
 * @author suxun
 * @date 2020/8/16 14:34
 * @description 203
 */
public class $2_203_remove_linked_list_elements_My {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode pre = dummyHead;
        ListNode cur = dummyHead.next;
        while (cur != null) {
            while (cur != null && cur.val == val) {
                cur = cur.next;
            }
            pre.next = cur;
            pre = cur;
            if (cur == null) {
                break;
            }
            cur = cur.next;
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
