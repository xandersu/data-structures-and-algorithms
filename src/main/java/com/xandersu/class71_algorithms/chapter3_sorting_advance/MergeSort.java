package com.xandersu.class71_algorithms.chapter3_sorting_advance;

import com.xandersu.class71_algorithms.SortUtil;
import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @author: suxun
 * @date: 2020/5/2 12:03
 * @description:
 */
public class MergeSort {

    //自己的实现
    //根绝葛冰两个链表的思想
    public static int[] sort_My(int[] arr) {

        return partition(arr, 0, arr.length - 1);
    }

    public static int[] partition(int[] arr, int l, int r) {
        if (l >= r) {
            return new int[]{arr[l]};
        }

        int m = (l + r) / 2;

        int[] lArr = partition(arr, l, m);
        int[] rArr = partition(arr, m + 1, r);

        return merge(lArr, rArr);
    }

    public static int[] merge(int[] lArr, int[] rArr) {
        int lLength = lArr.length;
        int rLength = rArr.length;
        int totalLen = lLength + rLength;
        int[] result = new int[totalLen];
        int lIndex = 0, rIndex = 0, resultIndex = 0;
        while (lIndex < lLength && rIndex < rLength) {
            if (lArr[lIndex] < rArr[rIndex]) {
                result[resultIndex] = lArr[lIndex];
                lIndex++;
            } else {
                result[resultIndex] = rArr[rIndex];
                rIndex++;
            }
            resultIndex++;
        }
        if (lIndex < lLength) {
            for (int i = lIndex; i < lLength; i++) {
                result[resultIndex] = lArr[lIndex];
                lIndex++;
                resultIndex++;
            }
        } else if (rIndex < rLength) {
            for (int i = rIndex; i < rLength; i++) {
                result[resultIndex] = rArr[rIndex];
                rIndex++;
                resultIndex++;
            }
        }
        return result;
    }

    public static void sort2(int[] arr) {
        partition2(arr, 0, arr.length - 1);
    }

    public static void partition2(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int m = (l + r) / 2;

        partition2(arr, l, m);
        partition2(arr, m + 1, r);
        if (arr[m] > arr[m + 1]) {
            merge2(arr, l, m, r);
        }
    }

    public static void merge2(int[] arr, int l, int mid, int r) {
//        int[] aux = new int[arr.length];
//        System.arraycopy(arr, l, aux, l, r + 1 - l);
        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        //i左边的开始
        //j右边的开始
        //k目标数组的位置
        int i = l, j = mid + 1, k = i;

        while (i <= mid && j <= r) {
            if (aux[i - l] < aux[j - l]) {
                arr[k] = aux[i - l];
                i++;
            } else {
                arr[k] = aux[j - l];
                j++;
            }
            k++;
        }
        if (i <= mid) {
            for (; i <= mid; i++) {
                arr[k] = aux[i - l];
                k++;
            }
        } else if (j <= r) {
            for (; j <= r; j++) {
                arr[k] = aux[j - l];
                k++;
            }
        }
    }

    public static void mergeBU(int[] arr) {
        mergeBU(arr, arr.length - 1);
    }

    public static void mergeBU(int[] arr, int n) {
        for (int sz = 1; sz <= n; sz += sz) {
            for (int i = 0; i + sz < n; i += (sz + sz)) {
                merge2(arr, i, i + sz - 1, Math.min(i + sz + sz - 1, n - 1));
            }

        }
    }


    //========================================================================//

    public static void sort_T(int[] arr) {
        int n = arr.length;
        sort_T(arr, 0, n - 1);
    }

    // 递归使用归并排序,对arr[l...r]的范围进行排序
    private static void sort_T(int[] arr, int l, int r) {
        if (l >= r)
            return;

        int mid = (l + r) / 2;
        sort_T(arr, l, mid);
        sort_T(arr, mid + 1, r);
        merge_T(arr, l, mid, r);
    }

    // 将arr[l...mid]和arr[mid+1...r]两部分进行归并
    private static void merge_T(int[] arr, int l, int mid, int r) {

        int[] aux = Arrays.copyOfRange(arr, l, r + 1);

        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid + 1;
        for (int k = l; k <= r; k++) {

            if (i > mid) {  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j - l];
                j++;
            } else if (j > r) {   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i - l];
                i++;
            } else if (aux[i - l] < (aux[j - l])) {  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i - l];
                i++;
            } else {  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int length = 1000;

        int[] arr = SortUtil.generatePrintArr(length, length, false);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        arr = sort_My(arr);

        stopWatch.stop();
        System.out.println("耗时 = " + stopWatch.getTotalTimeSeconds() + " 秒， "
                + stopWatch.getTotalTimeMillis() + " 毫秒。");
        System.out.println("排序后的数组是否正确：" + SortUtil.isFromSmallToLarge(arr));

        System.out.println();

        SortUtil.verify(MergeSort::sort2, length, length, false);

        System.out.println();

        SortUtil.verify(MergeSort::mergeBU, length, length, false);


        SortUtil.verify(MergeSort::sort_T, length, length, false);

    }
}
