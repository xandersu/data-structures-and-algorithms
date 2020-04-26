package com.xandersu.class207_datastructuresandalgorithms;

import com.xandersu.class207_datastructuresandalgorithms.stack.MyStack;
import com.xandersu.class207_datastructuresandalgorithms.stack.impl.ArrayStack;
import com.xandersu.class207_datastructuresandalgorithms.stack.impl.LinkedListStack;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: suxun
 * @Date: 2018/9/17 23:06
 * @Description:
 */
@SpringBootTest
public class TestMyStack {

    @Test
    public void testMyStack() {
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
        System.out.println(integerArray);
    }

    @Test
    public void testMyLinkedListStack() {
        MyStack<Integer> integerArray = new LinkedListStack<>();
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

        System.out.println(integerArray);
    }
}
