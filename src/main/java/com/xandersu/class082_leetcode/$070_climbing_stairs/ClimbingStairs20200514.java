package com.xandersu.class082_leetcode.$070_climbing_stairs;

/**
 * @author su
 * @date 2020/5/1310:59
 * @description 动态规划
 */
public class ClimbingStairs20200514 {

    public static int climbStairs(int n) {
        int[] ints = new int[n + 1];
        if (n >= 0) {
            ints[0] = 0;
        }
        if (n >= 1) {
            ints[1] = 1;
        }
        if (n >= 2) {
            ints[2] = 2;

        }
        for (int i = 3; i <= n; i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
        }
        return ints[n];
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(1));
    }
}
