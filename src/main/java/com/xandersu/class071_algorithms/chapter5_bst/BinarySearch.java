package com.xandersu.class071_algorithms.chapter5_bst;

import com.xandersu.util.SortUtil;

/**
 * @author suxun
 * @date 2020/7/5 17:08
 * @description
 */
public class BinarySearch {

    public static int search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
//        int[] arr = SortUtil.generatePrintArr(10, 100);
//        System.out.println(search(arr, 0));
//        System.out.println(search(arr, 1));

        int[] arr2 = {1, 2, 3, 4, 5, 6};
        System.out.println(search(arr2, 0));
        System.out.println(search(arr2, 1));
        System.out.println(search(arr2, 2));
        System.out.println(search(arr2, 3));
        System.out.println(search(arr2, 4));
        System.out.println(search(arr2, 5));
        System.out.println(search(arr2, 6));
        System.out.println(search(arr2, 7));
    }
}
