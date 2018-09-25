package com.xandersu.datastructuresandalgorithms.linked;

/**
 * @Author: suxun
 * @Date: 2018/9/25 21:52
 * @Description:
 */
public class MyLinkedList<E> {

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
            throw new IllegalArgumentException("角标月越界");
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


    private class Node {
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
            return "Node{" +
                    "e=" + e +
                    ", next=" + next +
                    '}';
        }
    }
}
