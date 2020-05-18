package com.xandersu.class082_leetcode.$120_triangle;

import java.util.*;

/**
 * @author su
 * @date 2020/5/1311:25
 * @description
 */
public class Triangle20200513 {

    static Map<Integer, Integer> map = new HashMap<>();

    public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        if (size <= 0) {
            return 0;
        }
        Integer i1 = triangle.get(0).get(0);
        if (size == 1) {
            return i1;
        }

        int floor = 0;
        int topIndex = 0;

        return minimumTotal(triangle, floor, topIndex);
    }

    private int minimumTotal(List<List<Integer>> triangle, int floor, int index) {
        int size = triangle.size();
        Integer count = triangle.get(floor).get(index);
        if (size - 1 == floor) {
            return count;
        }


        int left = minimumTotal(triangle, floor + 1, index);
        int right = minimumTotal(triangle, floor + 1, index + 1);

        return count + Math.min(left, right);
    }

    public static void main(String[] args) {
        Triangle20200513 t = new Triangle20200513();

        ArrayList<List<Integer>> lists = new ArrayList<>();

        List<Integer> l1 = Arrays.asList(-1);
        lists.add(l1);
        List<Integer> l2 = Arrays.asList(2, 3);
        lists.add(l2);
        List<Integer> l3 = Arrays.asList(1, -1, -3);
        lists.add(l3);
        List<Integer> l4 = Arrays.asList(4, 1, 8, 3);
//        lists.add(l4);

        System.out.println(t.minimumTotal(lists));
    }
}
