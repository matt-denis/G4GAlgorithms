package graph;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class DirectedGraphs {

    private DirectedGraph G;

    DirectedGraphs(DirectedGraph G) {
        this.G = G;
    } 

    boolean detectCycle() {
        int[] indegree = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                indegree[w]++;
            }
        }
        Deque<Integer> dq = new ArrayDeque<>();
        for (int v = 0; v < indegree.length; v++) {
            if (indegree[v] == 0) {
                dq.addLast(v);
                
            }
        }
        int count = 0;
        while (!dq.isEmpty()) {
            int v = dq.removeFirst();
            count++;
            for (int w : G.adj(v)) {
                if (--indegree[w] == 0) dq.addLast(w);
            }
        }
        return count < G.V();    
    }

    public Iterable<Integer> topologicalSortDfs() {
        final boolean[] marked = new boolean[G.V()];
        Stack<Integer> stack = new Stack<>();
        for (int s = 0; s < G.V(); s++) { 
            if (!marked[s]) {
                topologicalSortDfs(s, marked, stack);
            }
        }
        return stack;
    }

    public void topologicalSortDfs(int v, boolean[] marked, Stack<Integer> st) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) topologicalSortDfs(w, marked, st);
        }
        st.push(v);
    }

    public void topologicalSortBfs() {
        boolean[] marked = new boolean[G.V()];
        Stack<Integer> stack = new Stack<>();
        for (int s = 0; s < G.V(); s++) {
            if (!marked[s]) {
                topologicalSortDfs(s, marked, stack);
            }
        }
    }

    public void topologicalSortBfs(int source, boolean[] marked, Stack<Integer> st) {
        Stack<Integer> traversed = new Stack<>();
        Deque<Integer> dq = new ArrayDeque<>();
        dq.addLast(source);
        while (!dq.isEmpty()) {
            int v = dq.removeFirst();
            marked[v] = true;
            traversed.push(v);
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    dq.addLast(w);
                }
            }
        }
        while (!traversed.isEmpty()) {
            st.push(traversed.pop());
        }
    }

    public Iterable<Integer> topologicalSortKahn() {
        int[] indegree = new int[G.V()];
        for (int v = 0; v < G.V(); v++) {
            for (int w : G.adj(v)) {
                indegree[w]++;
            }
        }
        Deque<Integer> sort = new ArrayDeque<>();
        Deque<Integer> dq = new ArrayDeque<>();
        for (int s = 0; s < G.V(); s++) {
            if (indegree[s] == 0) dq.addLast(s);
        }
        topologicalSortKahn(indegree, sort, dq);
        return sort;
    }

    public void topologicalSortKahn(int[] indegree, Deque<Integer> sort, Deque<Integer> dq) {
        while (!dq.isEmpty()) {
            int v = dq.removeFirst();
            for (int w : G.adj(v)) { // adjecents cannot have indegree less than 1 by construction
                if (--indegree[w] == 0) dq.addLast(w);
            }
        }
    }
}
