package com.xandersu.refertooffer;

import java.util.Stack;

/**
 * @author su
 * @date 2020/5/1812:53
 * @description 面试题09. 用两个栈实现队列
 */
public class P09TwoStackAQueue {
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if (!s2.isEmpty()) {
            return s2.pop();
        }
        while (!s1.isEmpty()) {
            s2.push(s1.pop());
        }
        return s2.isEmpty() ? -1 : s2.pop();
    }


    public static void main(String[] args) {

    }
}
