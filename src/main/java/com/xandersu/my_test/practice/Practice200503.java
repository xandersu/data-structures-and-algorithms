package com.xandersu.my_test.practice;

import com.xandersu.util.SortUtil;

import java.util.Arrays;

/**
 * @author: suxun
 * @date: 2020/5/3 10:22
 * @description:
 */
public class Practice200503 {

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void select(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int index = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] < arr[index]) {
                    index = j;
                }
            }
            swap(arr, index, i);
        }
    }

    public static void insert(int[] arr) {
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

    public static void merge(int[] arr, int l, int mid, int r) {
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
        }

        if (rIndex <= r) {
            for (; rIndex <= r; rIndex++, k++) {
                arr[k] = aux[rIndex - l];
            }
        }
    }

    public static void quick_1(int[] arr) {
        quick_1(arr, 0, arr.length - 1);
    }

    public static void quick_1(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition_1(arr, l, r);
        quick_1(arr, l, p - 1);
        quick_1(arr, p + 1, r);
    }

    public static int partition_1(int[] arr, int l, int r) {
        int v = arr[l];
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                swap(arr, i, j);
            }
        }
        swap(arr, l, j);

        return j;
    }

    public static void quick_2(int[] arr) {
        quick_2(arr, 0, arr.length - 1);
    }

    public static void quick_2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition_2(arr, l, r);
        quick_2(arr, l, p - 1);
        quick_2(arr, p + 1, r);
    }

    public static int partition_2(int[] arr, int l, int r) {
        int v = arr[l];
        int lt = l + 1;
        int gt = r;

        while (true) {
            while (arr[lt] < v && lt <= r) {
                lt++;
            }
            while (arr[gt] > v && gt >= l + 1) {
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

    public static void quick_3(int[] arr) {
        quick_3(arr, 0, arr.length - 1);
    }

    public static void quick_3(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int v = arr[l];

        int lt = l;
        int gt = r + 1;
        int i = l + 1;

        while (i < gt) {
            if (arr[i] < v) {
                lt++;
                swap(arr, i, lt);
                i++;
            } else if (arr[i] > v) {
                gt--;
                swap(arr, i, gt);
            } else {
                i++;
            }
        }
        swap(arr, l, lt);

        quick_3(arr, l, lt - 1);
        quick_3(arr, gt, r);

    }

    public static void main(String[] args) {
//        SortUtil.verify(Practice200503::select,10000,10000);
//        SortUtil.verify(Practice200503::insert, 10000, 10000);
//        SortUtil.verify(Practice200503::merge, 10000, 10000);
//        SortUtil.verify(Practice200503::quick_1, 10000, 10000);
//        SortUtil.verify(Practice200503::quick_2, 10000, 10000);
        SortUtil.verify(Practice200503::quick_3, 10000, 10000);
    }
}
