package com.xandersu.class082_leetcode.chapter_3;


import java.util.Arrays;
import java.util.Objects;

import static com.xandersu.util.SortUtil.swap;

/**
 * @author suxun
 * @date 2020/7/19 14:03
 * @description
 */
public class $5_88_merge_sorted_array_My {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
//        int[] temp = new int[nums1.length - 1];
//        System.arraycopy(nums1,0,temp,0,m);
        int[] temp = Arrays.copyOfRange(nums1, 0, m);
        int a = 0;
        int b = 0;
        int i = 0;
        while (a < m && b < n) {
            if (temp[a] < nums2[b]) {
                nums1[i] = temp[a];
                a++;
            } else {
                nums1[i] = nums2[b];
                b++;
            }
            i++;
        }
        if (a < m) {
            for (int j = a; j < m; j++) {
                nums1[i] = temp[j];
                i++;
            }
        } else {
            for (int j = b; j < n; j++) {
                nums1[i] = nums2[j];
                i++;
            }
        }

    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        int[] nums2 = {2, 5, 6};
        merge(nums1, 3, nums2, 3);
        System.out.println(Arrays.toString(nums1));
    }
}
