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
}
