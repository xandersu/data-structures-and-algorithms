package com.xandersu.datastructuresandalgorithms;

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
        MyStack<Integer> integerArray = new ArrayStack<>();
        for (int i = 0; i < 11; i++) {
            integerArray.push(i);
        }
        System.out.println(integerArray);
        integerArray.pop();
        System.out.println(integerArray);
        integerArray.peek();
        System.out.println(integerArray);
        System.out.println(integerArray.pop());
        System.out.println(integerArray.pop());
    }
}
