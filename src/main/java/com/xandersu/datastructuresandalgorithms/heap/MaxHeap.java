package com.xandersu.datastructuresandalgorithms.heap;

import com.xandersu.datastructuresandalgorithms.array.MyArrayGeneric;

/**
 * @Author: suxun
 * @Date: 2018/10/21 13:04
 * @Description:
 */
public class MaxHeap<E extends Comparable<E>> {

    private MyArrayGeneric<E> data;

    public MaxHeap() {
        data = new MyArrayGeneric<>();
    }

    public MaxHeap(int capacity) {
        data = new MyArrayGeneric<>(capacity);
    }

    public MaxHeap(E[] arr) {
        data = new MyArrayGeneric<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            shiftDown(i);
        }
    }

    public int getSize() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    //返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesnt hava parent.");
        }
        return (index - 1) / 2;
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    //返回完全二叉树的数组表示中，一个索引所表示元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    //向堆添加元素 (shift up)
    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize() - 1);
    }

    private void shiftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    //取最大值 shift down
    public E extractMax() {
        E ret = findMax();
        data.swap(0, data.getSize() - 1);
        data.removeLast();
        shiftDown(0);
        return ret;
    }

    private void shiftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if ((j + 1) < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
                //data[j]是leftchild 和 rightchild最大值
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("data.size = 0! ");
        }
        return data.get(0);
    }

    //取出最大，放入新元素
    public E replace(E e) {
        E ret = findMax();
        data.set(0, e);
        shiftDown(0);
        return ret;
    }
    //将任意数组整理成堆的形状

}
