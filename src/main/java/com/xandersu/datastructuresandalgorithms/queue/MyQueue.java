package com.xandersu.datastructuresandalgorithms.queue;

/**
 * @Author: suxun
 * @Date: 2018/9/24 22:15
 * @Description:
 */
public interface MyQueue<E> {

    void enQueue(E e);

    E deQueue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
