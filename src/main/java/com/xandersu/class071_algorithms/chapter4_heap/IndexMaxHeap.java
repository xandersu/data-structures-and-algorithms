package com.xandersu.class071_algorithms.chapter4_heap;

import com.xandersu.util.SortUtil;

/**
 * @author suxun
 * @date 2020/7/5 16:08
 * @description
 */
public class IndexMaxHeap {

    private int[] data;
    private int capacity;
    private int count;
    private int[] indexes;


    public IndexMaxHeap(int capacity) {
        this.data = new int[capacity + 1];
        this.indexes = new int[capacity + 1];
        this.capacity = capacity;
        count = 0;
    }

    public void insert(int i, int t) {
        assert count + 1 <= capacity;
        count++;
        data[count] = t;
        shiftUp(count);
    }

    /**
     * 对这个节点进行和父元素的比较，保持最大堆定义
     */
    private void shiftUp(int i) {
        while (i > 1 && data[i] > data[(i / 2)]) {
            SortUtil.swap(data, i, (i / 2));
            i = i / 2;
        }
    }
}
