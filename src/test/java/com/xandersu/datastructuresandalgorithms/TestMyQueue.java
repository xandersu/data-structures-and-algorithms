package com.xandersu.datastructuresandalgorithms;

import com.xandersu.datastructuresandalgorithms.queue.MyQueue;
import com.xandersu.datastructuresandalgorithms.queue.impl.ArrayQueue;
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
}
