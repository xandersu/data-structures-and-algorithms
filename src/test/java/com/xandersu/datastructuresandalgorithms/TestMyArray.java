package com.xandersu.datastructuresandalgorithms;

import com.xandersu.datastructuresandalgorithms.array.MyArrayGeneric;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Author: suxun
 * @Date: 2018/9/17 23:06
 * @Description:
 */
@SpringBootTest
public class TestMyArray {

    @Test
    public void test1() {
        MyArrayGeneric<Integer> integerArray = new MyArrayGeneric<>();
        for (int i = 0; i < 11; i++) {
            integerArray.addFirst(i);
        }
        System.out.println(integerArray);
        integerArray.remove(integerArray.getSize() - 1);
        System.out.println(integerArray);
    }
}
