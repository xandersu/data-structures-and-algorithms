package com.xandersu.class207_datastructuresandalgorithms.linked;

import lombok.Data;
import lombok.ToString;

/**
 * @author: suxun
 * @date: 2020/4/26 17:17
 * @description: 一篇文章搞定面试中的链表题目(java实现)
 * https://www.jianshu.com/p/a64d1ef95980
 */
public class MyLinkedList200426 {


    @Data
    @ToString
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int x) {
            val = x;
        }
    }

    //1.翻转链表
    public static ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return headNode;
    }

    public static ListNode reverseListNode_V2(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode temp = null;
        while (head != null) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }

    //2.判断链表是否有环
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while (slow != null
                && fast != null
                && slow.next != null
                && fast.next != null) {
            if (slow == fast) {
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (fast == null) {
                break;
            }

        }
        return false;
    }

    //3,链表排序
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode middle = getMiddle(head);
        ListNode rightNode = sortList(middle.next);
        middle.next = null;
        ListNode leftNode = sortList(head);

        return mergeTwoList(leftNode, rightNode);
    }

    public static ListNode getMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static ListNode mergeTwoList(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode dummy = head;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                dummy.next = l1;
                l1 = l1.next;
            } else {
                dummy.next = l2;
                l2 = l2.next;
            }
            dummy = dummy.next;
        }
        dummy.next = l1 != null ? l1 : l2;
        return head.next;
    }

    //4.链表相加求和
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        if (l1 == null || l2 == null) {
            return dummyHead;
        }
        ListNode headNode = dummyHead;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int l1Val = 0;
            if (l1 != null) {
                l1Val = l1.getVal();
            }
            int l2Val = 0;
            if (l2 != null) {
                l2Val = l2.getVal();
            }
            int sum = l1Val + l2Val + carry;
            carry = sum / 10;

            dummyHead.next = new ListNode(sum % 10);
            dummyHead = dummyHead.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry != 0) {
            dummyHead.next = new ListNode(carry);
        }

        return headNode.next;
    }

    //5.得到链表倒数第n个节点
    public static ListNode getKthFromEnd(ListNode head, int k) {
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

    //面试题 02.02. 返回倒数第 k 个节点
    public int kthToLast(ListNode head, int k) {
        if (head == null || k < 0) {
            return 0;
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
            return 0;
        }
        return slow.val;
    }

    //6.删除链表倒数第n个节点
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n < 0) {
            return head;
        }


        return null;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(5);
        ListNode listNode2 = new ListNode(4);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(2);
        ListNode listNode5 = new ListNode(1);
        listNode1.setNext(listNode2);
        listNode2.setNext(listNode3);
        listNode3.setNext(listNode4);
        listNode4.setNext(listNode5);
        System.out.println(listNode1);

//        ListNode listNode = reverseList(listNode1);
//        System.out.println(listNode);

//        System.out.println(hasCycle(listNode1));

//        System.out.println(sortList(listNode1));

//        System.out.println(getKthFromEnd(listNode1, 2));

    }

}
