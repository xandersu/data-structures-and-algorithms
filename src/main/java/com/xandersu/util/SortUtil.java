package com.xandersu.util;

import org.springframework.util.StopWatch;

import java.util.Arrays;
import java.util.function.Consumer;

/**
 * @author su
 * @date 2019/11/1123:18
 * @description
 */
public class SortUtil {

    public static int[] generatePrintArr(int length, int max) {
        return generatePrintArr(length, max, true);
    }

    public static int[] generatePrintArr(int length, int max, boolean printArr) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = (int) (Math.random() * max);
        }
        if (printArr) {
            System.out.println(Arrays.toString(arr));
        }
        return arr;
    }

    public static int[] generateOrderPrintArr(int length) {
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    //是否从小到大
    public static boolean isFromSmallToLarge(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                System.out.println("验证失败： arr[i-1]= " + arr[i - 1] + "  arr[i]= " + arr[i]);
                return false;
            }
        }
        return true;
    }

    //验证
    public static void verify(Consumer<int[]> consumer) {
        verify(consumer, 10, 100);
    }

    public static void verify(Consumer<int[]> consumer, int length, int max) {
        verify(consumer, length, max, true);
    }

    public static void verify(Consumer<int[]> consumer, int length, int max, boolean printArray) {
        if (length > 10000) {
            printArray = false;
        }
        int[] arr = SortUtil.generatePrintArr(length, max, printArray);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        consumer.accept(arr);

        stopWatch.stop();
        System.out.println("排序耗时 = " + stopWatch.getTotalTimeSeconds() + "秒， "
                + stopWatch.getTotalTimeMillis() + "毫秒。");
        if (printArray) {
            System.out.println(Arrays.toString(arr));
        }

        System.out.println("排序后的数组是否正确：" + SortUtil.isFromSmallToLarge(arr));
    }

//    /**
//     * 打印数组结构的堆
//     */
//    public static void printArrHeap(Object[] arr) {
//
//    }
}
