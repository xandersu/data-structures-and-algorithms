package com.xandersu.class207_datastructuresandalgorithms;

import com.xandersu.class207_datastructuresandalgorithms.union_find.*;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

/**
 * @Author: suxun
 * @Date: 2018/11/4 20:19
 * @Description:
 */
@SpringBootTest
public class TestUnionFind {
    @Test
    public void testUF() {
        int size = 1000000;
//        UnionFind1 uf1 = new UnionFind1(size);
//        UnionFind2 uf2 = new UnionFind2(size);
        UnionFind3 uf3 = new UnionFind3(size);
        UnionFind4 uf4 = new UnionFind4(size);
        UnionFind5 uf5 = new UnionFind5(size);
        UnionFind5 uf6 = new UnionFind5(size);

//        System.out.println("uf1="+testUF(uf1,size));
//        System.out.println("uf2="+testUF(uf2,size));
        System.out.println("uf3="+testUF(uf3,size));
        System.out.println("uf4="+testUF(uf4,size));
        System.out.println("uf5="+testUF(uf5,size));
        System.out.println("uf6="+testUF(uf6,size));
    }

    private double testUF(MyUF uf, int m) {
        Random random = new Random();
        int size = uf.getSize();
        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.unionElements(a, b);
        }

        for (int i = 0; i < m; i++) {
            int a = random.nextInt(size);
            int b = random.nextInt(size);
            uf.isConnected(a, b);
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}
