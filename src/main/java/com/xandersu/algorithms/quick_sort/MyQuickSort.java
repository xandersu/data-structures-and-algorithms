package com.xandersu.algorithms.quick_sort;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/11/9.
 */
public class MyQuickSort {

    public void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public void quickSort(int[] arr, int l, int r) {
        if (arr == null || l > r) {
            return;
        }
        int p = partition(arr, l, r);
        quickSort(arr, l, p - 1);
        quickSort(arr, p + 1, r);
    }

    public int partition(int[] arr, int l, int r) {
        if (l >= r) {
            return l;
        }
        int p = l;
        int temp = arr[l];
        for (int i = l + 1; i <= r; i++) {
            if (temp > arr[i]) {
                swap(arr, i, ++p);
            }
        }
        swap(arr, l, p);
        return p;
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 45, 6, 11, 890, 123, 456, 734, 231, 112, 9, 78, 100};
        MyQuickSort myQuickSort = new MyQuickSort();
        myQuickSort.quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
