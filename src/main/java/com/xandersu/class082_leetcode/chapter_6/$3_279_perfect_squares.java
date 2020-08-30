package com.xandersu.class082_leetcode.chapter_6;

import javafx.util.Pair;

import java.util.LinkedList;

/**
 * @author suxun
 * @date 2020/8/30 14:47
 * @description 没学会
 */
public class $3_279_perfect_squares {
    public static int numSquares(int n) {
        LinkedList<Pair<Integer, Integer>> queue = new LinkedList<Pair<Integer, Integer>>();
        queue.addLast(new Pair<Integer, Integer>(n, 0));

        while(!queue.isEmpty()){
            Pair<Integer, Integer> front = queue.removeFirst();
            int num = front.getKey();
            int step = front.getValue();

            if(num == 0)
                return step;

            for(int i = 1 ; num - i*i >= 0 ; i ++)
                queue.addLast(new Pair(num - i * i, step + 1));
        }

        throw new IllegalStateException("No Solution.");
    }

    public static void main(String[] args) {
        System.out.println(12);
    }
}
