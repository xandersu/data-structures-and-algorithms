package com.xandersu.datastructuresandalgorithms.linked;

/**
 * @Author: suxun
 * @Date: 2018/9/25 21:52
 * @Description:
 */
public class MyLinkedList<E> {

    //虚拟头节点
    private Node dummyHead;
    private int size;

    public MyLinkedList() {
        dummyHead = new Node(null, null);
        size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("角标越界");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
//            Node node = new Node(e);
//            node.next = prev.next;
//            prev.next = node;
        prev.next = new Node(e, prev.next);
        size++;

    }

    public void addFirst(E e) {
        add(e, 0);
    }

    public void addLast(E e) {
        add(e, size);
    }

    public E get(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("角标越界");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(E e, int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("角标月越界");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public E remove(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("角标月越界");
        }
        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void reverseLinkedList(MyLinkedList<E> list) {
        list.dummyHead.next = reverseLinkedList(list.dummyHead.next);
    }

    private Node reverseLinkedList(Node node) {
        if (node == null || node.next == null) {
            return node;
        } else {
            Node headNode = reverseLinkedList(node.next);
            node.next.next = node;
            node.next = null;
            return headNode;
        }
    }

    //====================================================================
    //自己实现的反转链表
    public void myWhileReverseLinked() {
        this.dummyHead.next = myWhileReverseLinked(this.dummyHead.next);
    }

    //自己实现的反转链表
    private Node myWhileReverseLinked(Node node) {
        Node prev = null;
        while (node != null) {
            Node temp = node.next;
            node.next = prev;
            prev = node;
            node = temp;
        }
        return prev;
    }

    //
    public void reverseN2M(int m, int n) {
        this.dummyHead.next = reverseN2M(this.dummyHead.next, m, n);
    }

    Node reverseN2M(Node head, int m, int n) {
        if (m >= n || head == null) {
            return head;
        }
        Node dummy = new Node();
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }
        Node pmNode = head;
        Node mNode = head.next;
        Node nNode = mNode;
        Node pnNode = mNode.next;
        for (int i = m; i < n; i++) {
            if (pnNode == null) {
                return null;
            }
            Node tmp = pnNode.next;
            pnNode.next = nNode;
            nNode = pnNode;
            pnNode = tmp;
        }
        pmNode.next = nNode;
        mNode.next = pnNode;
        return dummy.next;
    }

    public Node reverseBetween(Node head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        Node dummy = new Node();
        dummy.next = head;
        head = dummy;
        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        Node pmNode = head;
        Node mNode = head.next;
        Node nNode = mNode;
        Node pnNode = nNode.next;
        for (int i = m; i < n; i++) {
            Node temp = pnNode.next;
            pnNode.next = nNode;
            nNode = pnNode;
            pnNode = temp;
        }
        pmNode.next = nNode;
        mNode.next = pnNode;
        return dummy.next;
    }

    public Node getLastN(int n) {
        return getLastN(dummyHead.next, n);
    }

    //得到链表倒数第n个节点
    public Node getLastN(Node head, int n) {
        Node n1 = head.next;
        Node res = head.next;
        for (int i = 0; i < n - 1; i++) {
            if (n1 == null) {
                return null;
            }
            n1 = n1.next;
        }
        while (n1 != null) {
            n1 = n1.next;
            res = res.next;
        }

        return res;
    }

    //判断链表是否有环
    public boolean hasCycle() {
        Node head = dummyHead.next;
        if (head == null || head.next == null) {
            return false;
        }
        Node fast = head.next;
        Node slow = head.next;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }

        }
        return false;
    }

    //合并两个链表
    public ListNode mergeTwoLinkedList(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode dummy = new ListNode();
        ListNode prev = dummy;

        while (node1 != null && node2 != null) {
            if (node1.val > node2.val) {
                prev.next = node2;
                node2 = node2.next;
            } else {
                prev.next = node1;
                node1 = node1.next;
            }
            prev = prev.next;
        }
        prev.next = node1 != null ? node1 : node2;

        return dummy.next;
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        return mergeKLists(lists, 0, lists.length - 1);
    }

    public ListNode mergeKLists(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        int middle = start + (end - start) / 2;
        ListNode l1 = mergeKLists(lists, start, middle);
        ListNode l2 = mergeKLists(lists, middle + 1, end);
        return mergeTwoLinkedList(l1, l2);
    }

    //合并两个链表
    public ListNode mergeTwoLinkedList2(ListNode node1, ListNode node2) {
        if (node1 == null) {
            return node2;
        }
        if (node2 == null) {
            return node1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                prev.next = node1;
                node1 = node1.next;
            } else {
                prev.next = node2;
                node2 = node2.next;
            }
            prev = prev.next;
        }
        prev.next = node1 == null ? node2 : node1;
        return dummy.next;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
//        Node cur = dummyHead.next;
//        while (cur != null) {
//            res.append(cur + "->");
//            cur = cur.next;
//        }
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            res.append(cur + "->");
        }
        res.append("Null");
        return res.toString();
    }

    public class Node {
        public E e;
        public Node next;

        public Node() {
            this(null, null);
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        public ListNode() {

        }

        public ListNode(int x) {
            val = x;
        }
    }
}
