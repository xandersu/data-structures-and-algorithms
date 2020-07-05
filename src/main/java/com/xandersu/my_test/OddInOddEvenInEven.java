package com.xandersu.my_test;

import com.xandersu.util.SortUtil;

/**
 * @author su
 * @date 2020/5/1816:40
 * @description 奇数位上都是奇数或者偶数位上都是偶数
 */
public class OddInOddEvenInEven {

    public static void oddInOddEvenInEven(int[] arr) {

        int i = 0;
        while (i < arr.length) {
            int thisIndex = arr[i];
            if (thisIndex % 2 == (i + 1) % 2) {
                i++;
                continue;
            }
            for (int k = i + 1; k < arr.length; k++) {
                if (thisIndex % 2 == (k + 1) % 2) {
                    SortUtil.swap(arr, i, k);
                    break;
                }
            }
        }

    }


    public static void main(String[] args) {
        int[] arr = {1, 6, 3, 9, 12, 657, 2344, 9876, 123, 75685, 234, 780, 324, 567233};
        //           1  2  3  4   5   6     7    8     9    10    11    12   13   14
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) % 2 + " = " + arr[i] % 2);
        }
        oddInOddEvenInEven(arr);
        System.out.println("=================");
        for (int i = 0; i < arr.length; i++) {
            System.out.println((i + 1) % 2 + " = " + arr[i] % 2);
        }
    }
}
