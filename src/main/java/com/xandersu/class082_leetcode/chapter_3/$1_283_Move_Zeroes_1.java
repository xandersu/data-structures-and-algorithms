package com.xandersu.class082_leetcode.chapter_3;

import java.util.ArrayList;
import java.util.List;

/**
 * @author suxun
 * @date 2020/7/19 14:19
 * @description
 */
public class $1_283_Move_Zeroes_1 {

    public void moveZeroes(int[] nums) {
        //额外空间存放非0元素
        List<Integer> nonZeroList = new ArrayList<>();
        for (int num : nums) {
            if (num != 0) {
                nonZeroList.add(num);
            }
        }

        for (int i = 0; i < nonZeroList.size(); i++) {
            nums[i] = nonZeroList.get(i);
        }
        for (int i = nonZeroList.size(); i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
