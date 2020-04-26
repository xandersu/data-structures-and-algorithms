package com.xandersu.class207_datastructuresandalgorithms.union_find;

/**
 * @Author: suxun
 * @Date: 2018/11/4 18:50
 * @Description: 第一版uf
 * 1、union(p,q)--------O(n)
 * 2、isConnected(p,q)--O(1)
 */
public class UnionFind1 implements MyUF {

    private int[] id;

    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }

    //查找P对应的集合编号
    private int find(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("wrong index");
        }
        return id[p];
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

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int getSize() {
        return id.length;
    }
}
