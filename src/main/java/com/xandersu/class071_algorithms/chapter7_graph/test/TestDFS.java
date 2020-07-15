package com.xandersu.class071_algorithms.chapter7_graph.test;

import com.xandersu.class071_algorithms.chapter7_graph.Component;
import com.xandersu.class071_algorithms.chapter7_graph.Component_my_2;
import com.xandersu.class071_algorithms.chapter7_graph.SparseGraph;

// 测试图的联通分量算法
public class TestDFS {

    public static void main(String[] args) {

        // TestG1.txt
        String filename1 = "/Users/suxun/IdeaProjects/amy/data-structures-and-algorithms/src/main/java/com/xandersu/class071_algorithms/chapter7_graph/test/testG1.txt";
        SparseGraph g1 = new SparseGraph(13, false);
        ReadGraph readGraph1 = new ReadGraph(g1, filename1);
        Component_my_2 component1 = new Component_my_2(g1);
        System.out.println("TestG1.txt, Component Count: " + component1.count());
        System.out.println();

        // TestG2.txt
        String filename2 = "/Users/suxun/IdeaProjects/amy/data-structures-and-algorithms/src/main/java/com/xandersu/class071_algorithms/chapter7_graph/test/testG2.txt";
        SparseGraph g2 = new SparseGraph(6, false);
        ReadGraph readGraph2 = new ReadGraph(g2, filename2);
        Component_my_2 component2 = new Component_my_2(g2);
        System.out.println("TestG2.txt, Component Count: " + component2.count());
    }
}