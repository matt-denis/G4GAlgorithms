package tree;

class Node {
    int key;
    Node left, right;
    
    public Node(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }
}
