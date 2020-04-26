package com.xandersu.class207_datastructuresandalgorithms;

import com.xandersu.class207_datastructuresandalgorithms.queue.MyQueue;
import com.xandersu.class207_datastructuresandalgorithms.queue.impl.ArrayQueue;
import com.xandersu.class207_datastructuresandalgorithms.queue.impl.LinkedListQueue;
import com.xandersu.class207_datastructuresandalgorithms.queue.impl.LoopQueue;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: suxun
 * @Date: 2018/9/17 23:06
 * @Description:
 */
@SpringBootTest
public class TestMyQueue {

    @Test
    public void testMyQueue() {
        MyQueue<Integer> integerMyQueue = new ArrayQueue<>();
        for (int i = 0; i < 11; i++) {
            integerMyQueue.enQueue(i);
        }
        System.out.println(integerMyQueue);
        integerMyQueue.deQueue();
        System.out.println(integerMyQueue);
        System.out.println(integerMyQueue.deQueue());
        System.out.println(integerMyQueue);
    }

    @Test
    public void testLoopQueue() {
        MyQueue<Integer> integerMyQueue = new LoopQueue<>();
        for (int i = 0; i < 20; i++) {
            integerMyQueue.enQueue(i);
        }
        System.out.println(integerMyQueue);
        System.out.println(integerMyQueue.deQueue());
        System.out.println(integerMyQueue);
        System.out.println(integerMyQueue.deQueue());
        System.out.println(integerMyQueue);
    }

    @Test
    public void testLinkedListQueue() {
        MyQueue<Integer> integerMyQueue = new LinkedListQueue<>();
        for (int i = 0; i < 20; i++) {
            integerMyQueue.enQueue(i);
        }
        System.out.println(integerMyQueue);
        System.out.println(integerMyQueue.deQueue());
        System.out.println(integerMyQueue);
        System.out.println(integerMyQueue.deQueue());
        System.out.println(integerMyQueue);
    }
}
