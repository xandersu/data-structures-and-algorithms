package com.xandersu.class082_leetcode.chapter_5;

/**
 * @author suxun
 * @date 2020/8/16 15:44
 * @description
 */
public class $4_237_delete_node_in_a_linked_list {
    public void deleteNode(ListNode node) {
        if (node == null) {
            return;
        }
        if (node.next == null) {
            node = null;
            return;
        }
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
