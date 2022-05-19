package tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class IterativeTraversals {
    
    public Iterable<Node> postorderQueueStack(Node root) {
        Queue<Node> queue = new ArrayDeque<>();
        Deque<Node> stack = new LinkedList<>();
        if (root == null) return stack;
        queue.add(root);
        Node walk;
        while (!queue.isEmpty()) {
            walk = queue.remove();
            stack.push(walk);
            if (walk.right != null) stack.push(walk.right);
            if (walk.left != null) stack.push(walk.left); 
        }
        return stack;
    }

    public Iterable<Node> postorderTwoStacks(Node root) {
        Deque<Node> stack = new ArrayDeque<>();
        Deque<Node> traversal = new ArrayDeque<>();
        if (root == null) return traversal;
        stack.push(root);
        Node walk;
        while (!stack.isEmpty()) {
            walk = stack.pop();
            traversal.push(walk);
            if (walk.left != null) stack.push(walk.left);
            if (walk.right != null) stack.push(walk.right);
        }
        return traversal;
    }
}
