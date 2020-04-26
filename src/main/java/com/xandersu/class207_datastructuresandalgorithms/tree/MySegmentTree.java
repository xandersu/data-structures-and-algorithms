package com.xandersu.class207_datastructuresandalgorithms.tree;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: suxun
 * @Date: 2018/10/21 17:12
 * @Description: 线段树--关注动态的情况,对于二叉树，元素是一个个线段，或者说一个个区间
 * 为什么使用线段树：经典问题：区间染色（m次操作后，可以在【i，j】区间可以看见多少种颜色）
 * 区间查询：【i，j】区间 最大值，最小值，或者区间数字和,基于区间统计查询
 * ------
 * 区间是固定的
 * --------------A[0-7]
 * --------A[0-3]-----------A[4-7]
 * ----A[0-1]  A[2-3]  A[4-5] A[6-7]
 * ---A[0]-A[1]-A[2]-A[3]-A[4]-A[5]-A[6]-A[7]
 * ==========
 * 平衡二叉树： 最大的深度和最小的深度差不超过一
 * 完全二叉树一定是平衡二叉树
 * 线段树不是完全二叉树
 * 线段树是平衡二叉树，堆也是平衡二叉树
 * 平衡二叉树 搜索高效
 * 如果区间有n个元素，数组表示最多需要多少个节点？ 4n!!! 空间换时间!!!
 * 对满二叉树：h层 一共2^h-1个节点（大约是2^h），最后一层(h-1)层,有2^(h-1)个节点 最后一层的节点数大致等于前面所有节点之和
 * ===========
 * 父亲节点是左右两个子树根结点的和,叶子节点的和是他自己
 */
public class MySegmentTree<E> {
    private E[] data;
    private E[] tree;
    private Merger<E> merger;

    public MySegmentTree(E[] arr, Merger<E> merger) {
        data = (E[]) new Object[arr.length];
        this.merger = merger;
        for (int i = 0; i < arr.length; i++) {
            data[i] = arr[i];
        }
        tree = (E[]) new Object[4 * arr.length];
        buildSegmentTree(0, 0, data.length - 1);
    }

    /**
     * 在treeIndex的位置创建表示区间 l到r的线段树
     * @param treeIndex
     * @param l         区间左端电
     * @param r         区间右端点
     */
    private void buildSegmentTree(int treeIndex, int l, int r) {
        if (l == r) {
            tree[treeIndex] = data[l];
            return;
        }

        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);
        int mid = l + (r - l) / 2;

        buildSegmentTree(leftTreeIndex, l, mid);
        buildSegmentTree(rightTreeIndex, mid + 1, r);

        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);

    }

    public E get(int index) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("wrong index");
        }
        return data[index];
    }

    public int getSize() {
        return data.length;
    }

    private int leftChild(int index) {
        return 2 * index + 1;
    }

    private int rightChild(int index) {
        return 2 * index + 2;
    }

    public E query(int queryL, int queryR) {
        if (queryL < 0 || queryL >= data.length || queryR < 0 || queryR >= data.length
                || queryL > queryR) {
            throw new IllegalArgumentException("wrong index");
        }

        return query(0, 0, data.length - 1, queryL, queryR);
    }

    private E query(int treeIndex, int l, int r, int queryL, int queryR) {
        if (l == queryL && r == queryR) {
            return tree[treeIndex];
        }
        int mid = l + (r - l) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (queryL >= mid + 1) {
            return query(rightTreeIndex, mid + 1, r, queryL, queryR);
        } else if (queryR <= mid) {
            return query(leftTreeIndex, l, mid, queryL, queryR);
        } else {
            E leftResult = query(leftTreeIndex, l, mid, queryL, mid);
            E rightResult = query(rightTreeIndex, mid + 1, r, mid + 1, queryR);
            return merger.merge(leftResult, rightResult);
        }
    }

    public void set(int index, E e) {
        if (index < 0 || index >= data.length) {
            throw new IllegalArgumentException("wrong index");
        }

        data[index] = e;
        set(0, 0, data.length - 1, index, e);
    }

    private void set(int treeIndex, int l, int r, int index, E e) {
        if (l == r) {
            tree[treeIndex] = e;
            return;
        }

        int mid = l + (r - 1) / 2;
        int leftTreeIndex = leftChild(treeIndex);
        int rightTreeIndex = rightChild(treeIndex);

        if (index >= mid + 1) {
            set(rightTreeIndex, mid + 1, r, index, e);
        } else {
            set(leftTreeIndex, l, mid, index, e);
        }
        tree[treeIndex] = merger.merge(tree[leftTreeIndex], tree[rightTreeIndex]);
    }

    @Override
    public String toString() {
        List<E> res = Arrays.asList(tree);
        return res.toString();
    }
}
