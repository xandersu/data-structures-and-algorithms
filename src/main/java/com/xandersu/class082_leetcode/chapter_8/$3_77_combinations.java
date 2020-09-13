package com.xandersu.class082_leetcode.chapter_8;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author suxun
 * @date 2020/9/13 17:08
 * @description
 */
public class $3_77_combinations {

    private final List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        if (n <= 0 || k <= 0 || k > n) {
            return res;
        }
        LinkedList<Integer> p = new LinkedList<>();
        combine(n, k, 1, p);
        return res;
    }

    private void combine(int n, int k, int index, LinkedList<Integer> p) {
        if (p.size() == k) {
            res.add(new ArrayList<>(p));
        }
        for (int i = index; i <= n; i++) {
            p.addLast(i);
            combine(n, k, i + 1, p);
            p.removeLast();
        }
    }

    public static void main(String[] args) {
        $3_77_combinations t = new $3_77_combinations();
        List<List<Integer>> combine = t.combine(4, 2);
        for (List<Integer> integers : combine) {
            System.out.println(integers);
        }
    }

}
