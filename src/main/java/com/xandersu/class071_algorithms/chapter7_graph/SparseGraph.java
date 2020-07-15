package com.xandersu.class071_algorithms.chapter7_graph;

import java.util.ArrayList;
import java.util.Vector;

/**
 * @author suxun
 * @date 2020/7/12 17:04
 * @description 邻接表 - 稀疏图
 */
public class SparseGraph implements Graph {

    //点数
    private int n;
    //边数
    private int m;
    //有向图还是无向图
    private boolean directed;
    // 图的具体数据,存放顶点编号
    private ArrayList<Integer>[] g;

    public SparseGraph(int n, boolean directed) {
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
    }

    //返回节点个数
    public int V() {
        return n;
    }

    //返回边的个数
    public int E() {
        return m;
    }

    public void addEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;

        g[v].add(w);
        //vw不是同一个顶点处理自环边，处理无向图
        if (v != w && !directed) {
            g[w].add(v);
        }
        m++;
    }

    //是否存在边
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        for (int i = 0; i < g[v].size(); i++) {
            if (g[v].get(i) == w) {
                return true;
            }
        }
        return false;
    }

    public void show() {
        for (int i = 0; i < n; i++) {
            System.out.println(i+"->");
            for (int j = 0; j < g[i].size(); j++) {
                System.out.println(g[i].get(j));
            }
            System.out.println();
        }
    }

    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        return g[v];
    }

}
