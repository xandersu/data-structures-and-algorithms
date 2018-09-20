package com.xandersu.datastructuresandalgorithms.stack.impl;

import com.xandersu.datastructuresandalgorithms.array.MyArrayGeneric;
import com.xandersu.datastructuresandalgorithms.stack.Stack;

/**
 * @Author: suxun
 * @Date: 2018/9/20 23:19
 * @Description:
 */
public class ArrayStack<E> implements Stack<E> {

    MyArrayGeneric<E> myArrayGeneric;

    public ArrayStack() {
        myArrayGeneric = new MyArrayGeneric<>();
    }

    public ArrayStack(int capcity) {
        myArrayGeneric = new MyArrayGeneric<>(capcity);
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public void push(E e) {

    }

    @Override
    public E pop() {
        return null;
    }

    @Override
    public E peek() {
        return null;
    }
}
