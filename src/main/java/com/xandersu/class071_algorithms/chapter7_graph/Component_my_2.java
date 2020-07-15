package com.xandersu.class071_algorithms.chapter7_graph;

/**
 * @author suxun
 * @date 2020/7/15 07:56
 * @description
 */
public class Component_my_2 {
    private Graph g;
    private boolean[] visited;
    private int[] id;
    private int ccount;

    public Component_my_2(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        id = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            id[i] = -1;
        }
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dsf(i);
                ccount++;
            }
        }
    }

    private void dsf(int v) {
        visited[v] = true;
        id[v] = ccount;
        Iterable<Integer> adj = g.adj(v);
        for (Integer i : adj) {
            if (!visited[i]) {
                dsf(i);
            }
        }
    }

    public boolean isConn(int i, int j) {
        return id[i] == id[j];
    }

    public int count() {
        return ccount;
    }
}
