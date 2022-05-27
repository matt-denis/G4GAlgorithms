package binarysearchtree;

public class BSTAlgorithms {
    
    boolean search(Node node, int key) {
        if (node == null) return false;
        if (key < node.key) return search(node.left, key);
        if (key > node.key) return search(node.right, key);
        return true;
    }

    boolean searchIterative(Node root, int key) {
        Node walk = root;
        while (walk != null) {
            if (key == walk.key) return true;
            if (key < walk.key) walk = walk.left;
            else if (key > walk.key) walk = walk.right;
        }
        return false;
    }

    
    Node insert(Node x, int key) {
        if (x == null) return new Node(key);
        if (key < x.key) x.left = insert(x.left, key);
        else if (key > x.key) x.right = insert(x.right, key);
        return x;
    }

    Node insertIterative(Node root, int key) {
        if (root == null) root = new Node(key);
        else {
            Node walk = root;
            while (true) {
                if (key == walk.key) break;
                if (key < walk.key) {
                    if (walk.left == null) {
                        walk.left = new Node(key);
                        break;
                    }
                    walk = walk.left;
                }
                else {
                    if (walk.right == null) {
                        walk.right = new Node(key);
                        break;
                    }
                    walk = walk.right;
                }
            }
        }
        return root;
    }

    static Node insertRecursiveG4G(Node root, int x){
        Node temp=new Node(x);
        Node parent=null,curr=root;
        while(curr!=null){
            parent=curr;
            if(curr.key>x)
                curr=curr.left;
            else if(curr.key<x)
                curr=curr.right;
            else
                return root;
        }
        if (parent == null) // case where root == null
            return temp;
        if (parent.key > x)
            parent.left = temp;
        else
            parent.right = temp;
        return root;
    }

    //TODO: correct delete
    static Node delete(Node x, int key) {
        if (x == null) return null;
        if (key < x.key) x.left = delete(x.left, key);
        else if (key > x.key) x.right = delete(x.right, key);
        else {
            if (x.left == null || x.right == null) {
                return x.left == null ? x.right : x.left;
            }
            x = deleteMinIterative(x.right);
        }
        return x;
    }

    static Node deleteMinIterative(Node root) {
        if (root == null || root.left == null) {
            return root == null ? null : root.right;
        }
        Node walk = root;
        while (walk.left.left != null) walk = walk.left;
        walk.left = walk.left.right;
        return root;
    }

    static Node deleteMin(Node x) {
        if (x.left == null) return x.right;
        x.left = deleteMin(x.left);
        return x;
    }

    // ************* G4G implementation *****************
    public static Node getSuccessor(Node curr){
        curr=curr.right;
        while(curr!=null && curr.left!=null)
            curr=curr.left;
        return curr;
    }
    
    public static Node delNode(Node root, int x){
        if(root==null)
            return root;
        if(root.key>x)
            root.left=delNode(root.left,x);
        else if(root.key<x)
            root.right=delNode(root.right,x);
        else{
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }
            else{
                Node succ=getSuccessor(root);
                root.key=succ.key;
                root.right=delNode(root.right,succ.key);
            }
        }
        return root;
    }
    // ***************** G4G implementation ***********************

    Node floor(Node x, int key) {
        if (x == null) return null; // search failed
        if (key == x.key) return x;
        if (key < x.key) return floor(x.left, key);
        Node right = floor(x.right, key);
        return right == null ? x : right;

    }

    Node floorIterative(Node root, int key) {
        Node walk = root;
        Node lastCandidate = null;
        while (walk != null) {
            if (key == walk.key) return walk;
            if (key < walk.key) walk = walk.left;
            else {
                lastCandidate = walk;
                walk = walk.right;
            }
        }
        return lastCandidate;
    }

    Node ceiling(Node x, int key) {
        if (x == null) return null;
        if (key == x.key) return x;
        if (key > x.key) return ceiling(x.right, key);
        Node left = ceiling(x.left, key);
        return left == null ? x : left;
    }

    Node ceilingIterative(Node root, int key) {
        Node walk = root;
        Node lastCandidate = null;
        while (walk != null) {
            if (key == walk.key) return walk;
            if (key > walk.key) walk = walk.left;
            else {
                lastCandidate = walk;
                walk = walk.left;
            }
        }
        return lastCandidate;
    }
}

class Node {
    int key;
    Node left, right;
    Node (int key) { this.key = key; }
    @Override
    public String toString() { return String.valueOf(key); }
}
