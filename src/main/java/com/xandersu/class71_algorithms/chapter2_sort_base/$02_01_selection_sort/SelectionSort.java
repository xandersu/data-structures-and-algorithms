package com.xandersu.class71_algorithms.chapter2_sort_base.$02_01_selection_sort;

import com.xandersu.class71_algorithms.SortUtil;
import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @author: suxun
 * @date: 2020/5/2 09:52
 * @description: 选择排序
 * 首先找出最小的值，与角标为1的进行交换。
 * 交换后目前第一位就是最小的
 * 然后再找出最小的值与角标为2的进行交换
 * 不断进行下去
 */
public class SelectionSort {

    public static void sort(int[] arr) {

        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            //选择最小的
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] <= arr[minIndex]) {
                    minIndex = j;
                }
            }
            //与未排序的最开始的位置进行交换
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static void main(String[] args) {
        int[] ints = SortUtil.generatePrintArr(10000, 100);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        sort(ints);
        stopWatch.stop();
        System.out.println("耗时 = " + stopWatch.getTotalTimeSeconds() + " 秒， "
                + stopWatch.getTotalTimeMillis() + " 毫秒。");
        System.out.println(Arrays.toString(ints));
    }

}
