package com.xandersu.my_test.practice;


import com.xandersu.class71_algorithms.SortUtil;

import java.util.Arrays;

/**
 * @author: suxun
 * @date: 2020/5/2 21:17
 * @description: 练习
 */
public class Practice200502 {

    //冒泡排序
    public static void bubble(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    //选择排序
    public static void select(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            swap(arr, i, minIndex);
        }
    }

    //插入
//    public static void insert(int[] arr) {
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = i + 1; j > 0 && j < arr.length; j--) {
//                if (arr[j] < arr[j - 1]) {
//                    swap(arr, j, j - 1);
//                } else {
//                    break;
//                }
//            }
//        }
//
//    }

    public static void insert2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int j = i;
            for (; j > 0 && num < arr[j - 1]; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = num;
        }
    }

    public static void merge(int[] arr) {
        merge(arr, 0, arr.length - 1);
    }

    public static void merge(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = (l + r) / 2;

        merge(arr, l, mid);
        merge(arr, mid + 1, r);

        merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        int lIndex = l;
        int rIndex = mid + 1;
        int k = l;
        while (lIndex <= mid && rIndex <= r) {
            if (aux[lIndex - l] < aux[rIndex - l]) {
                arr[k] = aux[lIndex - l];
                lIndex++;
            } else {
                arr[k] = aux[rIndex - l];
                rIndex++;
            }
            k++;
        }

        if (lIndex <= mid) {
            for (; lIndex <= mid; lIndex++, k++) {
                arr[k] = aux[lIndex - l];
            }
        } else {
            for (; rIndex <= r; rIndex++, k++) {
                arr[k] = aux[rIndex - l];
            }
        }

    }


    public static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


    private static void quick_1(int[] arr) {
        quick_1(arr, 0, arr.length - 1);
    }

    private static void quick_1(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition_1(arr, l, r);
        quick_1(arr, l, p - 1);
        quick_1(arr, p + 1, r);
    }

    private static int partition_1(int[] arr, int l, int r) {
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, j, i);
            }
        }
        swap(arr, l, j);
        return j;
    }

    private static void quick_2(int[] arr) {
        quick_2(arr, 0, arr.length - 1);
    }

    private static void quick_2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition_2(arr, l, r);
        quick_1(arr, l, p - 1);
        quick_1(arr, p + 1, r);
    }

    private static int partition_2(int[] arr, int l, int r) {
        int v = arr[l];

        int lt = l + 1;
        int gt = r;
        while (true) {
            while (arr[lt] < v) {
                lt++;
            }
            while (arr[gt] > v) {
                gt--;
            }
            if (lt > gt) {
                break;
            }

            swap(arr, lt, gt);
            lt++;
            gt--;
        }
        swap(arr, l, gt);
        return gt;
    }


    private static void quick_3(int[] arr) {
        quick_3(arr, 0, arr.length - 1);
    }

    private static void quick_3(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int v = arr[l];

        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            if (arr[i] > v) {
                gt--;
                swap(arr, i, gt);
            } else if (arr[i] < v) {
                lt++;
                swap(arr, lt, i);
                i++;
            } else {
                i++;
            }
        }
        swap(arr, l, lt);
        quick_3(arr, l, lt - 1);
        quick_3(arr, gt, r);
    }


    public static void main(String[] args) {
//        SortUtil.verify(Practice200502::bubble);
//        SortUtil.verify(Practice200502::select,10000,10000);
//        SortUtil.verify(Practice200502::insert2, 10000, 10000);
//        SortUtil.verify(Practice200502::merge, 1000000, 10000, false);
//        SortUtil.verify(Practice200502::quick_1, 10, 10000);
//        SortUtil.verify(Practice200502::quick_2, 100000, 10000);
//        SortUtil.verify(Practice200502::quick_3, 100000, 10000);
    }
}
