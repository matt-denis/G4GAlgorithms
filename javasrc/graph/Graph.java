package graph;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 * Undirected graph ADT
 */
public class Graph {

    protected ArrayList<ArrayList<Integer>> adj;
    private int V;

    Graph(int V) { 
        adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
    }

    int V() { return V; }

    void addEdge(int v, int w) {
       adj.get(v).add(w);
       adj.get(w).add(v); 
    }
    
    Iterable<Integer> adj(int v) { return adj.get(v); }

    Iterable<Integer> allVertices() {
        return adj.stream()
            .flatMap(list -> list.stream())
            .collect(Collectors.toList());
    }
}