package com.xandersu.algorithms.sort.insert_sort;


import com.xandersu.algorithms.sort.SortUtil;
import com.xandersu.algorithms.sort.select_sort.MySelectSort;

import java.util.Arrays;

/**
 * @author su
 * @date 2019/11/1123:15
 * @description 插入排序，依次与之前的元素比较，满足条件换位置
 */
public class MyInsertSort {

    public static void main(String[] args) {
        int[] arr = SortUtil.generatePrintArr(100, 1000);
        int[] arr2 = arr.clone();
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
        MySelectSort.selectSort(arr2);
        System.out.println(Arrays.toString(arr2));

    }

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j - 1] >= arr[j]; j--) {
                SortUtil.swap(arr, j - 1, j);
            }
        }

    }

}
