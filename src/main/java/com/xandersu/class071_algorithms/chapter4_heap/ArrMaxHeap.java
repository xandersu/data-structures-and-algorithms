package com.xandersu.class071_algorithms.chapter4_heap;

import com.xandersu.util.SortUtil;

import java.util.Arrays;

/**
 * @author suxun
 * @date 2020/7/5 12:05
 * @description 数组做的最大堆
 * i的parent=i/2;
 * i的left child = i*2;
 * i的right child = i*2 + 1;
 */
public class ArrMaxHeap<T extends Comparable> {

    private T[] data;
    private int capacity;
    private int count;

    public ArrMaxHeap(int capacity) {
        data = (T[]) (new Comparable[capacity + 1]);
        this.capacity = capacity;
        count = 0;
    }

    public ArrMaxHeap(T[] arr, int n) {
        heapify(arr, n);
    }

    //树化一个数组
    private void heapify(T[] arr, int n) {
        data = (T[]) (new Comparable[n + 1]);
        capacity = n;
        for (int i = 0; i < n; i++) {
            data[i + 1] = arr[i];
        }
        count = n;

        for (int i = count / 2; i > 0; i--) {
            shiftDown(i);
        }
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    /**
     * 插入一个元素
     * 先在末尾插入一个元素
     * 然后看子节点和父节点的大小
     * 进行swap，维持最大堆的定义
     */
    public void insert(T t) {
        assert count + 1 <= capacity;
        count++;
        data[count] = t;
        shiftUp(count);
    }

    /**
     * 对这个节点进行和父元素的比较，保持最大堆定义
     */
    private void shiftUp(int i) {
        while (i > 1 && data[i].compareTo(data[getParentIndex(i)]) > 0) {
            swap(i, getParentIndex(i));
            i = getParentIndex(i);
        }
    }

    public T pop() {
        assert count - 1 >= 0;

        T max = data[1];
        swap(1, count);
        data[count] = null;
        count--;
        shiftDown(1);
        return max;
    }

    private void shiftDown(int thisIndex) {
        //有左孩子，说明有元素
        while (getLeftChildIndex(thisIndex) <= count) {
            int swapChildIndex = getLeftChildIndex(thisIndex);
            int rightChildIndex = swapChildIndex + 1;
            //看左右两个孩子谁大，这时候左孩子肯定存在不为null，就看右孩子是否存在，并且看左右两个孩子谁大，谁大父元素就可能跟他换
            if (rightChildIndex <= count && data[swapChildIndex].compareTo(data[rightChildIndex]) < 0) {
                swapChildIndex = rightChildIndex;
            }
            //如果父元素比子元素大就不用换了
            if (data[thisIndex].compareTo(data[swapChildIndex]) > 0) {
                break;
            }
            //换
            swap(thisIndex, swapChildIndex);
            thisIndex = swapChildIndex;
        }
    }


    public int getParentIndex(int i) {
        return i / 2;
    }

    public int getLeftChildIndex(int i) {
        return i * 2;
    }

    public int getRightChildIndex(int i) {
        return (i * 2) + 1;
    }

    public void swap(int i, int j) {
        T temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }


    public static void main(String[] args) {
        ArrMaxHeap<Integer> maxHeap = new ArrMaxHeap<Integer>(100);
//        System.out.println(maxHeap.count);

        maxHeap.insert(1);
        System.out.println(Arrays.toString(maxHeap.data));
        maxHeap.insert(2);
        System.out.println(Arrays.toString(maxHeap.data));
        maxHeap.insert(3);
        System.out.println(Arrays.toString(maxHeap.data));
        maxHeap.insert(4);
        System.out.println(Arrays.toString(maxHeap.data));
        maxHeap.insert(5);
        System.out.println(Arrays.toString(maxHeap.data));
        maxHeap.insert(6);
        System.out.println(Arrays.toString(maxHeap.data));
        maxHeap.insert(7);
        System.out.println(Arrays.toString(maxHeap.data));

        System.out.println(maxHeap.pop());
        System.out.println(Arrays.toString(maxHeap.data));

    }
}
