package com.xandersu.datastructuresandalgorithms.tree;

/**
 * @Author: suxun
 * @Date: 2018/10/22 22:07
 * @Description:
 */
public interface Merger<E> {
    /**
     * 两个元素融合为一个元素
     * @param a
     * @param b
     * @return
     */
    E merge(E a, E b);
}
