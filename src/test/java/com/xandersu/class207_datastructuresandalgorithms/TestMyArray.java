package com.xandersu.class207_datastructuresandalgorithms;

import com.alibaba.fastjson.JSON;
import com.xandersu.class207_datastructuresandalgorithms.array.MyArrayGeneric;
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
    public void testMyArray() {
        MyArrayGeneric<Integer> integerArray = new MyArrayGeneric<>();
        for (int i = 0; i < 11; i++) {
            integerArray.addFirst(i);
        }
        System.out.println(integerArray);
        integerArray.remove(integerArray.getSize() - 1);
        System.out.println(integerArray);
        integerArray.removeLast();
        System.out.println(integerArray);
        System.out.println(integerArray.getFirst());
        System.out.println(integerArray.getLast());
    }

    @Test
    public void testMyArray2() {
        int[] arr = {1, 4, 6, 2, 7, 0, -1, 8, 120, 11};

//        for (int i = 0; i < arr.length-1; i++) {
//            for (int j = i; j < arr.length-1; j++) {
//                int a = arr[i];
//                int b = arr[j];
//                int c = -1111;
//                if(a<b){
//
//                }
//            }
//        }
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];

                    arr[j] = arr[j + 1];

                    arr[j + 1] = temp;
                }
            }
        }
        System.out.println(JSON.toJSONString(arr));
    }
}
