package com.xandersu.class207_datastructuresandalgorithms;

import com.xandersu.class207_datastructuresandalgorithms.linked.MyLinkedList;
import lombok.ToString;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: suxun
 * @Date: 2018/9/17 23:06
 * @Description:
 */
@SpringBootTest
public class TestMyLinkedList {

    @Test
    public void testMyLinkedList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }
//        System.out.println(linkedList);
        for (int i = 10; i < 15; i++) {
            linkedList.addLast(i);
        }
        System.out.println(linkedList);
//        linkedList.myWhileReverseLinked();
//        System.out.println(linkedList);
//        linkedList.add(666, 2);
//        System.out.println(linkedList);
//        linkedList.removeFirst();
//        System.out.println(linkedList);
//        linkedList.removeLast();
//        System.out.println(linkedList);
//        linkedList.reverseN2M(0, 5);
//        System.out.println(linkedList);

        System.out.println(linkedList.hasCycle());

    }

    @Test
    public void reverseMyLinkedList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
        }

        System.out.println(linkedList);
        linkedList.reverseLinkedList(linkedList);

        System.out.println(linkedList);
    }


    @Test
    public void reverseLinkedList() {
        Node linkNode1 = new Node();
        linkNode1.data = 1;
        Node linkNode2 = new Node();
        linkNode2.data = 2;
        Node linkNode3 = new Node();
        linkNode3.data = 3;
        Node linkNode4 = new Node();
        linkNode4.data = 4;
        Node linkNode5 = new Node();
        linkNode5.data = 5;
        Node linkNode6 = new Node();
        linkNode6.data = 6;
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;
        reverseLinkedList(linkNode1);

    }

    private void reverseLinkedList(Node node) {
        Node pre = null;
        Node cur = node;
        Node headNode = null;
        while (cur != null) {
            Node next = node.next;
            if (next == null) {
                headNode = cur;
            }

            cur.next = pre;
            pre = cur;
            cur = next;
        }
    }

    @ToString
    public class Node {
        Node next;
        Integer data;
    }
}
