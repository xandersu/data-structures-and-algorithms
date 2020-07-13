package com.xandersu.class071_algorithms.chapter7_graph;

/**
 * @author suxun
 * @date 2020/7/13 22:58
 * @description
 */
public interface Graph {
    //返回节点个数
    int V();

    //返回边的个数
    int E();

    void addEdge(int v, int w);

    //是否存在边
    boolean hasEdge(int v, int w);

    Iterable<Integer> adj(int v);
}
