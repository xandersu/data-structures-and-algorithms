package com.xandersu.class207_datastructuresandalgorithms.queue.impl;

import com.xandersu.class207_datastructuresandalgorithms.queue.MyQueue;

import java.util.Arrays;

/**
 * @Author: suxun
 * @Date: 2018/9/24 22:33
 * @Description:
 */
public class LoopQueue<E> implements MyQueue<E> {

    private E[] data;
    private int front, tail;
    private int size;


    public LoopQueue() {
        this(10);
    }

    public LoopQueue(int capacity) {
        this.data = (E[]) new Object[capacity + 1];
        tail = 0;
        front = 0;
        size = 0;
    }

    @Override
    public void enQueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % data.length;
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity + 1];
        for (int i = 0; i < size; i++) {
            newData[i] = data[(i + front) % data.length];
        }
        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public E deQueue() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        if (size == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return ret;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            throw new IllegalArgumentException("队列为空");
        }
        return data[front];
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return front == size;
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public String toString() {
        return "LoopQueue{" +
                "front=" + front +
                ", tail=" + tail +
                ", size=" + size +
                ", data=" + Arrays.toString(data) +
                '}';
    }
}
