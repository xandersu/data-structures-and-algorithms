package com.xandersu.datastructuresandalgorithms.Map.impl;

import com.xandersu.datastructuresandalgorithms.Map.MyMap;

/**
 * @Author: suxun
 * @Date: 2018/10/16 21:18
 * @Description:
 */
public class LinkedListMap<K, V> implements MyMap<K, V> {

    private Node dummyHead;
    private int size;

    public LinkedListMap() {
        dummyHead = new Node();
        size = 0;
    }

    private Node getNode(K key) {
        Node cur = dummyHead.next;
        while (cur != null) {
            if (cur.key.equals(key)) {
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    @Override
    public void add(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            dummyHead.next = new Node(k, v, dummyHead.next);
            size++;
        } else {
            node.value = v;
        }
    }

    @Override
    public V remove(K k) {
        Node prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.key.equals(k)) {
                break;
            }
            prev = prev.next;
        }
        if (prev.next != null) {
            Node delNode = prev.next;
            prev.next = delNode.next;
            delNode.next = null;
            return delNode.value;
        }
        return null;
    }

    @Override
    public boolean contains(K k) {
        return getNode(k) == null;
    }

    @Override
    public V get(K k) {
        Node node = getNode(k);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K k, V v) {
        Node node = getNode(k);
        if (node == null) {
            throw new IllegalArgumentException("not exists");
        }
        node.value = v;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private class Node {
        public K key;
        public V value;
        public Node next;

        public Node() {
            this(null, null, null);
        }

        public Node(K key, V value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public Node(K key) {
            this(key, null, null);
        }

        @Override
        public String toString() {
            return key.toString() + ":" + value.toString();
        }
    }
}
