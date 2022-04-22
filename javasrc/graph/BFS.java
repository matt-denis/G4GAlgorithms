package graph;

import java.util.Deque;
import java.util.List;
import java.util.ArrayDeque;
import java.util.ArrayList;

public class BFS {

    private Graph G;

    BFS(Graph G) { 
        this.G = G; 
    }

    Graph getGraph() { return G; }

    void setGraph(Graph G) { this.G = G; }

    Iterable<Integer> bfs(int source) {
        final boolean[] marked = new boolean[G.V()];
        Deque<Integer> dq = new ArrayDeque<>();
        marked[source] = true;
        dq.addLast(source);
        Deque<Integer> traversal = new ArrayDeque<>();
        while (!dq.isEmpty()) {
            int v = dq.removeFirst();
            traversal.addLast(v);
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    dq.addLast(w);
                    marked[w] = true;
                }
            }
        }
        return traversal;
    }

    void printTraversal(int source) {
        for (int v : bfs(source)) System.out.print(v + " ");
        System.out.println();
    }

    /**
     * Traverses all components of a graph starting from the first vertex
     * as indexed by an integer, i.e. starting from the index 0 vertex.
     * 
     * @return Iterable of vertices in breadth first order (closest vertices
     * first).
     */
    Iterable<Iterable<Integer>> traverseDisconnected() {
        final boolean[] marked = new boolean[G.V()];
        List<Iterable<Integer>> components = new ArrayList<Iterable<Integer>>();
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                components.add(bfsUtility(s, marked));
            }
        }
        return components;
    }

    private Iterable<Integer> bfsUtility(int source, boolean[] marked) {
        Deque<Integer> dq = new ArrayDeque<>();
        marked[source] = true;
        dq.addLast(source);
        Deque<Integer> traversal = new ArrayDeque<>();
        while (!dq.isEmpty()) {
            int v = dq.removeFirst();
            traversal.addLast(v);
            for (int w : G.adj(v)) {
                marked[w] = true;
                if (!marked[w]) dq.addLast(w);
            }
        }
        return traversal;
    }

    int nrComponents() {
        int components = 0;
        boolean[] marked = new boolean[G.V()];
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                components++;
                bfsUtility(s, marked);
            }
        }
        return components;
    }
    
}
