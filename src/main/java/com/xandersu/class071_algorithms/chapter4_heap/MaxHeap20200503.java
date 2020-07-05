package com.xandersu.class071_algorithms.chapter4_heap;

import java.util.Arrays;

/**
 * @author: suxun
 * @date: 2020/5/3 11:48
 * @description: 数组做的最大堆 , 堆中某个节点的值总是不大于其父节点的值。
 * root节点 index=1
 * 二叉堆是一颗完全二叉树。（最大堆：越往上越大，但不一定）
 */
public class MaxHeap20200503<T extends Comparable> {

    private T[] data;
    private int count;
    private int capacity;

    public MaxHeap20200503(int capacity) {
        data = (T[]) new Comparable[capacity + 1];
        count = 0;
        this.capacity = capacity;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }


    // 像最大堆中插入一个新的元素 item
    public void insert(T t) {
        assert count + 1 <= capacity;
        count++;
        data[count] = t;
        shiftUp(count);
    }

    private void shiftUp(int k) {
        int parentIndex = count / 2;
        while (parentIndex > 0 && data[parentIndex].compareTo(data[k]) < 0) {
            swap(data, parentIndex, k);
            k = parentIndex;
            parentIndex = parentIndex / 2;
        }
    }


    public T removeMax() {
        if (count < 1) {
            return null;
        }
        T ret = data[1];
        data[1] = null;
        swap(data, 1, count);
        count--;
        shiftDown(1);

        return ret;
    }

    private void shiftDown(int k) {
        T leftChild = data[2 * k];
        T rightChild = data[2 * k + 1];
        while (k <= count && ((leftChild != null && data[k].compareTo(leftChild) < 0
                || (rightChild != null && data[k].compareTo(rightChild) < 0)))) {
            if (leftChild == null) {
                swap(data, k, 2 * k + 1);
            } else if (rightChild == null) {
                swap(data, k, 2 * k);
            } else if (leftChild.compareTo(rightChild) > 0) {
                swap(data, k, 2 * k);
            } else {
                swap(data, k, 2 * k + 1);
            }
            k *= 2;
        }

    }


    private void shiftUp_T(int k) {
        while (k > 1 && data[k / 2].compareTo(data[k]) < 0) {
            swap(data, k / 2, k);
            k /= 2;
        }
    }


    public static <T> void swap(T[] arr, int i, int j) {
        T t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        MaxHeap20200503<Integer> maxHeap20200503 = new MaxHeap20200503<>(100);
//        System.out.println(maxHeap.count);
//        System.out.println(maxHeap.isEmpty());

        for (int i = 0; i < 10; i++) {
            maxHeap20200503.insert((int) (Math.random() * 100));
        }

        System.out.println(maxHeap20200503.removeMax());
        System.out.println(Arrays.toString(maxHeap20200503.data));
        for (int i = 0; i < 9; i++) {
            System.out.println(maxHeap20200503.removeMax());
        }
        System.out.println(Arrays.toString(maxHeap20200503.data));
    }
}
