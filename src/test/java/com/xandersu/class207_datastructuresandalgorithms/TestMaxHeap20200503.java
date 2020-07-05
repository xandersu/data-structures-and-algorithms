package com.xandersu.class207_datastructuresandalgorithms;

import com.xandersu.class207_datastructuresandalgorithms.heap.MaxHeap;
import org.junit.Test;

import java.util.Random;

/**
 * @Author: suxun
 * @Date: 2018/10/21 14:58
 * @Description:
 */
public class TestMaxHeap20200503 {

    @Test
    public void testMyArray() {
        int n = 1000000;
        MaxHeap<Integer> maxHeap = new MaxHeap<>();
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            maxHeap.add(random.nextInt(Integer.MAX_VALUE));
        }
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("success");
    }

    @Test
    public void testMyArray2() {
        int n = 1000000;
        Integer[] intArr = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            intArr[i] = random.nextInt(Integer.MAX_VALUE);
        }
        MaxHeap<Integer> maxHeap = new MaxHeap<>(intArr);
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                throw new IllegalArgumentException();
            }
        }
        System.out.println("success");
    }
}
