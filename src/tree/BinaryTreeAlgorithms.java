package tree;

import java.util.Deque;
import java.util.Stack;
import java.util.ArrayDeque;

public class BinaryTreeAlgorithms {


    // TODO: implement createTree method using orderLevel traversal


    static void traverseInorder(Node root) {
        for (Node x : inorder(root)) System.out.print(x + " ");
    }

    private static Iterable<Node> inorder(Node root) {
        final Deque<Node> dq = new ArrayDeque<>();
        inorder(root, dq);
        return dq;
    }

    private static void inorder(Node x, Deque<Node> dq) {
        if (x == null) return;
        inorder(x.left);
        dq.addLast(x);
        inorder(x.right, dq);
    }

    static void traversePreorder(Node root) {
        for (Node x : preorder(root)) System.out.print(x + " ");
    }

    private static Iterable<Node> preorder(Node root) {
        final Deque<Node> dq = new ArrayDeque<>();
        preorder(root, dq);
        return dq;
    }

    private static void preorder(Node x, Deque<Node> dq) {
        if (x == null) return;
        dq.addLast(x);
        preorder(x.left, dq);
        preorder(x.right, dq);
    }

    static void traversePostorder(Node root) {
        for (Node x : postorder(root)) System.out.print(x + " ");
    }

    private static Iterable<Node> postorder(Node root) {
        final Deque<Node> dq = new ArrayDeque<>();
        postorder(root, dq);
        return dq;
    }

    private static void postorder(Node x, Deque<Node> dq) {
        if (x == null) return;
        postorder(x.left, dq);
        postorder(x.right, dq);
        dq.addLast(x);
    }

    static int height(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // public method does argument checking
    static void printTreeLevel(Node root, int level) {
        if (level < 0) throw new IllegalArgumentException("level must be non-negative");
        printLevel(root, level);
    }

    private static void printLevel(Node x, int level) {
        if (level == 0) System.out.print(x + " ");
        else {
            printLevel(x.left, level - 1);
            printLevel(x.right, level - 1);
        }
    }

    static Iterable<Node> levelOrder(Node root) {
        Deque<Node> dq = new ArrayDeque<>(), children = new ArrayDeque<>();
        levelOrder(root, dq, children);
        return dq;
    }

    static void levelOrder(Node root, Deque<Node> dq, Deque<Node> children) {
        children.addLast(root);
        while (!children.isEmpty()) {
            Node x = children.removeFirst();
            dq.addLast(x);
            if (x.left != null) children.addLast(x.left);
            if (x.right != null) children.addLast(x.right);
        }
    } 

    static int size(Node x) {
        if (x == null) return 0;
        return 1 + size(x.left) + size(x.right); // TODO: implement with breadth first
    }

    static int maxVal(Node root) {
        int max = Integer.MIN_VALUE;
        for (var e : inorder(root)) max = Math.max(max, e.key);
        return max;
    }

    // direct method
    static int getMax(Node root) {
        if (root == null) return Integer.MIN_VALUE;
        return Math.max(root.key, 
            Math.max(getMax(root.left), getMax(root.right)));
    }

    static void inorderIterative(Node root, Deque<Node> dq, Stack<Node> st) {
        if (root == null) return;
        stackIt(root, st);
        while (!st.isEmpty()) {
            Node lastIn = st.pop();
            dq.addLast(lastIn);
            stackIt(lastIn.right, st);
        }
    }
        
    private static void stackIt(Node root, final Stack<Node> st) {
        if (root == null) return;
        Node walk = root;
        while (walk != null) {
            st.push(walk);
            walk = walk.left;
        }
    }

    static void iterativeInorder(Node root, Deque<Node> dq, Stack<Node> st) {
        Node walk = root;
        while (walk != null || !st.isEmpty()) {
            while (walk != null) {
                st.push(walk);
                walk = walk.left;
            }
            Node x = st.pop();
            dq.addLast(x);
            walk = x.right;
        }
    }

    static void preorderIterative(Node root, Deque<Node> dq, Stack<Node> st) {
        Node walk = root;
        while (walk != null || !st.isEmpty()) {
            while (walk != null) {
                dq.addLast(walk);
                if (walk.right != null) st.push(walk.right);
                walk = walk.left;
            }
            if (!st.isEmpty()) walk = st.pop();
        } 
    }


    public static void main(String[] args) {
        
    }
}