package com.xandersu.class071_algorithms.chapter6_union;

/**
 * @author suxun
 * @date 2020/7/12 15:02
 * @description
 */
public class UnionFind_2 implements IUnionFind {

    private int[] parent;
    private int count;

    public UnionFind_2(int n) {
        this.count = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int find(int p) {
        int temp = p;
        while (parent[temp] != temp) {
            temp = parent[temp];
        }
        return temp;
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int parentP = find(p);
        int parentQ = find(q);

        parent[parentP] = parentQ;
    }

    public static void main(String[] args) {

    }
}
