package com.xandersu.class207_datastructuresandalgorithms.set.impl;

import com.xandersu.class207_datastructuresandalgorithms.set.MySet;
import com.xandersu.class207_datastructuresandalgorithms.tree.BST;

/**
 * @Author: suxun
 * @Date: 2018/10/15 21:38
 * @Description:
 */
public class BSTSet<E extends Comparable<E>> implements MySet<E> {

    private BST<E> bst;

    public BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add2(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.isEmpty();
    }
}
