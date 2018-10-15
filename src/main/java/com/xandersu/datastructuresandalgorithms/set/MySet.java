package com.xandersu.datastructuresandalgorithms.set;

/**
 * @Author: suxun
 * @Date: 2018/10/15 21:34
 * @Description:不能添加重复元素
 */
public interface MySet<E> {

    //不能添加重复元素
    void add(E e);
    void remove(E e);
    boolean contains(E e);
    int getSize();
    boolean isEmpty();
}
