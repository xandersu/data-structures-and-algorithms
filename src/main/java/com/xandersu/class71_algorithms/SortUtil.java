package com.xandersu.class71_algorithms;

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

    //是否从小到大
    public static boolean isFromSmallToLarge(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                return false;
            }
        }
        return true;
    }

    //验证
    public static void verify(Consumer<int[]> consumer) {
        int[] arr = SortUtil.generatePrintArr(10, 100);
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();

        consumer.accept(arr);

        stopWatch.stop();
        System.out.println("耗时 = " + stopWatch.getTotalTimeSeconds() + " 秒， "
                + stopWatch.getTotalTimeMillis() + " 毫秒。");
        System.out.println();
        System.out.println(Arrays.toString(arr));

        System.out.println("排序后的数组是否正确：" + SortUtil.isFromSmallToLarge(arr));
    }
}
