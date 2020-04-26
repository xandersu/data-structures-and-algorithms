package com.xandersu.class207_datastructuresandalgorithms.queue.impl;

import com.xandersu.class207_datastructuresandalgorithms.heap.MaxHeap;
import com.xandersu.class207_datastructuresandalgorithms.queue.MyQueue;

/**
 * @Author: suxun
 * @Date: 2018/10/21 15:30
 * @Description:
 */
public class PriorityQueue<E extends Comparable<E>> implements MyQueue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public void enQueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E deQueue() {
        return maxHeap.extractMax();
    }

    @Override
    public E getFront() {
        return maxHeap.findMax();
    }

    @Override
    public int getSize() {
        return maxHeap.getSize();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }
}
