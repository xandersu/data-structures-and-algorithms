package com.xandersu.class071_algorithms.chapter7_graph;

/**
 * @author suxun
 * @date 2020/7/13 23:12
 * @description 深度优先遍历
 */
public class Component {

    private Graph g;
    //判断是否已经被遍历到
    private boolean[] visited;
    //连通分量的个数
    private int ccount;
    //属于哪个连通分量
    private int[] id;

    public Component(Graph g) {
        this.g = g;
        visited = new boolean[g.V()];
        id = new int[g.V()];

        for (int i = 0; i < g.V(); i++) {
            id[i] = -1;
        }
        for (int i = 0; i < g.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                ccount++;
            }
        }
    }

    //deepFirstSearch
    //将与v向连接所有节点都遍历一遍
    private void dfs(int v) {
        id[v] = ccount;
        visited[v] = true;
        Iterable<Integer> adj = g.adj(v);
        for (Integer i : adj) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    public boolean isConn(int u, int v) {
        return id[u] == id[v];
    }

    public int getCount() {
        return ccount;
    }
}
