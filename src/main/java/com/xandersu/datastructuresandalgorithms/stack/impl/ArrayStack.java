package com.xandersu.datastructuresandalgorithms.stack.impl;

import com.xandersu.datastructuresandalgorithms.array.MyArrayGeneric;
import com.xandersu.datastructuresandalgorithms.stack.MyStack;

/**
 * @Author: suxun
 * @Date: 2018/9/20 23:19
 * @Description:
 */
public class ArrayStack<E> implements MyStack<E> {

    MyArrayGeneric<E> myArrayGeneric;

    public ArrayStack() {
        myArrayGeneric = new MyArrayGeneric<>();
    }

    public ArrayStack(int capacity) {
        myArrayGeneric = new MyArrayGeneric<>(capacity);
    }

    @Override
    public int getSize() {
        return myArrayGeneric.getSize();
    }

    @Override
    public boolean isEmpty() {
        return myArrayGeneric.isEmpty();
    }

    @Override
    public void push(E e) {
        myArrayGeneric.addLast(e);
    }

    @Override
    public E pop() {
        return myArrayGeneric.removeLast();
    }

    @Override
    public E peek() {
        return myArrayGeneric.getLast();
    }

    public int getCapacity() {
        return myArrayGeneric.getCapacity();
    }

    @Override
    public String toString() {
        return "ArrayStack{" +
                 myArrayGeneric +
                "} TOP";
    }
}
