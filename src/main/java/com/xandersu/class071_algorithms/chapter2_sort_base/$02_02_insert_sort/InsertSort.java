package com.xandersu.class071_algorithms.chapter2_sort_base.$02_02_insert_sort;

import com.xandersu.class071_algorithms.SortUtil;

/**
 * @author: suxun
 * @date: 2020/5/2 10:24
 * @description: 插入排序
 * 后面的数和前面的数依次进行比较，如果比前面的小(大)就交换一次位置
 */
public class InsertSort {

    public static void sort(int[] arr) {
        //可以提前结束
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j > 0 && j < arr.length; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }

    //第一种的改进方案，只是写法不同
    public static void sort2(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                int temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
            }
        }
    }

    //优化方案
    //先提取一个数，不贸然跟前面的数进行交换
    //如果这个数比前面的大，比后面的小，就放在这个位置
    //不然把前面的位置复制到后一个，这个数向前走，比较前后
    public static void sort3(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //寻找元素arr[i]合适的位置
            int num = arr[i];
            //j保存元素num应该插入的位置
            int j;
            for (j = i; j > 0 && arr[j - 1] > num; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = num;
        }
    }

    public static void sort4(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > num; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = num;
        }
    }


    public static void main(String[] args) {
        SortUtil.verify(InsertSort::sort4,1000000,1000000);
    }

}
