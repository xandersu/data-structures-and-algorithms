package com.xandersu.class207_datastructuresandalgorithms.linked;

import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: suxun
 * @date: 2020/4/26 17:17
 * @description: 一篇文章搞定面试中的链表题目(java实现)
 * https://www.jianshu.com/p/a64d1ef95980
 */
public class MyLinkedList200426 {


    //    @Data
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
                l1Val = l1.val;
            }
            int l2Val = 0;
            if (l2 != null) {
                l2Val = l2.val;
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
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n < 0) {
            return head;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode pre = null;

        while (fast != null) {
            if (n <= 0) {
                pre = slow;
                slow = slow.next;
            }
            fast = fast.next;
            n--;
        }
        if (n > 0) {
            return null;
        }
        if (pre == null) {
            return head.next;
        }
        pre.next = slow.next;

        return head;
    }


    //7.删除链表中重复的元素
    //leetCode 83
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head;
        while (dummy != null && dummy.next != null) {
            if (dummy.val == dummy.next.val) {
                dummy.next = dummy.next.next;
            } else {
                dummy = dummy.next;
            }
        }
        return head;
    }

    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = head;
        Set<Integer> set = new HashSet<>();
        set.add(head.val);
        while (dummy != null && dummy.next != null) {
            int val = dummy.next.val;
            if (set.contains(val)) {
                dummy.next = dummy.next.next;
            } else {
                set.add(val);
                dummy = dummy.next;
            }
        }
        return head;
    }

    //8
    //leetCode 82
    public static ListNode deleteDuplicates2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        head = dummyHead;

        while (head.next != null && head.next.next != null) {

            if (head.next.val == head.next.next.val) {
                int val = head.next.val;
                while (head.next != null && head.next.val == val) {
                    head.next = head.next.next;
                }
            } else {
                head = head.next;
            }
        }
        return dummyHead.next;
    }

    //9.旋转链表
    //61. 旋转链表
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k <= 0) {
            return head;
        }
        ListNode lengthNode = head;
        int length = 0;
        while (lengthNode != null) {
            lengthNode = lengthNode.next;
            length++;
        }
        length = k % length;

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        head = dummyHead;
        ListNode tail = dummyHead;

        for (int i = 0; i < length; i++) {
            head = head.next;
        }

        while (head.next != null) {
            head = head.next;
            tail = tail.next;
        }

        head.next = dummyHead.next;
        dummyHead.next = tail.next;
        tail.next = null;

        return dummyHead.next;
    }

    //官方答案
    static ListNode rotateRight2(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        int length = getLength(head);
        k = k % length;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;
        ListNode tail = dummy;
        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        while (head.next != null) {
            head = head.next;
            tail = tail.next;
        }
        head.next = dummy.next;
        dummy.next = tail.next;
        tail.next = null;
        return dummy.next;
    }

    public static int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }
        int i = 0;
        while (head != null) {
            head = head.next;
            i++;
        }
        return i;
    }


    //10.重排链表
    //LeetCode 13
    public static void reOrder(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }
        ListNode middle = getMiddle10(head);
        ListNode reverse = reverseList10(middle.next);
        middle.next = null;

        int i = 0;
        ListNode prev = new ListNode(0);
        while (head != null && reverse != null) {
            if (i % 2 == 0) {
                prev.next = head;
                head = head.next;
            } else {
                prev.next = reverse;
                reverse = reverse.next;
            }
            i++;
            prev = prev.next;
        }
        prev.next = head != null ? head : reverse;
    }

    public static ListNode reverseList10(ListNode head) {
        if (head == null || head.next == null) {
            return head;
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

    public static ListNode getMiddle10(ListNode head) {
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

    //11.链表划分
    //86. 分隔链表
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode smallDummy = new ListNode(0);
        ListNode smallPrev = smallDummy;
        ListNode largeDummy = new ListNode(0);
        ListNode largePrev = largeDummy;

        while (head != null) {
            if (head.val < x) {
                smallPrev.next = head;
                smallPrev = smallPrev.next;
            } else {
                largePrev.next = head;
                largePrev = largePrev.next;
            }
            head = head.next;
        }
        smallPrev.next = largeDummy.next;
        largePrev.next = null;
        return smallDummy.next;
    }

    //12.翻转链表的n到m之间的节点
    //92. 反转链表 II
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null || m < 0 || n < 0 || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode maxNode = head;

        for (int i = 1; i < m && head != null; i++) {
            head = head.next;
        }
        for (int i = 0; i < n && maxNode != null; i++) {
            maxNode = maxNode.next;
        }

        ListNode temp = head;
        while (head != null && n - m > 0) {
            ListNode next = head.next;
            head.next = temp;
            temp = head;
            head = next;
            n--;
        }
        temp.next = maxNode;
        return dummy.next;
    }

    //13.合并K个排序过的链表
    //LeetCode 23. 合并K个排序链表
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public static ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        if (start >= end) {
            return lists[start];
        }
        int mid = (start + end) / 2;

        ListNode left = mergeKLists(lists, start, mid);
        ListNode right = mergeKLists(lists, mid + 1, end);

        return mergeTwoList(left, right);
    }

    public static ListNode mergeTwoList13(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
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

        return pre.next;
    }


    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        ListNode listNode9 = new ListNode(9);
        ListNode listNode10 = new ListNode(10);
        ListNode listNode11 = new ListNode(11);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        listNode8.next = listNode9;
        listNode9.next = listNode10;
        listNode10.next = listNode11;
        System.out.println(listNode1);

//        ListNode listNode = reverseList(listNode1);
//        System.out.println(listNode);

//        System.out.println(hasCycle(listNode1));

//        System.out.println(sortList(listNode1));

//        System.out.println(getKthFromEnd(listNode1, 2));

//        System.out.println(removeNthFromEnd(listNode1, 2));

//        System.out.println(deleteDuplicates2(listNode1));

//        System.out.println(rotateRight(listNode1, 2));

//        int length = getLength(listNode1);
//        System.out.println(length);
//        System.out.println(listNode1);

//        System.out.println(reOrder(listNode1));
//        reOrder(listNode1);
//        System.out.println(listNode1);

//        System.out.println(partition(listNode1, 5));

//        System.out.println(reverseBetween(listNode1, 5, 6));
        ListNode[] a = {};
        System.out.println(mergeKLists(a));
    }
}
