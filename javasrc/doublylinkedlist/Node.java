package doublylinkedlist;

import java.util.Objects;

class Node {
    int data;
    Node prev;
    Node next;
    public Node(int data) {
        this.data = data;
    }
    @Override
    public String toString() { return Objects.toString(data); }
}