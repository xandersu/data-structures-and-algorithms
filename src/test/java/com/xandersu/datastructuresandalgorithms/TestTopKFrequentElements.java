package com.xandersu.datastructuresandalgorithms;

import com.xandersu.datastructuresandalgorithms.leetcode.TopKFrequentElements;
import org.junit.Test;

import java.util.List;

/**
 * @Author: suxun
 * @Date: 2018/10/21 15:59
 * @Description:
 */
public class TestTopKFrequentElements {

    @Test
    public void testTopKFrequentElements() {
        int[] arr = {4, 1, -1, 2, -1, 2, 3};
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        List<Integer> res = topKFrequentElements.topKFrequent(arr, 2);
        System.out.println(res);
    }
}
