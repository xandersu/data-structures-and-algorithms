package com.xandersu.class071_algorithms.chapter4_heap;

import com.xandersu.class207_datastructuresandalgorithms.heap.MaxHeap;
import com.xandersu.util.SortUtil;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Collectors;

/**
 * @author suxun
 * @date 2020/7/5 13:54
 * @description 堆排序第一个版本
 */
public class HeapSortTest {

    /**
     * 一个接一个插入堆中
     */
    public static void heapSort1(int[] arr, int n) {
        ArrMaxHeap<Integer> maxHeap = new ArrMaxHeap<Integer>(n);

        for (int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);
        }

        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.pop();
        }
    }

    /**
     * 一次性直接树化
     */
    public static void heapSort2(int[] arr, int n) {
        Integer[] intArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArr[i] = arr[i];
        }
        ArrMaxHeap<Integer> maxHeap = new ArrMaxHeap<>(intArr, n);
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = maxHeap.pop();
        }
    }

    /**
     * 原地堆排序
     */
    public static void heapSort3(int[] arr, int heapSize) {
        //树化
        for (int i = (heapSize - 1) / 2; i >= 0; i--) {
            shiftDown(arr, i, heapSize);
        }
        for (int i = heapSize - 1; i > 0; i--) {
            SortUtil.swap(arr, 0, i);
            shiftDown(arr, 0, i);

        }
    }

    /**
     * shiftDown 数组从0开始
     */
    public static void shiftDown(int[] arr, int thisIndex, int heapSize) {
        while (((2 * thisIndex) + 1) < heapSize) {
            int swapIndex = (2 * thisIndex) + 1;
            int rightIndex = swapIndex + 1;
            if (rightIndex < heapSize && arr[swapIndex] < arr[rightIndex]) {
                swapIndex = rightIndex;
            }
            if (arr[thisIndex] > arr[swapIndex]) {
                break;
            }
            SortUtil.swap(arr, thisIndex, swapIndex);
            thisIndex = swapIndex;
        }
    }

    public static void main(String[] args) {
        int[] ints = SortUtil.generatePrintArr(10, 100);

//        heapSort1(ints, 10);
//        System.out.println(SortUtil.isFromSmallToLarge(ints));
//        System.out.println(Arrays.toString(ints));

//        heapSort2(ints, 10);
//        System.out.println(Arrays.toString(ints));

        heapSort3(ints, 10);
        System.out.println(Arrays.toString(ints));

    }
}
