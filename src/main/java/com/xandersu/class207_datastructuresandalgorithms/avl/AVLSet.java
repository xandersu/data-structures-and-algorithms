package com.xandersu.class207_datastructuresandalgorithms.avl;


import com.xandersu.class207_datastructuresandalgorithms.set.MySet;

/**
 * @Author: suxun
 * @Date: 2018/11/11 22:21
 * @Description:
 */
public class AVLSet<E extends Comparable<E>> implements MySet<E> {
    private AVLTree<E, Object> avl;

    public AVLSet() {
        new AVLTree<>();
    }

    @Override
    public void add(E e) {
        avl.add(e, null);
    }

    @Override
    public void remove(E e) {
        avl.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return avl.contains(e);
    }

    @Override
    public int getSize() {
        return avl.getSize();
    }

    @Override
    public boolean isEmpty() {
        return avl.isEmpty();
    }
}
