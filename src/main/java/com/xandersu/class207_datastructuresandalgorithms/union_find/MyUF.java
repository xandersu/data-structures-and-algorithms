package com.xandersu.class207_datastructuresandalgorithms.union_find;

/**
 * @Author: suxun
 * @Date: 2018/11/4 17:21
 * @Description: 并查集(孩子指向父亲)
 * 连接问题：
 * 网络中节点的连接状态：网络是个抽象概念：用户之间形成的网络。
 * 对于一组数据，主要支持两个动作：1、union(p,q) 2、isConnected(p,q)
 * ===================================
 * 0 1 2 3 4 5 6 7 8 9
 * -------------------
 * 0 0 0 0 0 1 1 1 1 1
 * ===================================
 * 0 1 2 3 4 5 6 7 8 9
 * -------------------
 * 0 1 0 1 0 1 0 1 0 1
 * ===================================
 * quick find O(1)
 * ===================================
 * 子节点指向父节点
 * 将每一个元素，看做一个节点
 * ===================================
 * 假如路径压缩时间复杂度:严格意义上:O(log*n)  {log*n={0-(n小于等于1)},{1+log*(logn)-(n大于1)}}
 */
public interface MyUF {
    //并,将两个元素合并在一起
    void unionElements(int p, int q);

    //是否链接
    boolean isConnected(int p, int q);

    //
    int getSize();
}
