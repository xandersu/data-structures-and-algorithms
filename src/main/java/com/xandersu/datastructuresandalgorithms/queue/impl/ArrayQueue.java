package com.xandersu.datastructuresandalgorithms.queue.impl;

import com.xandersu.datastructuresandalgorithms.array.MyArray;
import com.xandersu.datastructuresandalgorithms.array.MyArrayGeneric;
import com.xandersu.datastructuresandalgorithms.queue.MyQueue;

/**
 * @Author: suxun
 * @Date: 2018/9/24 22:16
 * @Description:
 */
public class ArrayQueue<E> implements MyQueue<E> {

    private MyArrayGeneric<E> myArray;

    public ArrayQueue() {
        this.myArray = new MyArrayGeneric(10);

    }

    public ArrayQueue(int capacity) {
        this.myArray = new MyArrayGeneric(capacity);
    }

    @Override
    public void enQueue(E e) {
        myArray.addLast(e);
    }

    @Override
    public E deQueue() {
        return myArray.remove(0);
    }

    @Override
    public E getFront() {
        return myArray.getFirst();
    }

    @Override
    public int getSize() {
        return myArray.getSize();
    }

    @Override
    public boolean isEmpty() {
        return myArray.isEmpty();
    }

    public int getCapacity() {
        return myArray.getCapacity();
    }

    @Override
    public String toString() {
        return "{" + myArray + '}';
    }
}
