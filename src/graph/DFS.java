package graph;

import java.util.ArrayDeque;
import java.util.Deque;

public class DFS {

    private Graph G;

    DFS(Graph G) {
        this.G = G;
    }

    Graph getGraph() { return G; }

    void setGraph(Graph G) {
        this.G = G;
    }
    
    Iterable<Integer> dfs(int source) {
        boolean[] marked = new boolean[G.V()];
        Deque<Integer> dq = new ArrayDeque<>();
        dfs(source, marked, dq);
        return dq;
    }

    private void dfs(int v, boolean[] marked, Deque<Integer> dq) {
        marked[v] = true;
        dq.addLast(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfs(w, marked, dq);
            }
        }
    } 

    void printTraversal(int source) {
        for (int v : dfs(source)) System.out.print(v + " ");
        System.out.println();
    }

    /**
     * Traverses all components of a graph starting from the first vertex
     * as indexed by an integer, i.e. starting from the index 0 vertex.
     * 
     * @return Iterable of vertices in depth first order (closest vertices
     * first).
     */
    Iterable<Iterable<Integer>> traverseDisconnected() {
        Deque<Iterable<Integer>> components = new ArrayDeque<>();
        boolean[] marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                Deque<Integer> dq = new ArrayDeque<>();
                dfsUtility(s, marked, dq);
                components.addLast(dq);
            }
        }
        return components;
    }

    private void dfsUtility(int v, boolean[] marked, Deque<Integer> dq) {
        marked[v] = true;
        dq.addLast(v);
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                dfsUtility(v, marked, dq);
            }
        }
    }

    int nrComponents() {
        int components = 0;
        boolean[] marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                ++components;
                visitComponent(s, marked);
            }
        }
        return components;
    }

    private void visitComponent(int v, boolean[] marked) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) visitComponent(v, marked);
        }
    }

    boolean hasCycle() {
        boolean[] marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s] && hasCycle(s, -1, marked)) return true;
        }
        return false;
    }

    private boolean hasCycle(int v, int parent, boolean[] marked) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                if (hasCycle(w, parent, marked))
                    return true;
            }
            else if (w != parent) return true;
        }
        return false;
    }

    boolean hasCycleDirected() { 
        if (! (G instanceof DirectedGraph)) throw new IllegalArgumentException();
        boolean[] marked = new boolean[G.V()];
        boolean[] callStack = new boolean[G.V()]; 
        boolean hasCycle = false;
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                hasCycle = hasCycleDirected(s, marked, callStack);
            }
            if (hasCycle) return true;
        }
        return false;
    }

    private boolean hasCycleDirected(int v, boolean[] marked, boolean[] callStack) {
        marked[v] = true;
        callStack[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w] && hasCycleDirected(w, marked, callStack)) return true;
            else if (callStack[w]) return true;
        }
        callStack[v] = false;
        return false;
    }
}
