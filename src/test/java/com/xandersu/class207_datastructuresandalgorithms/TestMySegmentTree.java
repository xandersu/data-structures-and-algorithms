package com.xandersu.class207_datastructuresandalgorithms;

import com.xandersu.class207_datastructuresandalgorithms.tree.MySegmentTree;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: suxun
 * @Date: 2018/10/22 22:11
 * @Description:
 */
@SpringBootTest
public class TestMySegmentTree {

    @Test
    public void testMySegmentTree() {
        Integer[] nums = {-2, 0, 3, -5, 2, -1};

        MySegmentTree<Integer> segTree = new MySegmentTree<Integer>(nums, (a, b) -> a + b);

        System.out.println(segTree.toString());

        System.out.println(segTree.query(0,2));
        System.out.println(segTree.query(2,5));
        System.out.println(segTree.query(0,5));

    }
}
