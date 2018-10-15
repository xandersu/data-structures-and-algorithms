package com.xandersu.datastructuresandalgorithms.set.impl;

import com.xandersu.datastructuresandalgorithms.linked.MyLinkedList;
import com.xandersu.datastructuresandalgorithms.set.MySet;
import com.xandersu.datastructuresandalgorithms.stack.MyStack;

/**
 * @Author: suxun
 * @Date: 2018/10/15 22:22
 * @Description:
 */
public class LinkedListSet<E> implements MySet<E> {
    private MyLinkedList<E> linkedList = new MyLinkedList<>();

    @Override
    public void add(E e) {
        if(!linkedList.contains(e)){
            linkedList.addFirst(e);
        }
    }

    @Override
    public void remove(E e) {
//        linkedList.remo
    }

    @Override
    public boolean contains(E e) {
        return linkedList.contains(e);
    }

    @Override
    public int getSize() {
        return linkedList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return linkedList.isEmpty();
    }


}
