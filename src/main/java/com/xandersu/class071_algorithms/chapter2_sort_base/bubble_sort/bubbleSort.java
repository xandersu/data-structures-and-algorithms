package com.xandersu.class071_algorithms.chapter2_sort_base.bubble_sort;

import com.xandersu.class071_algorithms.SortUtil;
import org.springframework.util.StopWatch;

import java.util.Arrays;

/**
 * @author: suxun
 * @date: 2020/5/2 10:39
 * @description: 冒泡排序
 * 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
 * 针对所有的元素重复以上的步骤，除了最后一个。
 * 持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。
 */
public class bubbleSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] <= arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
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
