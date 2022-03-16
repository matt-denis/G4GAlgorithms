package graph;

public class DirectedGraph extends Graph {


    DirectedGraph(int V) {
        super(V);
    }

    @Override
    void addEdge(int v, int w) {
        adj.get(v).add(w);
    }
    
}
