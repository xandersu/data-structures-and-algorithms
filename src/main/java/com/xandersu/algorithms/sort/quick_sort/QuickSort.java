package com.xandersu.algorithms.sort.quick_sort;

import java.util.Arrays;

/**
 * Created by lenovo on 2019/11/9.
 */
public class QuickSort {

    public static void quickSort1(int[] arr, int low, int high) {
        int i, j, temp;
        if (low > high) {
            return;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            //如果满足条件则交换
            if (i < j) {
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort1(arr, low, i - 1);
        //递归调用右半数组
        quickSort1(arr, i + 1, high);
    }


    /**
     * 快排核心算法，递归实现
     *
     * @param array
     * @param left
     * @param right
     */
    public static void quickSort2(int[] array, int left, int right) {
        if (left > right) {
            return;
        }
        // base中存放基准数
        int base = array[left];
        int i = left, j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }
            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            if (i < j) {
                int tmp = array[i];
                array[i] = array[j];
                array[j] = tmp;
            }
        }
        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[i];
        array[i] = base;

        // 递归，继续向基准的左右两边执行和上面同样的操作
        // i的索引处为上面已确定好的基准值的位置，无需再处理
        quickSort2(array, left, i - 1);
        quickSort2(array, i + 1, right);
        System.out.println("left=" + left + ",right=" + right);
    }

    // 对arr[l...r]部分进行partition操作
    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    private static int partition(Comparable[] arr, int l, int r) {

        Comparable v = arr[l];

        int j = l; // arr[l+1...j] < v ; arr[j+1...i) > v
        for (int i = l + 1; i <= r; i++)
            if (arr[i].compareTo(v) < 0) {
                j++;
                swap(arr, j, i);
            }

        swap(arr, l, j);

        return j;
    }

    // 递归使用快速排序,对arr[l...r]的范围进行排序
    private static void sort(Comparable[] arr, int l, int r) {
        if (l >= r)
            return;

        int p = partition(arr, l, r);
        sort(arr, l, p - 1);
        sort(arr, p + 1, r);
    }

    public static void quickSort3(Comparable[] arr) {

        int n = arr.length;
        sort(arr, 0, n - 1);
    }

    private static void swap(Object[] arr, int i, int j) {
        Object t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void quickSort4(int[] arr) {
        quickSort4(arr, 0, arr.length - 1);
    }

    public static void quickSort4(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int p = partition4(arr, l, r);
        quickSort4(arr, l, p - 1);
        quickSort4(arr, p + 1, r);
    }

    // 返回p, 使得arr[l...p-1] < arr[p] ; arr[p+1...r] > arr[p]
    public static int partition4(int[] arr, int l, int r) {
        if (l >= r) {
            return l;
        }
        int p = l;
        int temp = arr[l];
        for (int i = l + 1; i <= r; i++) {
            if (arr[i] < temp) {
                swap(arr, ++p, i);
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
//        int[] arr = {1, 4, 8, 0, 10, 80, 2};
//        System.out.println(Arrays.toString(fastSort(arr, 0, arr.length - 1)));
//        quickSort1(arr, 0, arr.length - 1);
//        System.out.println(Arrays.toString(arr));

//        int[] arr2 = {1, 80, 100, 4, 8, 0, 50, 2, 30};
//        quickSort2(arr2, 0, arr2.length - 1);
//        System.out.println(Arrays.toString(arr2));
//
//        Integer[] arr3 = {1, 80, 100, 4, 8, 0, 50, 2, 30};
//        quickSort3(arr3);
//        System.out.println(Arrays.toString(arr3));

        int[] arr4 = {1, 80, 100, 4, 8, 0, 50, 2, 30};
        int[] arr5 = {0, 1, 30, 4, 8, 80, 50, 2, 100};

        quickSort4(arr4);
        System.out.println(Arrays.toString(arr4));

    }
}
