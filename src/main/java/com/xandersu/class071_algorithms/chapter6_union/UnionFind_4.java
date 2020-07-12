package com.xandersu.class071_algorithms.chapter6_union;

/**
 * @author suxun
 * @date 2020/7/12 15:02
 * @description
 */
public class UnionFind_4 implements IUnionFind {

    private int[] parent;
    //树的高度
    private int[] rank;
    private int count;

    public UnionFind_4(int n) {
        this.count = n;
        parent = new int[n];
        rank = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            rank[i] = 1;
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

        if (rank[parentP] < rank[parentQ]) {
            parent[parentP] = parentQ;
            rank[parentP] = rank[parentP] + 1;
        } else if (rank[parentP] > rank[parentQ]) {
            parent[parentQ] = parentP;
            rank[parentQ] = 1 + rank[parentQ];
        } else {//rank[parentP] == rank[parentQ]
            parent[parentP] = parentQ;
            rank[parentQ] = rank[parentQ] + 1;
        }
    }

    public static void main(String[] args) {

    }
}
