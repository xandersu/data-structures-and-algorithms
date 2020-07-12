package com.xandersu.class071_algorithms.chapter6_union;

/**
 * @author suxun
 * @date 2020/7/12 14:44
 * @description 并查集
 * quick find
 */
public class UnionFind_1 implements IUnionFind {

    private int[] id;
    private int count;

    public UnionFind_1(int n) {
        this.count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    @Override
    public int find(int p) {
        assert p >= 0 && p < count;
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) {
        int pID = find(p);
        int qID = find(q);
        if (pID == qID) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pID) {
                id[i] = qID;
            }
        }
    }
}
