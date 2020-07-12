package com.xandersu.class071_algorithms.chapter6_union;

/**
 * @author suxun
 * @date 2020/7/12 15:09
 * @description
 */
public interface IUnionFind {
    int find(int p);

    default boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    void unionElements(int p, int q);

}
