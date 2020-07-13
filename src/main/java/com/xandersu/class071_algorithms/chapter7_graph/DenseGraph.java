package com.xandersu.class071_algorithms.chapter7_graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * @author suxun
 * @date 2020/7/12 17:04
 * @description 邻接矩阵-稠密图
 */
public class DenseGraph implements Graph {
    //点数
    private int n;
    //边数
    private int m;
    //有向图还是无向图
    private boolean directed;
    // 图的具体数据
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        this.n = n;
        // 初始化没有任何边
        this.m = 0;
        this.directed = directed;
        // g初始化为n*n的布尔矩阵, 每一个g[i][j]均为false, 表示没有任和边
        // false为boolean型变量的默认值
        g = new boolean[n][n];
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

        //不关心平行边
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        //无向图
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    //是否存在边
    public boolean hasEdge(int v, int w) {
        assert v >= 0 && v < n;
        assert w >= 0 && w < n;
        return g[v][w];
    }

    public void show() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(g[i][j]);
            }
            System.out.println();
        }
    }

    public Iterable<Integer> adj(int v) {
        assert v >= 0 && v < n;
        Vector<Integer> vector = new Vector<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]) {
                vector.add(i);
            }
        }
        return vector;
    }
}
