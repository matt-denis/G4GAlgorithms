package stack;

import java.util.Iterator;

public class LinkedStack implements Iterable<Integer> {

    private class Node {
        int data;
        Node next;
        public Node(int data) { this.data = data; }
    }

    protected static class StackIterator implements Iterator<Integer> {
        Node curr;
        StackIterator(Node head) {
            curr = head;
        }
        @Override
        public boolean hasNext() {
            return (curr == null);
        }
        @Override 
        public Integer next() {
            Integer res = curr.data;
            curr = curr.next;
            return res;
        }
    }
    
    private Node head;
    private int size;

    public int size() throws IllegalStateException { return size; }
    public boolean isEmpty() { return size() == 0; }
    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Underflow");
        return head.data;
    }
    public int pop() throws IllegalStateException {
        int res = peek();
        head = deleteHead();
        size--;
        return res;
    }

    public void push(int data) {
        head = insertHead(data);
        size++;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new StackIterator(head);
    }
    

    private Node insertHead(int data) {
        Node node = this.new Node(data);
        if (head == null) head = node;
        else {
            node.next = head;
            head = node;
        }
        return head;

    }

    private Node deleteHead() {
        return head.next;
    }
}