package com.xandersu.class207_datastructuresandalgorithms;

import com.xandersu.class207_datastructuresandalgorithms.set.impl.BSTSet;
import com.xandersu.class207_datastructuresandalgorithms.util.FileOperation;

import java.util.ArrayList;

/**
 * @Author: suxun
 * @Date: 2018/10/15 22:08
 * @Description:
 */
public class Main1 {

    public static void main(String[] args) {
        System.out.println("p a p");
        ArrayList<String> words1 = new ArrayList<>();
        boolean b = FileOperation.readFile("/Users/suxun/IdeaProjects/data-structures-and-algorithms/src/main/java/com/xandersu/datastructuresandalgorithms/pride-and-prejudice.txt", words1);
        System.out.println(words1.size());
        BSTSet<String> set1 = new BSTSet<>();
        for (String s : words1) {
            set1.add(s);
        }
        System.out.println("set1 size="+set1.getSize());
    }
}
