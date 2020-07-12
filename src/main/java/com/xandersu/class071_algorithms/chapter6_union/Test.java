package com.xandersu.class071_algorithms.chapter6_union;

import com.xandersu.class207_datastructuresandalgorithms.union_find.UnionFind1;

/**
 * @author suxun
 * @date 2020/7/12 15:13
 * @description
 */
public class Test {

    public static void main(String[] args) {
        int n = 1000000;

//        IUnionFind u1 = new UnionFind_1(n);
//        IUnionFind u2 = new UnionFind_2(n);
//        IUnionFind u3 = new UnionFind_3(n);
        IUnionFind u4 = new UnionFind_4(n);
        IUnionFind u5 = new UnionFind_5(n);
//        testUnionFind(n, u1);
//        testUnionFind(n, u2);
//        testUnionFind(n, u3);
        testUnionFind(n, u4);
        testUnionFind(n, u5);

    }

    private static void testUnionFind(int n, IUnionFind uf) {
        long startTime = System.currentTimeMillis();


        // 进行n次操作, 每次随机选择两个元素进行合并操作
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.unionElements(a, b);
        }
        // 再进行n次操作, 每次随机选择两个元素, 查询他们是否同属一个集合
        for (int i = 0; i < n; i++) {
            int a = (int) (Math.random() * n);
            int b = (int) (Math.random() * n);
            uf.isConnected(a, b);
        }
        long endTime = System.currentTimeMillis();

        // 打印输出对这2n个操作的耗时
        System.out.println((endTime - startTime) + "ms");
    }
}
