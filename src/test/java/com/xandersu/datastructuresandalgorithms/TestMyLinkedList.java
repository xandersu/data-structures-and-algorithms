package com.xandersu.datastructuresandalgorithms;

import com.xandersu.datastructuresandalgorithms.linked.MyLinkedList;
import com.xandersu.datastructuresandalgorithms.stack.MyStack;
import com.xandersu.datastructuresandalgorithms.stack.impl.ArrayStack;
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
        System.out.println(linkedList);
        for (int i = 10; i < 15; i++) {
            linkedList.addLast(i);
        }
        System.out.println(linkedList);
        linkedList.add(666, 2);
        System.out.println(linkedList);
        linkedList.removeFirst();
        System.out.println(linkedList);
        linkedList.removeLast();
        System.out.println(linkedList);
    }
}
