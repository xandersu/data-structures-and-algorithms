package com.xandersu.class082_leetcode.$070_climbing_stairs;

import java.util.HashMap;
import java.util.Map;

/**
 * @author su
 * @date 2020/5/1310:59
 * @description 递归
 */
public class ClimbingStairs20200513 {

    static Map<Integer, Integer> map = new HashMap<>();

    public static int climbStairs(int n) {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (map.containsKey(n)) {
            return map.get(n);
        } else {
            int count = climbStairs(n - 1) + climbStairs(n - 2);
            map.put(n, count);
            return count;
        }
    }


    public static void main(String[] args) {
        System.out.println(climbStairs(3));
    }
}
