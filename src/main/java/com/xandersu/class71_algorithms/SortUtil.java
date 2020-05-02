package com.xandersu.class71_algorithms;

import org.springframework.util.NumberUtils;

import java.util.Arrays;

/**
 * @author su
 * @date 2019/11/1123:18
 * @description
 */
public class SortUtil {

    public static int[] generatePrintArr(int length, int max) {
        int[] arr = new int[length];
        for (int i = 0; i < length - 1; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

}
