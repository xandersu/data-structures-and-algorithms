package com.xandersu.class207_datastructuresandalgorithms.queue;

/**
 * @Author: suxun
 * @Date: 2018/9/24 22:15
 * @Description: <p>
 * 普通队列：先进先出；后进后出；
 * 优先队列： 出队顺序与入队顺序无关；和优先级有关；
 * 使用场景：操作系统任务调度。动态选择优先级最高的任务执行。
 * -------------入队--出队
 * 普通线性结构  O(1)  O(n)
 * 顺序线性结构  O(n)  O(1)
 * 堆          O(logN)O(logN)
 * </p>
 * 栈，也可以理解成一个队列
 */
public interface MyQueue<E> {

    void enQueue(E e);

    E deQueue();

    E getFront();

    int getSize();

    boolean isEmpty();
}
