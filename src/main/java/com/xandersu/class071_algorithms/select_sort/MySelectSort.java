package com.xandersu.class071_algorithms.select_sort;

import com.xandersu.class071_algorithms.SortUtil;

import java.util.Arrays;

/**
 * @author su
 * @date 2019/11/11 22:58
 * @description 选择排序：找到这个位置之后最小的数与这个数换
 */
public class MySelectSort {

    public static void main(String[] args) {
        int[] arr = {1, 100, 4, 67, 83, 19, 1, 0, 66, 4};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int smallIndex = findSmallIndex(arr, i);
            SortUtil.swap(arr, i, smallIndex);
        }
    }

    public static int findSmallIndex(int[] arr, int start) {
        int temp = arr[start];
        int p = start;
        for (int i = start + 1; i < arr.length; i++) {
            if (temp >= arr[i]) {
                temp = arr[i];
                p = i;
            }
        }
        return p;
    }
}
