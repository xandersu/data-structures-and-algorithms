package com.xandersu.datastructuresandalgorithms.leetcode;

/**
 * @Author: suxun
 * @Date: 2018/9/26 22:33
 * @Description:递归原则
 *              1、求解最基本问题
 *              2、把原问题转化成更小的问题
 *              =======================
 *              注意递归函数的"宏观"语意
 *              递归函数就是一个函数，完成一个功能
 */
public class Sum {



    public static int sum(int[] arr) {
        return sum(arr,0);
    }

    private static int sum(int[] arr, int l) {
        if(l==arr.length){
            return 0;
        }
        return arr[l] + sum(arr,l+1);
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7,8};
        System.out.println(Sum.sum(nums));
    }
}
