package com.xandersu.class207_datastructuresandalgorithms.stack.impl;

import com.xandersu.class207_datastructuresandalgorithms.linked.MyLinkedList;
import com.xandersu.class207_datastructuresandalgorithms.stack.MyStack;

/**
 * @Author: suxun
 * @Date: 2018/9/25 23:13
 * @Description:
 */
public class LinkedListStack<E> implements MyStack<E> {

    private MyLinkedList<E> list;

    public LinkedListStack() {
        list = new MyLinkedList<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString() {
        return "LinkedListStack{ top " +
                list +
                '}';
    }
}
