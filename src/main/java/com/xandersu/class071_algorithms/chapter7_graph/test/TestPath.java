package com.xandersu.class071_algorithms.chapter7_graph.test;

import com.xandersu.class071_algorithms.chapter7_graph.Path;
import com.xandersu.class071_algorithms.chapter7_graph.SparseGraph;

public class TestPath {

    // 测试寻路算法
    public static void main(String[] args) {

        String filename = "/Users/suxun/IdeaProjects/amy/data-structures-and-algorithms/src/main/java/com/xandersu/class071_algorithms/chapter7_graph/test/testG.txt";
        SparseGraph g = new SparseGraph(7, false);
        ReadGraph readGraph = new ReadGraph(g, filename);
        g.show();
        System.out.println();

        Path path = new Path(g,0);
        System.out.println("Path from 0 to 6 : ");
        path.showPath(6);
    }
}