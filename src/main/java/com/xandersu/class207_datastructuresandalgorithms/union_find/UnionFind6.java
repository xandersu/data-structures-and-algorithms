package com.xandersu.class207_datastructuresandalgorithms.union_find;

/**
 * @Author: suxun
 * @Date: 2018/11/4 21:02
 * @Description: 并查集
 * 路径压缩2：递归算法，压缩后该节点和其所有父节点都指向根结点
 */
public class UnionFind6 implements MyUF {

    private int[] parent;
    private int[] rank;//rank[i]为根的集合所表示的树的层数

    public UnionFind6(int size) {
        parent = new int[size];
        rank = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    //查询，元素p对应的集合编号
    //O(h) h为树的高度
    private int find(int p) {
        if (p < 0 || p >= parent.length) {
            throw new IllegalArgumentException("wrong index");
        }
        if (p != parent[p]) {
            //路径压缩,递归,宏观
            parent[p] = find(parent[p]);
        }
        return parent[p];
    }

    @Override
    public void unionElements(int p, int q) {
        int pRoot = find(p);
        int qRoot = find(q);
        if (pRoot == qRoot) {
            return;
        }
        //根据两个元素所在树的元素个数不同判断合并方向
        //将rank小的集合合并到rank多的集合上
        if (rank[pRoot] < rank[qRoot]) {
            parent[pRoot] = qRoot;
        } else if (rank[pRoot] > rank[qRoot]) {
            parent[qRoot] = pRoot;
        } else {
            parent[qRoot] = pRoot;
            rank[pRoot] += 1;
        }
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    @Override
    public int getSize() {
        return parent.length;
    }
}
