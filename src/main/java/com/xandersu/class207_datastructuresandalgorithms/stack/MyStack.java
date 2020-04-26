package com.xandersu.class207_datastructuresandalgorithms.stack;

/**
 * @Author: suxun
 * @Date: 2018/9/20 23:18
 * @Description:
 */
public interface MyStack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();

}
