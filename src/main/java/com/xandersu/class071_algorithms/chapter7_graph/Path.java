package com.xandersu.class071_algorithms.chapter7_graph;

import java.util.Vector;

/**
 * @author suxun
 * @date 2020/7/15 08:14
 * @description
 */
public class Path {

    private int s;
    private Graph g;
    private boolean[] visited;
    private int[] from;


    public Path(Graph g, int s) {
        this.s = s;
        this.g = g;
        visited = new boolean[g.V()];
        from = new int[g.V()];
        for (int i = 0; i < g.V(); i++) {
            from[i] = -1;
        }
        this.s = s;
        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        Iterable<Integer> adj = g.adj(v);
        for (Integer i : adj) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

    public boolean hasPath(int w) {
        return visited[w];
    }

    public void path(int w, Vector<Integer> vec) {
        int p = w;
        Vector<Integer> v = new Vector<>();
        while (p != -1) {
            v.add(p);
            p = from[p];
        }
        while (!v.isEmpty()) {
            vec.add(v.remove(v.size() - 1));
        }
    }

    public void showPath(int w) {
        Vector<Integer> vec = new Vector<>();
        path(w, vec);
        System.out.println(vec.toString());
    }

}
