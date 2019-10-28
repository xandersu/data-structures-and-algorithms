package com.xandersu.refertooffer;

import com.alibaba.fastjson.JSON;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @Author: suxun
 * @Date: 2019/10/28 22:08
 * @Description:
 */
public class P3FindArrayDuplicateNumber {
    public static void main(String[] args) {
        int[] array = getRandomArray(7);
        System.out.println("array= " + Arrays.toString(array));
        find(array);
    }

    private static int[] getRandomArray(int capacity) {
        if (capacity <= 0) {
            return null;
        }
        int[] res = new int[capacity];
        for (int i = 0; i < capacity; i++) {
            res[i] = (int) (Math.random() * capacity);
        }
        return res;
    }

    private static void find(int[] array) {
        if (array == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> duplicateSet = new HashSet<>();
        for (int num : array) {
            if (set.contains(num)) {
                duplicateSet.add(num);
            }
            set.add(num);
        }
        System.out.println("duplicate num=" + JSON.toJSONString(duplicateSet));
    }
}
