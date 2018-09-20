package com.xandersu.datastructuresandalgorithms.stack;

/**
 * @Author: suxun
 * @Date: 2018/9/20 23:18
 * @Description:
 */
public interface Stack<E> {

    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();

}
