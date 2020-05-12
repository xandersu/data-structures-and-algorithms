package com.xandersu.my_test.practice;

import com.xandersu.class071_algorithms.SortUtil;

import java.util.Arrays;

/**
 * @author: suxun
 * @date: 2020/5/4 10:03
 * @description:
 */
public class Practice200504 {

    //insert
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

    //merge
    public static void merge(int[] arr) {
        merge(arr, 0, arr.length - 1);
    }

    public static void merge(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int mid = l + (r - l) / 2;
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
        for (; lIndex <= mid; lIndex++, k++) {
            arr[k] = aux[lIndex - l];
        }
        for (; rIndex <= r; rIndex++, k++) {
            arr[k] = aux[rIndex - l];
        }
    }

    //quick 1
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
        // arr[l+1...j] < v ; arr[j+1...i) > v
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

    //quick 2
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

        // arr[l+1...lt) <= v; arr(gt...r] >= v
        int lt = l + 1;
        int gt = r;
        while (true) {
            while (lt <= r && arr[lt] < v) {
                lt++;
            }
            while (gt > lt && arr[gt] > v) {
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


    //quick 3
    public static void quick_3(int[] arr) {
        quick_3(arr, 0, arr.length - 1);
    }

    public static void quick_3(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int v = arr[l];

        //arr[l+1...lt] <v
        //arr[lt+1 ... i-1] = v
        //arr[gt...r]>v
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


    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
//        SortUtil.verify(Practice200504::insert, 1000000, 100000);
//        SortUtil.verify(Practice200504::merge, 1000, 100000);
//        SortUtil.verify(Practice200504::quick_1, 1000000, 100000);
//        SortUtil.verify(Practice200504::quick_2, 1000000, 100000);
        SortUtil.verify(Practice200504::quick_3, 1000000, 100000);
    }

}
