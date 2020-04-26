package com.xandersu.class207_datastructuresandalgorithms.myTest;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: suxun
 * @Date: 2018/9/17 23:06
 * @Description:
 */
@SpringBootTest
public class Test1 {

    @Test
    public void testMyLinkedList() {
        int SIZE = 32;
        int COUNT_BITS = Integer.SIZE - 3;
        final int RUNNING = -1 << COUNT_BITS;
        final int SHUTDOWN = 0 << COUNT_BITS;
        final int STOP = 1 << COUNT_BITS;
        final int TIDYING = 2 << COUNT_BITS;
        final int TERMINATED = 3 << COUNT_BITS;
        System.out.println();
    }


    public class LinkedList<E> {
        Node root;
        int size;

        public LinkedList() {
            root = new Node(-1, null);
            size = 0;
        }

        @NoArgsConstructor
        @AllArgsConstructor
        public class Node<E> {
            E data;
            Node next;

            @Override
            public String toString() {
                return "data=" + data + " ";
            }
        }

        public void reverseLinkedList1() {
            LinkedList<E> resList = new LinkedList<>();
            int index = size;
            for (int i = 0; i < index; i++) {
                resList.addFirst((E) this.removeFirst().data);
            }
            this.root = resList.root;
        }


        public void reverseLinkedList2() {
            root.next = reverseLinkedList2(root.next, null);
        }


        private Node reverseLinkedList2(Node node, Node prev) {
            if (node.next == null) {
                node.next = prev;
                return node;
            } else {
                Node re = reverseLinkedList2(node.next, node);
                node.next = prev;
                return re;
            }
        }

        public void reverseLinkedList3() {
            Node now = root.next;
            Node prev = null;
            while (now != null) {
                Node next = now.next;
                now.next = prev;
                prev = now;
                now = next;
            }
            root.next = prev;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node node = root;
            while (node.next != null) {
                sb.append(node.next.toString());
                node = node.next;
            }
            return sb.toString();
        }

        public void addFirst(E e) {
            Node next = root.next;
            Node node = new Node(e, next);
            root.next = node;
            size++;
        }

        public Node getFirst() {
            return root.next;
        }

        public Node removeFirst() {
            Node res = root.next;
            root.next = res.next;
            size--;
            return res;
        }
    }


    @Test
    public void test22222() {
        Integer a = null;
        Integer b = 1==1?a:Integer.valueOf(0);
        System.out.println(b);
    }
}
