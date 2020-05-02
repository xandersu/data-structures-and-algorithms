package com.xandersu.class71_algorithms.chapter3_sorting_advance.$02_quick_sort;

import com.xandersu.class71_algorithms.SortUtil;
import com.xandersu.class71_algorithms.chapter3_sorting_advance.$01_merge_sort.MergeSort;

/**
 * @author: suxun
 * @date: 2020/5/2 14:20
 * @description: 快速排序
 * 1. 从数列中挑出一个元素，称为 "基准"（pivot）;
 * 2. 重新排序数列，所有元素比基准值小的摆放在基准前面，所有元素比基准值大的摆在基准的后面（相同的数可以到任一边）。在这个分区退出之后，该基准就处于数列的中间位置。这个称为分区（partition）操作；
 * 3. 递归地（recursive）把小于基准值元素的子数列和大于基准值元素的子数列排序；
 */
public class QuickSort {

    public static void sort_My(int[] arr) {
        sort_My(arr, 0, arr.length - 1);
    }

    private static void sort_My(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition_My(arr, l, r);
        sort_My(arr, l, p - 1);
        sort_My(arr, p + 1, r);
    }


    //l是起点，r是终点
    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    public static int partition_My(int[] arr, int l, int r) {
        int v = arr[l];
        // arr[l+1...j] < v ; arr[j+1...i) > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[l];
        arr[l] = temp;

        return j;
    }

    //随机标定点pivot
    public static int partitionRandomP(int[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        int randomIndex = (int) (Math.random() * (r - l + 1)) + l;
        int randomTemp = arr[l];
        arr[l] = arr[randomIndex];
        arr[randomIndex] = randomTemp;

        int v = arr[l];

        // arr[l+1...j] < v ; arr[j+1...i) > v
        int j = l;
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < v) {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[j];
        arr[j] = arr[l];
        arr[l] = temp;

        return j;
    }

    //双路快排
    public static void sort_My2(int[] arr) {
        sort_My2(arr, 0, arr.length - 1);
    }

    //双路快排
    private static void sort_My2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition_My2(arr, l, r);
        sort_My2(arr, l, p - 1);
        sort_My2(arr, p + 1, r);
    }

    //双路快排
    public static int partition_My2(int[] arr, int l, int r) {
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        int randomIndex = (int) (Math.random() * (r - l + 1)) + l;
        int randomTemp = arr[l];
        arr[l] = arr[randomIndex];
        arr[randomIndex] = randomTemp;

        int v = arr[l];

        int i = l + 1;
        int j = r;
        // arr[l+1...i) <= v; arr(j...r] >= v
        while (true) {
            while (i <= r && arr[i] < v) {
                i++;
            }
            while (j >= i + 1 && arr[j] > v) {
                j--;
            }
            if (i > j) {
                break;
            }
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }

        int temp = arr[l];
        arr[l] = arr[j];
        arr[j] = temp;


        return j;
    }

    //3路快排
    public static void sort_My3(int[] arr) {
        sort_My3(arr, 0, arr.length - 1);
    }


    //3路快排
    public static void sort_My3(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int randomIndex = (int) (Math.random() * (r - l + 1)) + l;

        swap_my(arr, l, randomIndex);

        int v = arr[l];

        int lt = l;
        int gt = r;
        int i = l + 1;
        while (i <= gt) {
            if (arr[i] == v) {
                i++;
            } else if (arr[i] < v) {
                lt++;
                swap_my(arr, lt, i);
                i++;
            } else if (v < arr[i]) {
                swap_my(arr, gt, i);
                gt--;
            }
        }

        swap_my(arr, l, lt);

        sort_My3(arr, l, lt - 1);
        sort_My3(arr, gt, r);
    }

    public static void swap_my(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }


    public static void main(String[] args) {
        int length = 100000;

//        SortUtil.verify(QuickSort::sort_My, length, 100, false);
//        SortUtil.verify(QuickSort::sort_My2, length, 100, false);
        SortUtil.verify(QuickSort::sort_My, length, 100, false);
        SortUtil.verify(QuickSort::sort_My3, length, 100, false);
        SortUtil.verify(MergeSort::sort_T, length, 100, false);
        SortUtil.verify(MergeSort::sort2, length, 100, false);

    }
}
