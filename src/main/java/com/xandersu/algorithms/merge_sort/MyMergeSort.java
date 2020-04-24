package com.xandersu.algorithms.merge_sort;

import com.xandersu.algorithms.SortUtil;

import java.util.Arrays;

public class MyMergeSort {

    public static void main(String[] args) {
        int[] arr = SortUtil.generatePrintArr(10, 1000);
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));


    }

    public static void mergeSort(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        mergeSort(arr, start, end);
    }

    public static void mergeSort(int[] arr, int start, int end) {
        if (arr == null || arr.length == 0 || start >= end) {
            return;
        }
        int mid = (end + start) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge2(arr, start, mid, end);

    }

    public static void merge(int[] arr, int start, int middle, int end) {
        int[] aux = new int[end - start + 1];
        for (int i = start; i <= end; i++) {
            aux[i - start] = arr[i];
        }

        int ii = start;
        int jj = middle + 1;
        for (int k = start; k <= end; k++) {
            if (ii > middle) {
                arr[k] = aux[jj - start];
                jj++;
            } else if (jj > end) {
                arr[k] = arr[ii - start];
                ii++;
            } else if (aux[ii - start] < aux[jj - start]) {
                arr[k] = aux[ii - start];
                ii++;
            } else {
                arr[k] = aux[jj - start];
                jj++;
            }
        }
    }

    private static void merge2(int[] arr, int l, int mid, int r) {
        int[] aux = Arrays.copyOfRange(arr, l, r+1);
        // 初始化，i指向左半部分的起始索引位置l；j指向右半部分起始索引位置mid+1
        int i = l, j = mid+1;
        for( int k = l ; k <= r; k ++ ){
            if( i > mid ){  // 如果左半部分元素已经全部处理完毕
                arr[k] = aux[j-l]; j ++;
            }
            else if( j > r ){   // 如果右半部分元素已经全部处理完毕
                arr[k] = aux[i-l]; i ++;
            }
            else if( aux[i-l]<(aux[j-l]) ){  // 左半部分所指元素 < 右半部分所指元素
                arr[k] = aux[i-l]; i ++;
            }
            else{  // 左半部分所指元素 >= 右半部分所指元素
                arr[k] = aux[j-l]; j ++;
            }
        }
    }
}
